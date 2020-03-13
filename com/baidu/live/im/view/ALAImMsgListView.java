package com.baidu.live.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.im.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALAImMsgListView extends BdTypeListView implements h {
    private boolean asN;
    private com.baidu.live.im.a.a aud;
    private boolean aue;
    private boolean auf;
    private Paint aug;
    private a auh;
    private boolean aui;
    private boolean isScrolling;
    private int mLastMotionX;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes3.dex */
    public interface a {
        void xM();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aue = true;
        this.auf = false;
        this.showShadow = false;
        this.aui = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aue = true;
        this.auf = false;
        this.showShadow = false;
        this.aui = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aue = true;
        this.auf = false;
        this.showShadow = false;
        this.aui = false;
        init();
    }

    public void setMode(boolean z) {
        this.aud.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aud == null) {
            this.aud = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.e.sdk_ds10));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.im.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.showShadow && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.showShadow = true;
                }
                if (i == 1) {
                    ALAImMsgListView.this.aui = true;
                } else if (i == 0 && ALAImMsgListView.this.aui) {
                    ALAImMsgListView.this.aui = false;
                    ALAImMsgListView.this.xJ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aud != null) {
            this.aud.setDatas(list);
            this.aud.notifyDataSetChanged();
        }
    }

    public boolean xI() {
        return this.auf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.auf = false;
            if (this.auh != null) {
                this.auh.xM();
            }
        } else {
            this.auf = true;
        }
        this.aue = this.auf ? false : true;
    }

    public void xK() {
        this.isScrolling = false;
        this.aue = true;
        this.auf = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.h
    public void wp() {
        if (!this.isScrolling && this.aue) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void wL() {
        this.showShadow = false;
        this.auf = false;
        if (this.aud != null) {
            this.aud.wL();
        }
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aud != null) {
            this.aud.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aug = new Paint();
            this.aug.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aug.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aug.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aug = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void xL() {
        this.auf = false;
        this.aue = true;
        if (this.aud != null) {
            this.aud.release();
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aug != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aug);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.aue = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aue = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            xJ();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.asN = z;
        if (this.aud != null) {
            this.aud.setFromMaster(this.asN);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.auh = aVar;
    }
}

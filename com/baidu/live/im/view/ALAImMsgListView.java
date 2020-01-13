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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class ALAImMsgListView extends BdTypeListView implements h {
    private boolean apu;
    private com.baidu.live.im.a.a aqs;
    private boolean aqt;
    private boolean aqu;
    private Paint aqv;
    private a aqw;
    private boolean aqx;
    private boolean isScrolling;
    private int mLastMotionX;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes2.dex */
    public interface a {
        void vN();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aqt = true;
        this.aqu = false;
        this.showShadow = false;
        this.aqx = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aqt = true;
        this.aqu = false;
        this.showShadow = false;
        this.aqx = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aqt = true;
        this.aqu = false;
        this.showShadow = false;
        this.aqx = false;
        init();
    }

    public void setMode(boolean z) {
        this.aqs.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aqs == null) {
            this.aqs = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.aqx = true;
                } else if (i == 0 && ALAImMsgListView.this.aqx) {
                    ALAImMsgListView.this.aqx = false;
                    ALAImMsgListView.this.vK();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aqs != null) {
            this.aqs.setDatas(list);
            this.aqs.notifyDataSetChanged();
        }
    }

    public boolean vJ() {
        return this.aqu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.aqu = false;
            if (this.aqw != null) {
                this.aqw.vN();
            }
        } else {
            this.aqu = true;
        }
        this.aqt = this.aqu ? false : true;
    }

    public void vL() {
        this.isScrolling = false;
        this.aqt = true;
        this.aqu = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.h
    public void uL() {
        if (!this.isScrolling && this.aqt) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void vh() {
        this.showShadow = false;
        this.aqu = false;
        if (this.aqs != null) {
            this.aqs.vh();
        }
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aqs != null) {
            this.aqs.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aqv = new Paint();
            this.aqv.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aqv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aqv.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aqv = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void vM() {
        this.aqu = false;
        this.aqt = true;
        if (this.aqs != null) {
            this.aqs.release();
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
        if (this.aqv != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aqv);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.aqt = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aqt = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            vK();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.apu = z;
        if (this.aqs != null) {
            this.aqs.setFromMaster(this.apu);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aqw = aVar;
    }
}

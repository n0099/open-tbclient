package com.baidu.live.yuyinim.view;

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
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private com.baidu.live.yuyinim.a.a bSe;
    private a bSf;
    private int bhX;
    private boolean biV;
    private Paint bkA;
    private boolean bkC;
    private boolean bky;
    private boolean bkz;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void Mo();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        init();
    }

    public void setMode(boolean z) {
        this.bSe.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bSe == null) {
            this.bSe = new com.baidu.live.yuyinim.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.d.sdk_ds8));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.yuyinim.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.showShadow && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.showShadow = true;
                }
                if (i == 1) {
                    ALAImMsgListView.this.bkC = true;
                } else if (i == 0 && ALAImMsgListView.this.bkC) {
                    ALAImMsgListView.this.bkC = false;
                    ALAImMsgListView.this.Ml();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bSe != null) {
            this.bSe.setDatas(list);
            this.bSe.notifyDataSetChanged();
        }
    }

    public boolean Mk() {
        return this.bkz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ml() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bkz = false;
            if (this.bSf != null) {
                this.bSf.Mo();
            }
        } else {
            this.bkz = true;
        }
        this.bky = this.bkz ? false : true;
    }

    public void Mm() {
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void KZ() {
        if (!this.isScrolling && this.bky) {
            post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Kj() {
        this.showShadow = false;
        this.bkz = false;
        if (this.bSe != null) {
            this.bSe.Kj();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bSe != null) {
            this.bSe.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bkA = new Paint();
            this.bkA.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bkA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bkA.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bkA = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Mn() {
        this.bkz = false;
        this.bky = true;
        if (this.bSe != null) {
            this.bSe.release();
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bkA != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bkA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bhX = x;
            this.mLastMotionY = y;
            this.bky = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bhX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bky = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Ml();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.biV = z;
        if (this.bSe != null) {
            this.bSe.setFromMaster(this.biV);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bSf = aVar;
    }
}

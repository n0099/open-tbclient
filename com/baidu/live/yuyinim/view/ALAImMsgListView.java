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
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private com.baidu.live.yuyinim.a.a bXu;
    private a bXv;
    private int bmn;
    private boolean bnn;
    private boolean bpH;
    private boolean bpI;
    private Paint bpJ;
    private boolean bpL;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void OJ();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        init();
    }

    public void setMode(boolean z) {
        this.bXu.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bXu == null) {
            this.bXu = new com.baidu.live.yuyinim.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bpL = true;
                } else if (i == 0 && ALAImMsgListView.this.bpL) {
                    ALAImMsgListView.this.bpL = false;
                    ALAImMsgListView.this.OG();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        if (this.bXu != null) {
            this.bXu.setDatas(list);
            this.bXu.notifyDataSetChanged();
        }
    }

    public boolean OF() {
        return this.bpI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bpI = false;
            if (this.bXv != null) {
                this.bXv.OJ();
            }
        } else {
            this.bpI = true;
        }
        this.bpH = this.bpI ? false : true;
    }

    public void OH() {
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Nc() {
        if (!this.isScrolling && this.bpH) {
            post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Ml() {
        this.showShadow = false;
        this.bpI = false;
        if (this.bXu != null) {
            this.bXu.Ml();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.bXu != null) {
            this.bXu.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bpJ = new Paint();
            this.bpJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bpJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bpJ.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bpJ = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void OI() {
        this.bpI = false;
        this.bpH = true;
        if (this.bXu != null) {
            this.bXu.release();
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
        if (this.bpJ != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bpJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bmn = x;
            this.mLastMotionY = y;
            this.bpH = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bmn - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bpH = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            OG();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bXu != null) {
            this.bXu.setFromMaster(this.bnn);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bXv = aVar;
    }
}

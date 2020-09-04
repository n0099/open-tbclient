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
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes7.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private int baR;
    private boolean bbE;
    private com.baidu.live.im.a.a bcR;
    private boolean bcS;
    private boolean bcT;
    private Paint bcU;
    private a bcV;
    private boolean bcW;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes7.dex */
    public interface a {
        void Kr();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bcS = true;
        this.bcT = false;
        this.showShadow = false;
        this.bcW = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bcS = true;
        this.bcT = false;
        this.showShadow = false;
        this.bcW = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bcS = true;
        this.bcT = false;
        this.showShadow = false;
        this.bcW = false;
        init();
    }

    public void setMode(boolean z) {
        this.bcR.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bcR == null) {
            this.bcR = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.e.sdk_ds8));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.im.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.showShadow && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.showShadow = true;
                    ALAImMsgListView.this.invalidate();
                }
                if (i == 1) {
                    ALAImMsgListView.this.bcW = true;
                } else if (i == 0 && ALAImMsgListView.this.bcW) {
                    ALAImMsgListView.this.bcW = false;
                    ALAImMsgListView.this.Ko();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bcR != null) {
            this.bcR.setDatas(list);
            this.bcR.notifyDataSetChanged();
        }
    }

    public boolean Kn() {
        return this.bcT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bcT = false;
            if (this.bcV != null) {
                this.bcV.Kr();
            }
        } else {
            this.bcT = true;
        }
        this.bcS = this.bcT ? false : true;
    }

    public void Kp() {
        this.isScrolling = false;
        this.bcS = true;
        this.bcT = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Je() {
        if (!this.isScrolling && this.bcS) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Ju() {
        this.showShadow = false;
        this.bcT = false;
        if (this.bcR != null) {
            this.bcR.Ju();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bcR != null) {
            this.bcR.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.bcU = new Paint();
            this.bcU.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bcU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bcU.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bcU = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Kq() {
        this.bcT = false;
        this.bcS = true;
        if (this.bcR != null) {
            this.bcR.release();
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
        if (this.bcU != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bcU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.baR = x;
            this.mLastMotionY = y;
            this.bcS = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.baR - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bcS = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Ko();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bbE = z;
        if (this.bcR != null) {
            this.bcR.setFromMaster(this.bbE);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bcV = aVar;
    }
}

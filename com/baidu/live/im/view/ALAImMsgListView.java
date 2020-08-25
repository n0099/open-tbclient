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
    private int baP;
    private boolean bbC;
    private com.baidu.live.im.a.a bcP;
    private boolean bcQ;
    private boolean bcR;
    private Paint bcS;
    private a bcT;
    private boolean bcU;
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
        this.bcQ = true;
        this.bcR = false;
        this.showShadow = false;
        this.bcU = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bcQ = true;
        this.bcR = false;
        this.showShadow = false;
        this.bcU = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bcQ = true;
        this.bcR = false;
        this.showShadow = false;
        this.bcU = false;
        init();
    }

    public void setMode(boolean z) {
        this.bcP.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bcP == null) {
            this.bcP = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bcU = true;
                } else if (i == 0 && ALAImMsgListView.this.bcU) {
                    ALAImMsgListView.this.bcU = false;
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
        if (this.bcP != null) {
            this.bcP.setDatas(list);
            this.bcP.notifyDataSetChanged();
        }
    }

    public boolean Kn() {
        return this.bcR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bcR = false;
            if (this.bcT != null) {
                this.bcT.Kr();
            }
        } else {
            this.bcR = true;
        }
        this.bcQ = this.bcR ? false : true;
    }

    public void Kp() {
        this.isScrolling = false;
        this.bcQ = true;
        this.bcR = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Je() {
        if (!this.isScrolling && this.bcQ) {
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
        this.bcR = false;
        if (this.bcP != null) {
            this.bcP.Ju();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bcP != null) {
            this.bcP.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.bcS = new Paint();
            this.bcS.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bcS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bcS.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bcS = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Kq() {
        this.bcR = false;
        this.bcQ = true;
        if (this.bcP != null) {
            this.bcP.release();
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
        if (this.bcS != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bcS);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.baP = x;
            this.mLastMotionY = y;
            this.bcQ = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.baP - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bcQ = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Ko();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bbC = z;
        if (this.bcP != null) {
            this.bcP.setFromMaster(this.bbC);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bcT = aVar;
    }
}

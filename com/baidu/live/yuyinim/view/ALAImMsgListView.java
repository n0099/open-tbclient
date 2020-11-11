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
    private com.baidu.live.yuyinim.a.a bTO;
    private a bTP;
    private int bjL;
    private boolean bkG;
    private boolean bmj;
    private boolean bmk;
    private Paint bml;
    private boolean bmn;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void MX();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        init();
    }

    public void setMode(boolean z) {
        this.bTO.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bTO == null) {
            this.bTO = new com.baidu.live.yuyinim.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bmn = true;
                } else if (i == 0 && ALAImMsgListView.this.bmn) {
                    ALAImMsgListView.this.bmn = false;
                    ALAImMsgListView.this.MU();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bTO != null) {
            this.bTO.setDatas(list);
            this.bTO.notifyDataSetChanged();
        }
    }

    public boolean MT() {
        return this.bmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bmk = false;
            if (this.bTP != null) {
                this.bTP.MX();
            }
        } else {
            this.bmk = true;
        }
        this.bmj = this.bmk ? false : true;
    }

    public void MV() {
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void LI() {
        if (!this.isScrolling && this.bmj) {
            post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void KS() {
        this.showShadow = false;
        this.bmk = false;
        if (this.bTO != null) {
            this.bTO.KS();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bTO != null) {
            this.bTO.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bml = new Paint();
            this.bml.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bml.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bml.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bml = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void MW() {
        this.bmk = false;
        this.bmj = true;
        if (this.bTO != null) {
            this.bTO.release();
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
        if (this.bml != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bml);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bjL = x;
            this.mLastMotionY = y;
            this.bmj = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bjL - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bmj = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            MU();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bTO != null) {
            this.bTO.setFromMaster(this.bkG);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bTP = aVar;
    }
}

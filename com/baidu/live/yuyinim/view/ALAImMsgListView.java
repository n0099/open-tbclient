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
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes10.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private com.baidu.live.yuyinim.a.a bZn;
    private a bZo;
    private int bjf;
    private boolean bkh;
    private float bmA;
    private float bmB;
    private boolean bmD;
    private boolean bmE;
    private Paint bmF;
    private int bmG;
    private boolean bmI;
    private int direction;
    private boolean isScrolling;
    private int mLastMotionY;
    private boolean showShadow;

    /* loaded from: classes10.dex */
    public interface a {
        void Kt();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bmD = true;
        this.bmE = false;
        this.showShadow = false;
        this.bmI = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bmD = true;
        this.bmE = false;
        this.showShadow = false;
        this.bmI = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bmD = true;
        this.bmE = false;
        this.showShadow = false;
        this.bmI = false;
        init();
    }

    public void setMode(boolean z) {
        this.bZn.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bZn == null) {
            this.bZn = new com.baidu.live.yuyinim.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bmI = true;
                } else if (i == 0 && ALAImMsgListView.this.bmI) {
                    ALAImMsgListView.this.bmI = false;
                    ALAImMsgListView.this.Kr();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        if (this.bZn != null) {
            this.bZn.setDatas(list);
            this.bZn.notifyDataSetChanged();
        }
    }

    public boolean Kq() {
        return this.bmE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bmE = false;
            if (this.bZo != null) {
                this.bZo.Kt();
            }
        } else {
            this.bmE = true;
        }
        this.bmD = this.bmE ? false : true;
    }

    public void Ks() {
        this.isScrolling = false;
        this.bmD = true;
        this.bmE = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void IE() {
        if (!this.isScrolling && this.bmD) {
            post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void HN() {
        this.showShadow = false;
        this.bmE = false;
        if (this.bZn != null) {
            this.bZn.HN();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.bZn != null) {
            this.bZn.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.bmG = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bmF = new Paint();
            this.bmF.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bmF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bmF.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.bmG, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.bmG = 0;
            this.bmF = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Jl() {
        this.bmE = false;
        this.bmD = true;
        if (this.bZn != null) {
            this.bZn.release();
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
        if (this.bmF != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.bmG, this.bmF);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bjf = x;
            this.mLastMotionY = y;
            this.bmA = motionEvent.getX();
            this.bmB = motionEvent.getY();
            this.direction = 0;
            this.bmD = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bmA - x) > 20.0f || Math.abs(this.bmB - y) > 20.0f) {
                this.bmD = false;
            }
            if (this.direction == 0 && (Math.abs(x - this.bmA) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bmB) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bmB) * 0.5f > Math.abs(x - this.bmA)) {
                    this.direction = 1;
                    if (y > this.bmB) {
                        if (!canScrollVertically(-1)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                    } else if (!canScrollVertically(1)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                } else {
                    this.direction = 2;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Kr();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bkh = z;
        if (this.bZn != null) {
            this.bZn.setFromMaster(this.bkh);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bZo = aVar;
    }
}

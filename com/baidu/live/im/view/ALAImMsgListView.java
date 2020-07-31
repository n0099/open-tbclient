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
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private int aVA;
    private boolean aWn;
    private boolean aXA;
    private boolean aXB;
    private Paint aXC;
    private a aXD;
    private boolean aXE;
    private com.baidu.live.im.a.a aXz;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void EM();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aXA = true;
        this.aXB = false;
        this.showShadow = false;
        this.aXE = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aXA = true;
        this.aXB = false;
        this.showShadow = false;
        this.aXE = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aXA = true;
        this.aXB = false;
        this.showShadow = false;
        this.aXE = false;
        init();
    }

    public void setMode(boolean z) {
        this.aXz.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aXz == null) {
            this.aXz = new com.baidu.live.im.a.a(tbPageContext, this);
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
                }
                if (i == 1) {
                    ALAImMsgListView.this.aXE = true;
                } else if (i == 0 && ALAImMsgListView.this.aXE) {
                    ALAImMsgListView.this.aXE = false;
                    ALAImMsgListView.this.EJ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aXz != null) {
            this.aXz.setDatas(list);
            this.aXz.notifyDataSetChanged();
        }
    }

    public boolean EI() {
        return this.aXB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EJ() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.aXB = false;
            if (this.aXD != null) {
                this.aXD.EM();
            }
        } else {
            this.aXB = true;
        }
        this.aXA = this.aXB ? false : true;
    }

    public void EK() {
        this.isScrolling = false;
        this.aXA = true;
        this.aXB = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void DB() {
        if (!this.isScrolling && this.aXA) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void DR() {
        this.showShadow = false;
        this.aXB = false;
        if (this.aXz != null) {
            this.aXz.DR();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aXz != null) {
            this.aXz.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aXC = new Paint();
            this.aXC.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aXC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aXC.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aXC = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void EL() {
        this.aXB = false;
        this.aXA = true;
        if (this.aXz != null) {
            this.aXz.release();
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
        if (this.aXC != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aXC);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aVA = x;
            this.mLastMotionY = y;
            this.aXA = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.aVA - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aXA = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            EJ();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.aWn = z;
        if (this.aXz != null) {
            this.aXz.setFromMaster(this.aWn);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aXD = aVar;
    }
}

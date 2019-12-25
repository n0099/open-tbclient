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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class ALAImMsgListView extends BdTypeListView implements h {
    private boolean aoH;
    private com.baidu.live.im.a.a apG;
    private boolean apH;
    private boolean apI;
    private Paint apJ;
    private a apK;
    private boolean apL;
    private boolean isScrolling;
    private int mLastMotionX;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes2.dex */
    public interface a {
        void vw();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.apH = true;
        this.apI = false;
        this.showShadow = false;
        this.apL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.apH = true;
        this.apI = false;
        this.showShadow = false;
        this.apL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.apH = true;
        this.apI = false;
        this.showShadow = false;
        this.apL = false;
        init();
    }

    public void setMode(boolean z) {
        this.apG.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.apG == null) {
            this.apG = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.apL = true;
                } else if (i == 0 && ALAImMsgListView.this.apL) {
                    ALAImMsgListView.this.apL = false;
                    ALAImMsgListView.this.vt();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.apG != null) {
            this.apG.setDatas(list);
            this.apG.notifyDataSetChanged();
        }
    }

    public boolean vs() {
        return this.apI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.apI = false;
            if (this.apK != null) {
                this.apK.vw();
            }
        } else {
            this.apI = true;
        }
        this.apH = this.apI ? false : true;
    }

    public void vu() {
        this.isScrolling = false;
        this.apH = true;
        this.apI = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.h
    public void uu() {
        if (!this.isScrolling && this.apH) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void uQ() {
        this.showShadow = false;
        this.apI = false;
        if (this.apG != null) {
            this.apG.uQ();
        }
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        if (this.apG != null) {
            this.apG.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.apJ = new Paint();
            this.apJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.apJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.apJ.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.apJ = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void vv() {
        this.apI = false;
        this.apH = true;
        if (this.apG != null) {
            this.apG.release();
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
        if (this.apJ != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.apJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            this.apH = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.mLastMotionX - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.apH = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            vt();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.aoH = z;
        if (this.apG != null) {
            this.apG.setFromMaster(this.aoH);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.apK = aVar;
    }
}

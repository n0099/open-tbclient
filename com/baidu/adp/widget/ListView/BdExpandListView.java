package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdExpandListView extends BdListView {
    private View auR;
    private int auS;
    private float auT;
    private float auU;
    private b auV;
    private boolean auW;
    private float auX;
    private float auY;
    private final int auZ;
    private final int ava;
    public a avb;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void L(float f);

        void onRefresh();

        void su();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auW = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auZ = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.ava = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auR = view;
        this.auS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auU = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auR.getHeight();
                    this.auT = this.auU;
                    this.auX = this.auY;
                    this.auV = new b(0, height, 0, this.ava + height);
                    break;
                case 1:
                case 3:
                    if (this.auW) {
                        ss();
                    } else {
                        this.avb.su();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auR.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auR.getWidth(), BdExpandListView.this.auS));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auY - this.auX;
                    float f2 = this.auU - this.auT;
                    this.auX = this.auY;
                    if (this.auR.getParent() == this && this.auV != null && this.auR.isShown() && this.auR.getTop() >= 0 && Math.abs(f2) >= this.auZ && Math.abs(f) < this.auZ) {
                        int M = this.auV.M(this.auU - this.auT);
                        if (M > this.auV.startY && M <= this.auV.endY) {
                            this.auW = true;
                            this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), M));
                            K(M - this.auV.startY);
                            break;
                        } else if (M <= this.auV.startY) {
                            this.auW = false;
                            break;
                        } else if (M > this.auV.endY) {
                            this.auW = true;
                            break;
                        } else {
                            this.auW = false;
                            break;
                        }
                    } else {
                        this.auW = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.auW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ss() {
        if (this.auV != null) {
            if (this.auR.getHeight() >= this.auV.endY - (this.ava / 2)) {
                st();
            } else {
                this.avb.su();
            }
            this.mScroller.startScroll(0, this.auR.getHeight(), 0, this.auV.startY - this.auR.getHeight(), 200);
            invalidate();
            this.auW = false;
        }
    }

    public void st() {
        if (this.avb != null) {
            this.avb.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.avb = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void K(float f) {
        this.avb.L(360.0f - ((f * 360.0f) / this.ava));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int M(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

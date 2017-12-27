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
    private View auP;
    private int auQ;
    private float auR;
    private float auS;
    private b auT;
    private boolean auU;
    private float auV;
    private float auW;
    private final int auX;
    private final int auY;
    public a auZ;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void L(float f);

        void onRefresh();

        void st();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auU = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auX = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auP = view;
        this.auQ = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auS = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auP.getHeight();
                    this.auR = this.auS;
                    this.auV = this.auW;
                    this.auT = new b(0, height, 0, this.auY + height);
                    break;
                case 1:
                case 3:
                    if (this.auU) {
                        sr();
                    } else {
                        this.auZ.st();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auP.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auP.getWidth(), BdExpandListView.this.auQ));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auW - this.auV;
                    float f2 = this.auS - this.auR;
                    this.auV = this.auW;
                    if (this.auP.getParent() == this && this.auT != null && this.auP.isShown() && this.auP.getTop() >= 0 && Math.abs(f2) >= this.auX && Math.abs(f) < this.auX) {
                        int M = this.auT.M(this.auS - this.auR);
                        if (M > this.auT.startY && M <= this.auT.endY) {
                            this.auU = true;
                            this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), M));
                            K(M - this.auT.startY);
                            break;
                        } else if (M <= this.auT.startY) {
                            this.auU = false;
                            break;
                        } else if (M > this.auT.endY) {
                            this.auU = true;
                            break;
                        } else {
                            this.auU = false;
                            break;
                        }
                    } else {
                        this.auU = false;
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
        if (this.auU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sr() {
        if (this.auT != null) {
            if (this.auP.getHeight() >= this.auT.endY - (this.auY / 2)) {
                ss();
            } else {
                this.auZ.st();
            }
            this.mScroller.startScroll(0, this.auP.getHeight(), 0, this.auT.startY - this.auP.getHeight(), 200);
            invalidate();
            this.auU = false;
        }
    }

    public void ss() {
        if (this.auZ != null) {
            this.auZ.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.auZ = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void K(float f) {
        this.auZ.L(360.0f - ((f * 360.0f) / this.auY));
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

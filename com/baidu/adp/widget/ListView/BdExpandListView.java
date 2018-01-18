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
    private View auO;
    private int auP;
    private float auQ;
    private float auR;
    private b auS;
    private boolean auT;
    private float auU;
    private float auV;
    private final int auW;
    private final int auX;
    public a auY;
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
        this.auT = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auO = view;
        this.auP = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auO.getHeight();
                    this.auQ = this.auR;
                    this.auU = this.auV;
                    this.auS = new b(0, height, 0, this.auX + height);
                    break;
                case 1:
                case 3:
                    if (this.auT) {
                        sr();
                    } else {
                        this.auY.st();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auO.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auO.getWidth(), BdExpandListView.this.auP));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auV - this.auU;
                    float f2 = this.auR - this.auQ;
                    this.auU = this.auV;
                    if (this.auO.getParent() == this && this.auS != null && this.auO.isShown() && this.auO.getTop() >= 0 && Math.abs(f2) >= this.auW && Math.abs(f) < this.auW) {
                        int M = this.auS.M(this.auR - this.auQ);
                        if (M > this.auS.startY && M <= this.auS.endY) {
                            this.auT = true;
                            this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), M));
                            K(M - this.auS.startY);
                            break;
                        } else if (M <= this.auS.startY) {
                            this.auT = false;
                            break;
                        } else if (M > this.auS.endY) {
                            this.auT = true;
                            break;
                        } else {
                            this.auT = false;
                            break;
                        }
                    } else {
                        this.auT = false;
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
        if (this.auT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sr() {
        if (this.auS != null) {
            if (this.auO.getHeight() >= this.auS.endY - (this.auX / 2)) {
                ss();
            } else {
                this.auY.st();
            }
            this.mScroller.startScroll(0, this.auO.getHeight(), 0, this.auS.startY - this.auO.getHeight(), 200);
            invalidate();
            this.auT = false;
        }
    }

    public void ss() {
        if (this.auY != null) {
            this.auY.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.auY = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void K(float f) {
        this.auY.L(360.0f - ((f * 360.0f) / this.auX));
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

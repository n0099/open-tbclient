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
    private View auD;
    private int auE;
    private float auF;
    private float auG;
    private b auH;
    private boolean auI;
    private float auJ;
    private float auK;
    private final int auL;
    private final int auM;
    public a auN;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void P(float f);

        void onRefresh();

        void ss();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auI = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auL = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auM = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auD = view;
        this.auE = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auG = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auD.getHeight();
                    this.auF = this.auG;
                    this.auJ = this.auK;
                    this.auH = new b(0, height, 0, this.auM + height);
                    break;
                case 1:
                case 3:
                    if (this.auI) {
                        sq();
                    } else {
                        this.auN.ss();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auD.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auD.getWidth(), BdExpandListView.this.auE));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auK - this.auJ;
                    float f2 = this.auG - this.auF;
                    this.auJ = this.auK;
                    if (this.auD.getParent() == this && this.auH != null && this.auD.isShown() && this.auD.getTop() >= 0 && Math.abs(f2) >= this.auL && Math.abs(f) < this.auL) {
                        int Q = this.auH.Q(this.auG - this.auF);
                        if (Q > this.auH.startY && Q <= this.auH.endY) {
                            this.auI = true;
                            this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), Q));
                            O(Q - this.auH.startY);
                            break;
                        } else if (Q <= this.auH.startY) {
                            this.auI = false;
                            break;
                        } else if (Q > this.auH.endY) {
                            this.auI = true;
                            break;
                        } else {
                            this.auI = false;
                            break;
                        }
                    } else {
                        this.auI = false;
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
        if (this.auI) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auI) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.auH != null) {
            if (this.auD.getHeight() >= this.auH.endY - (this.auM / 2)) {
                sr();
            } else {
                this.auN.ss();
            }
            this.mScroller.startScroll(0, this.auD.getHeight(), 0, this.auH.startY - this.auD.getHeight(), 200);
            invalidate();
            this.auI = false;
        }
    }

    public void sr() {
        if (this.auN != null) {
            this.auN.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.auN = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void O(float f) {
        this.auN.P(360.0f - ((f * 360.0f) / this.auM));
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

        public int Q(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

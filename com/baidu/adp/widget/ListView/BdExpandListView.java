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
    private View auE;
    private int auF;
    private float auG;
    private float auH;
    private b auI;
    private boolean auJ;
    private float auK;
    private float auL;
    private final int auM;
    private final int auN;
    public a auO;
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
        this.auJ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auM = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auN = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auE = view;
        this.auF = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auH = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auE.getHeight();
                    this.auG = this.auH;
                    this.auK = this.auL;
                    this.auI = new b(0, height, 0, this.auN + height);
                    break;
                case 1:
                case 3:
                    if (this.auJ) {
                        sq();
                    } else {
                        this.auO.ss();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auE.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auE.getWidth(), BdExpandListView.this.auF));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auL - this.auK;
                    float f2 = this.auH - this.auG;
                    this.auK = this.auL;
                    if (this.auE.getParent() == this && this.auI != null && this.auE.isShown() && this.auE.getTop() >= 0 && Math.abs(f2) >= this.auM && Math.abs(f) < this.auM) {
                        int Q = this.auI.Q(this.auH - this.auG);
                        if (Q > this.auI.startY && Q <= this.auI.endY) {
                            this.auJ = true;
                            this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), Q));
                            O(Q - this.auI.startY);
                            break;
                        } else if (Q <= this.auI.startY) {
                            this.auJ = false;
                            break;
                        } else if (Q > this.auI.endY) {
                            this.auJ = true;
                            break;
                        } else {
                            this.auJ = false;
                            break;
                        }
                    } else {
                        this.auJ = false;
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
        if (this.auJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auJ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.auI != null) {
            if (this.auE.getHeight() >= this.auI.endY - (this.auN / 2)) {
                sr();
            } else {
                this.auO.ss();
            }
            this.mScroller.startScroll(0, this.auE.getHeight(), 0, this.auI.startY - this.auE.getHeight(), 200);
            invalidate();
            this.auJ = false;
        }
    }

    public void sr() {
        if (this.auO != null) {
            this.auO.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.auO = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void O(float f) {
        this.auO.P(360.0f - ((f * 360.0f) / this.auN));
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

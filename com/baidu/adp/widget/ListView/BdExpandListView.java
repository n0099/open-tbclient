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
    private View auM;
    private int auN;
    private float auO;
    private float auP;
    private b auQ;
    private boolean auR;
    private float auS;
    private float auT;
    private final int auU;
    private final int auV;
    public a auW;
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
        this.auR = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.auU = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.auV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void n(View view, int i) {
        this.auM = view;
        this.auN = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auP = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auM.getHeight();
                    this.auO = this.auP;
                    this.auS = this.auT;
                    this.auQ = new b(0, height, 0, this.auV + height);
                    break;
                case 1:
                case 3:
                    if (this.auR) {
                        sq();
                    } else {
                        this.auW.ss();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.auM.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.auM.getWidth(), BdExpandListView.this.auN));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.auT - this.auS;
                    float f2 = this.auP - this.auO;
                    this.auS = this.auT;
                    if (this.auM.getParent() == this && this.auQ != null && this.auM.isShown() && this.auM.getTop() >= 0 && Math.abs(f2) >= this.auU && Math.abs(f) < this.auU) {
                        int Q = this.auQ.Q(this.auP - this.auO);
                        if (Q > this.auQ.startY && Q <= this.auQ.endY) {
                            this.auR = true;
                            this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), Q));
                            O(Q - this.auQ.startY);
                            break;
                        } else if (Q <= this.auQ.startY) {
                            this.auR = false;
                            break;
                        } else if (Q > this.auQ.endY) {
                            this.auR = true;
                            break;
                        } else {
                            this.auR = false;
                            break;
                        }
                    } else {
                        this.auR = false;
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
        if (this.auR) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auR) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sq() {
        if (this.auQ != null) {
            if (this.auM.getHeight() >= this.auQ.endY - (this.auV / 2)) {
                sr();
            } else {
                this.auW.ss();
            }
            this.mScroller.startScroll(0, this.auM.getHeight(), 0, this.auQ.startY - this.auM.getHeight(), 200);
            invalidate();
            this.auR = false;
        }
    }

    public void sr() {
        if (this.auW != null) {
            this.auW.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.auW = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void O(float f) {
        this.auW.P(360.0f - ((f * 360.0f) / this.auV));
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

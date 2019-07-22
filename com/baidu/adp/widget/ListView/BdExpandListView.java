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
    private View MM;
    private int MN;
    private float MO;
    private b MP;
    private boolean MQ;
    private float MR;
    private final int MS;
    private final int MT;
    public a MU;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nY();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MQ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.MT = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.MM = view;
        this.MN = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.MO = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.MM.getHeight();
                    this.startY = this.MO;
                    this.startX = this.MR;
                    this.MP = new b(0, height, 0, this.MT + height);
                    break;
                case 1:
                case 3:
                    if (this.MQ) {
                        nW();
                    } else {
                        this.MU.nY();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.MM.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.MM.getWidth(), BdExpandListView.this.MN));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.MR - this.startX;
                    float f2 = this.MO - this.startY;
                    this.startX = this.MR;
                    if (this.MM.getParent() == this && this.MP != null && this.MM.isShown() && this.MM.getTop() >= 0 && Math.abs(f2) >= this.MS && Math.abs(f) < this.MS) {
                        int O = this.MP.O(this.MO - this.startY);
                        if (O > this.MP.startY && O <= this.MP.MW) {
                            this.MQ = true;
                            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), O));
                            M(O - this.MP.startY);
                            break;
                        } else if (O <= this.MP.startY) {
                            this.MQ = false;
                            break;
                        } else if (O > this.MP.MW) {
                            this.MQ = true;
                            break;
                        } else {
                            this.MQ = false;
                            break;
                        }
                    } else {
                        this.MQ = false;
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
        if (this.MQ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MQ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nW() {
        if (this.MP != null) {
            if (this.MM.getHeight() >= this.MP.MW - (this.MT / 2)) {
                nX();
            } else {
                this.MU.nY();
            }
            this.mScroller.startScroll(0, this.MM.getHeight(), 0, this.MP.startY - this.MM.getHeight(), 200);
            invalidate();
            this.MQ = false;
        }
    }

    public void nX() {
        if (this.MU != null) {
            this.MU.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.MU = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.MU.N(360.0f - ((f * 360.0f) / this.MT));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int MW;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.MW = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

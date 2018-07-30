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
    private final int LA;
    public a LB;
    private View Lr;
    private int Ls;
    private float Lt;
    private float Lu;
    private b Lv;
    private boolean Lw;
    private float Lx;
    private float Ly;
    private final int Lz;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void no();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lw = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Lz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.LA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lr = view;
        this.Ls = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Lu = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lr.getHeight();
                    this.Lt = this.Lu;
                    this.Lx = this.Ly;
                    this.Lv = new b(0, height, 0, this.LA + height);
                    break;
                case 1:
                case 3:
                    if (this.Lw) {
                        nm();
                    } else {
                        this.LB.no();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Lr.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lr.getWidth(), BdExpandListView.this.Ls));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Ly - this.Lx;
                    float f2 = this.Lu - this.Lt;
                    this.Lx = this.Ly;
                    if (this.Lr.getParent() == this && this.Lv != null && this.Lr.isShown() && this.Lr.getTop() >= 0 && Math.abs(f2) >= this.Lz && Math.abs(f) < this.Lz) {
                        int O = this.Lv.O(this.Lu - this.Lt);
                        if (O > this.Lv.startY && O <= this.Lv.endY) {
                            this.Lw = true;
                            this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), O));
                            M(O - this.Lv.startY);
                            break;
                        } else if (O <= this.Lv.startY) {
                            this.Lw = false;
                            break;
                        } else if (O > this.Lv.endY) {
                            this.Lw = true;
                            break;
                        } else {
                            this.Lw = false;
                            break;
                        }
                    } else {
                        this.Lw = false;
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
        if (this.Lw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Lw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nm() {
        if (this.Lv != null) {
            if (this.Lr.getHeight() >= this.Lv.endY - (this.LA / 2)) {
                nn();
            } else {
                this.LB.no();
            }
            this.mScroller.startScroll(0, this.Lr.getHeight(), 0, this.Lv.startY - this.Lr.getHeight(), 200);
            invalidate();
            this.Lw = false;
        }
    }

    public void nn() {
        if (this.LB != null) {
            this.LB.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.LB = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.LB.N(360.0f - ((f * 360.0f) / this.LA));
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

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

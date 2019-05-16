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
    private b MA;
    private boolean MB;
    private float MC;
    private final int MD;
    private final int ME;
    public a MF;
    private View Mx;
    private int My;
    private float Mz;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nF();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MB = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.ME = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Mx = view;
        this.My = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Mz = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Mx.getHeight();
                    this.startY = this.Mz;
                    this.startX = this.MC;
                    this.MA = new b(0, height, 0, this.ME + height);
                    break;
                case 1:
                case 3:
                    if (this.MB) {
                        nD();
                    } else {
                        this.MF.nF();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Mx.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Mx.getWidth(), BdExpandListView.this.My));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.MC - this.startX;
                    float f2 = this.Mz - this.startY;
                    this.startX = this.MC;
                    if (this.Mx.getParent() == this && this.MA != null && this.Mx.isShown() && this.Mx.getTop() >= 0 && Math.abs(f2) >= this.MD && Math.abs(f) < this.MD) {
                        int O = this.MA.O(this.Mz - this.startY);
                        if (O > this.MA.startY && O <= this.MA.endY) {
                            this.MB = true;
                            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), O));
                            M(O - this.MA.startY);
                            break;
                        } else if (O <= this.MA.startY) {
                            this.MB = false;
                            break;
                        } else if (O > this.MA.endY) {
                            this.MB = true;
                            break;
                        } else {
                            this.MB = false;
                            break;
                        }
                    } else {
                        this.MB = false;
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
        if (this.MB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MB) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nD() {
        if (this.MA != null) {
            if (this.Mx.getHeight() >= this.MA.endY - (this.ME / 2)) {
                nE();
            } else {
                this.MF.nF();
            }
            this.mScroller.startScroll(0, this.Mx.getHeight(), 0, this.MA.startY - this.Mx.getHeight(), 200);
            invalidate();
            this.MB = false;
        }
    }

    public void nE() {
        if (this.MF != null) {
            this.MF.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.MF = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.MF.N(360.0f - ((f * 360.0f) / this.ME));
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

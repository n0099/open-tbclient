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
    private View HT;
    private int HU;
    private float HV;
    private float HW;
    private b HX;
    private boolean HY;
    private float HZ;
    private float Ia;
    private final int Ib;
    private final int Ic;
    public a Id;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void m(float f);

        void ng();

        void nh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Ib = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ic = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HT = view;
        this.HU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HW = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HT.getHeight();
                    this.HV = this.HW;
                    this.HZ = this.Ia;
                    this.HX = new b(0, height, 0, this.Ic + height);
                    break;
                case 1:
                case 3:
                    if (this.HY) {
                        nd();
                    } else {
                        this.Id.ng();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Ia - this.HZ;
                    float f2 = this.HW - this.HV;
                    this.HZ = this.Ia;
                    if (this.HT.getParent() == this && this.HX != null && this.HT.isShown() && this.HT.getTop() >= 0 && Math.abs(f2) >= this.Ib && Math.abs(f) < this.Ib) {
                        int n = this.HX.n(this.HW - this.HV);
                        if (n > this.HX.startY && n <= this.HX.Ig) {
                            this.HY = true;
                            this.HT.setLayoutParams(new AbsListView.LayoutParams(this.HT.getWidth(), n));
                            l(n - this.HX.startY);
                            break;
                        } else if (n <= this.HX.startY) {
                            this.HY = false;
                            break;
                        } else if (n > this.HX.Ig) {
                            this.HY = true;
                            break;
                        } else {
                            this.HY = false;
                            break;
                        }
                    } else {
                        this.HY = false;
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
        if (this.HY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HY) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nd() {
        if (this.HX != null) {
            if (this.HT.getHeight() >= this.HX.Ig - (this.Ic / 2)) {
                nf();
            } else {
                this.Id.ng();
            }
            this.mScroller.startScroll(0, this.HT.getHeight(), 0, this.HX.startY - this.HT.getHeight(), 200);
            invalidate();
            this.HY = false;
        }
    }

    public void nf() {
        if (this.Id != null) {
            this.Id.nh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Id = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HT.setLayoutParams(new AbsListView.LayoutParams(this.HT.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void l(float f) {
        this.Id.m(360.0f - ((f * 360.0f) / this.Ic));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int If;
        public int Ig;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.If = i3;
            this.Ig = i4;
        }

        public int n(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

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
    private View HZ;
    private int Ia;
    private float Ib;
    private float Ic;
    private b Id;
    private boolean Ie;
    private float If;
    private float Ig;
    private final int Ih;
    private final int Ii;
    public a Ij;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void m(float f);

        void mX();

        void mY();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ie = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Ih = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ii = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HZ = view;
        this.Ia = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ic = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HZ.getHeight();
                    this.Ib = this.Ic;
                    this.If = this.Ig;
                    this.Id = new b(0, height, 0, this.Ii + height);
                    break;
                case 1:
                case 3:
                    if (this.Ie) {
                        mV();
                    } else {
                        this.Ij.mX();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Ig - this.If;
                    float f2 = this.Ic - this.Ib;
                    this.If = this.Ig;
                    if (this.HZ.getParent() == this && this.Id != null && this.HZ.isShown() && this.HZ.getTop() >= 0 && Math.abs(f2) >= this.Ih && Math.abs(f) < this.Ih) {
                        int n = this.Id.n(this.Ic - this.Ib);
                        if (n > this.Id.startY && n <= this.Id.Im) {
                            this.Ie = true;
                            this.HZ.setLayoutParams(new AbsListView.LayoutParams(this.HZ.getWidth(), n));
                            l(n - this.Id.startY);
                            break;
                        } else if (n <= this.Id.startY) {
                            this.Ie = false;
                            break;
                        } else if (n > this.Id.Im) {
                            this.Ie = true;
                            break;
                        } else {
                            this.Ie = false;
                            break;
                        }
                    } else {
                        this.Ie = false;
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
        if (this.Ie) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ie) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mV() {
        if (this.Id != null) {
            if (this.HZ.getHeight() >= this.Id.Im - (this.Ii / 2)) {
                mW();
            } else {
                this.Ij.mX();
            }
            this.mScroller.startScroll(0, this.HZ.getHeight(), 0, this.Id.startY - this.HZ.getHeight(), 200);
            invalidate();
            this.Ie = false;
        }
    }

    public void mW() {
        if (this.Ij != null) {
            this.Ij.mY();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Ij = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HZ.setLayoutParams(new AbsListView.LayoutParams(this.HZ.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void l(float f) {
        this.Ij.m(360.0f - ((f * 360.0f) / this.Ii));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Il;
        public int Im;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.Il = i3;
            this.Im = i4;
        }

        public int n(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

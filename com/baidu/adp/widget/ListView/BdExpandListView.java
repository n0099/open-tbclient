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
    private View Ie;
    private int If;
    private float Ig;
    private float Ih;
    private b Ii;
    private boolean Ij;
    private float Ik;
    private float Il;
    private final int Im;
    private final int In;
    public a Io;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void kY();

        void kZ();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ij = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Im = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.In = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ie = view;
        this.If = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ih = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ie.getHeight();
                    this.Ig = this.Ih;
                    this.Ik = this.Il;
                    this.Ii = new b(0, height, 0, this.In + height);
                    break;
                case 1:
                case 3:
                    if (this.Ij) {
                        kW();
                    } else {
                        this.Io.kY();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Il - this.Ik;
                    float f2 = this.Ih - this.Ig;
                    this.Ik = this.Il;
                    if (this.Ie.getParent() == this && this.Ii != null && this.Ie.isShown() && this.Ie.getTop() >= 0 && Math.abs(f2) >= this.Im && Math.abs(f) < this.Im) {
                        int H = this.Ii.H(this.Ih - this.Ig);
                        if (H > this.Ii.Ir && H <= this.Ii.It) {
                            this.Ij = true;
                            this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), H));
                            F(H - this.Ii.Ir);
                            break;
                        } else if (H <= this.Ii.Ir) {
                            this.Ij = false;
                            break;
                        } else if (H > this.Ii.It) {
                            this.Ij = true;
                            break;
                        } else {
                            this.Ij = false;
                            break;
                        }
                    } else {
                        this.Ij = false;
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
        if (this.Ij) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ij) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kW() {
        if (this.Ii != null) {
            if (this.Ie.getHeight() >= this.Ii.It - (this.In / 2)) {
                kX();
            } else {
                this.Io.kY();
            }
            this.mScroller.startScroll(0, this.Ie.getHeight(), 0, this.Ii.Ir - this.Ie.getHeight(), 200);
            invalidate();
            this.Ij = false;
        }
    }

    public void kX() {
        if (this.Io != null) {
            this.Io.kZ();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Io = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.Io.G(360.0f - ((f * 360.0f) / this.In));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Iq;
        public int Ir;
        public int Is;
        public int It;

        public b(int i, int i2, int i3, int i4) {
            this.Iq = i;
            this.Ir = i2;
            this.Is = i3;
            this.It = i4;
        }

        public int H(float f) {
            return (int) (this.Ir + (f / 2.5f));
        }
    }
}

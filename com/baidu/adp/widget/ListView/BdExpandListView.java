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
    private final int HA;
    private final int HB;
    public a HC;
    private View Hs;
    private int Ht;
    private float Hu;
    private float Hv;
    private b Hw;
    private boolean Hx;
    private float Hy;
    private float Hz;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void lb();

        void lc();

        void w(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HA = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Hs = view;
        this.Ht = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hv = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hs.getHeight();
                    this.Hu = this.Hv;
                    this.Hy = this.Hz;
                    this.Hw = new b(0, height, 0, this.HB + height);
                    break;
                case 1:
                case 3:
                    if (this.Hx) {
                        kZ();
                    } else {
                        this.HC.lb();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Hs.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Hs.getWidth(), BdExpandListView.this.Ht));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Hz - this.Hy;
                    float f2 = this.Hv - this.Hu;
                    this.Hy = this.Hz;
                    if (this.Hs.getParent() == this && this.Hw != null && this.Hs.isShown() && this.Hs.getTop() >= 0 && Math.abs(f2) >= this.HA && Math.abs(f) < this.HA) {
                        int x = this.Hw.x(this.Hv - this.Hu);
                        if (x > this.Hw.HF && x <= this.Hw.HH) {
                            this.Hx = true;
                            this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), x));
                            v(x - this.Hw.HF);
                            break;
                        } else if (x <= this.Hw.HF) {
                            this.Hx = false;
                            break;
                        } else if (x > this.Hw.HH) {
                            this.Hx = true;
                            break;
                        } else {
                            this.Hx = false;
                            break;
                        }
                    } else {
                        this.Hx = false;
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
        if (this.Hx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hx) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kZ() {
        if (this.Hw != null) {
            if (this.Hs.getHeight() >= this.Hw.HH - (this.HB / 2)) {
                la();
            } else {
                this.HC.lb();
            }
            this.mScroller.startScroll(0, this.Hs.getHeight(), 0, this.Hw.HF - this.Hs.getHeight(), 200);
            invalidate();
            this.Hx = false;
        }
    }

    public void la() {
        if (this.HC != null) {
            this.HC.lc();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.HC = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void v(float f) {
        this.HC.w(360.0f - ((f * 360.0f) / this.HB));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HE;
        public int HF;
        public int HG;
        public int HH;

        public b(int i, int i2, int i3, int i4) {
            this.HE = i;
            this.HF = i2;
            this.HG = i3;
            this.HH = i4;
        }

        public int x(float f) {
            return (int) (this.HF + (f / 2.5f));
        }
    }
}

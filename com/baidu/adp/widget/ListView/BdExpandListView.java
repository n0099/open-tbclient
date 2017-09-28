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
    public a HB;
    private View Hr;
    private int Hs;
    private float Ht;
    private float Hu;
    private b Hv;
    private boolean Hw;
    private float Hx;
    private float Hy;
    private final int Hz;
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
        this.Hw = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Hr = view;
        this.Hs = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hu = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hr.getHeight();
                    this.Ht = this.Hu;
                    this.Hx = this.Hy;
                    this.Hv = new b(0, height, 0, this.HA + height);
                    break;
                case 1:
                case 3:
                    if (this.Hw) {
                        kZ();
                    } else {
                        this.HB.lb();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Hr.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Hr.getWidth(), BdExpandListView.this.Hs));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Hy - this.Hx;
                    float f2 = this.Hu - this.Ht;
                    this.Hx = this.Hy;
                    if (this.Hr.getParent() == this && this.Hv != null && this.Hr.isShown() && this.Hr.getTop() >= 0 && Math.abs(f2) >= this.Hz && Math.abs(f) < this.Hz) {
                        int x = this.Hv.x(this.Hu - this.Ht);
                        if (x > this.Hv.HE && x <= this.Hv.HG) {
                            this.Hw = true;
                            this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), x));
                            v(x - this.Hv.HE);
                            break;
                        } else if (x <= this.Hv.HE) {
                            this.Hw = false;
                            break;
                        } else if (x > this.Hv.HG) {
                            this.Hw = true;
                            break;
                        } else {
                            this.Hw = false;
                            break;
                        }
                    } else {
                        this.Hw = false;
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
        if (this.Hw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kZ() {
        if (this.Hv != null) {
            if (this.Hr.getHeight() >= this.Hv.HG - (this.HA / 2)) {
                la();
            } else {
                this.HB.lb();
            }
            this.mScroller.startScroll(0, this.Hr.getHeight(), 0, this.Hv.HE - this.Hr.getHeight(), 200);
            invalidate();
            this.Hw = false;
        }
    }

    public void la() {
        if (this.HB != null) {
            this.HB.lc();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.HB = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void v(float f) {
        this.HB.w(360.0f - ((f * 360.0f) / this.HA));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HD;
        public int HE;
        public int HF;
        public int HG;

        public b(int i, int i2, int i3, int i4) {
            this.HD = i;
            this.HE = i2;
            this.HF = i3;
            this.HG = i4;
        }

        public int x(float f) {
            return (int) (this.HE + (f / 2.5f));
        }
    }
}

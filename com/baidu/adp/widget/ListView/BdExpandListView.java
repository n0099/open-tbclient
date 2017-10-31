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
    private View GN;
    private int GO;
    private float GP;
    private float GQ;
    private b GR;
    private boolean GS;
    private float GT;
    private float GU;
    private final int GV;
    private final int GW;
    public a GX;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.GN = view;
        this.GO = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GQ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.GT = this.GU;
                    this.GR = new b(0, height, 0, this.GW + height);
                    break;
                case 1:
                case 3:
                    if (this.GS) {
                        kT();
                    } else {
                        this.GX.kV();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.GN.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GN.getWidth(), BdExpandListView.this.GO));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.GU - this.GT;
                    float f2 = this.GQ - this.GP;
                    this.GT = this.GU;
                    if (this.GN.getParent() == this && this.GR != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f2) >= this.GV && Math.abs(f) < this.GV) {
                        int w = this.GR.w(this.GQ - this.GP);
                        if (w > this.GR.Ha && w <= this.GR.Hc) {
                            this.GS = true;
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            u(w - this.GR.Ha);
                            break;
                        } else if (w <= this.GR.Ha) {
                            this.GS = false;
                            break;
                        } else if (w > this.GR.Hc) {
                            this.GS = true;
                            break;
                        } else {
                            this.GS = false;
                            break;
                        }
                    } else {
                        this.GS = false;
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
        if (this.GS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GS) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kT() {
        if (this.GR != null) {
            if (this.GN.getHeight() >= this.GR.Hc - (this.GW / 2)) {
                kU();
            } else {
                this.GX.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.GR.Ha - this.GN.getHeight(), 200);
            invalidate();
            this.GS = false;
        }
    }

    public void kU() {
        if (this.GX != null) {
            this.GX.kW();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.GX = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void u(float f) {
        this.GX.v(360.0f - ((f * 360.0f) / this.GW));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int GZ;
        public int Ha;
        public int Hb;
        public int Hc;

        public b(int i, int i2, int i3, int i4) {
            this.GZ = i;
            this.Ha = i2;
            this.Hb = i3;
            this.Hc = i4;
        }

        public int w(float f) {
            return (int) (this.Ha + (f / 2.5f));
        }
    }
}

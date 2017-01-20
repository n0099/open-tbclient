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
    private View AR;
    private int AS;
    private float AT;
    private float AU;
    private b AV;
    private boolean AW;
    private float AX;
    private float AY;
    private final int AZ;
    private final int Ba;
    public a Bb;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ke();

        void kf();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AW = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.AZ = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ba = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.AR = view;
        this.AS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.AU = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.AR.getHeight();
                    this.AT = this.AU;
                    this.AX = this.AY;
                    this.AV = new b(0, height, 0, this.Ba + height);
                    break;
                case 1:
                case 3:
                    if (this.AW) {
                        kc();
                    } else {
                        this.Bb.ke();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.AY - this.AX;
                    float f2 = this.AU - this.AT;
                    this.AX = this.AY;
                    if (this.AR.getParent() == this && this.AV != null && this.AR.isShown() && this.AR.getTop() >= 0 && Math.abs(f2) >= this.AZ && Math.abs(f) < this.AZ) {
                        int H = this.AV.H(this.AU - this.AT);
                        if (H > this.AV.Be && H <= this.AV.Bg) {
                            this.AW = true;
                            this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), H));
                            F(H - this.AV.Be);
                            break;
                        } else if (H <= this.AV.Be) {
                            this.AW = false;
                            break;
                        } else if (H > this.AV.Bg) {
                            this.AW = true;
                            break;
                        } else {
                            this.AW = false;
                            break;
                        }
                    } else {
                        this.AW = false;
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
        if (this.AW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.AW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kc() {
        if (this.AV != null) {
            if (this.AR.getHeight() >= this.AV.Bg - (this.Ba / 2)) {
                kd();
            } else {
                this.Bb.ke();
            }
            this.mScroller.startScroll(0, this.AR.getHeight(), 0, this.AV.Be - this.AR.getHeight(), 200);
            invalidate();
            this.AW = false;
        }
    }

    public void kd() {
        if (this.Bb != null) {
            this.Bb.kf();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Bb = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.Bb.G(360.0f - ((f * 360.0f) / this.Ba));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bd;
        public int Be;
        public int Bf;
        public int Bg;

        public b(int i, int i2, int i3, int i4) {
            this.Bd = i;
            this.Be = i2;
            this.Bf = i3;
            this.Bg = i4;
        }

        public int H(float f) {
            return (int) (this.Be + (f / 2.5f));
        }
    }
}

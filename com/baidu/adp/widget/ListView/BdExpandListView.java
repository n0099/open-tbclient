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
    private View Bg;
    private int Bh;
    private float Bi;
    private float Bj;
    private b Bk;
    private boolean Bl;
    private float Bm;
    private float Bn;
    private final int Bo;
    private final int Bp;
    public a Bq;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ki();

        void kj();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Bp = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bg = view;
        this.Bh = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Bj = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Bg.getHeight();
                    this.Bi = this.Bj;
                    this.Bm = this.Bn;
                    this.Bk = new b(0, height, 0, this.Bp + height);
                    break;
                case 1:
                case 3:
                    if (this.Bl) {
                        kg();
                    } else {
                        this.Bq.ki();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Bn - this.Bm;
                    float f2 = this.Bj - this.Bi;
                    this.Bm = this.Bn;
                    if (this.Bg.getParent() == this && this.Bk != null && this.Bg.isShown() && this.Bg.getTop() >= 0 && Math.abs(f2) >= this.Bo && Math.abs(f) < this.Bo) {
                        int H = this.Bk.H(this.Bj - this.Bi);
                        if (H > this.Bk.Bt && H <= this.Bk.Bv) {
                            this.Bl = true;
                            this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), H));
                            F(H - this.Bk.Bt);
                            break;
                        } else if (H <= this.Bk.Bt) {
                            this.Bl = false;
                            break;
                        } else if (H > this.Bk.Bv) {
                            this.Bl = true;
                            break;
                        } else {
                            this.Bl = false;
                            break;
                        }
                    } else {
                        this.Bl = false;
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
        if (this.Bl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Bl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kg() {
        if (this.Bk != null) {
            if (this.Bg.getHeight() >= this.Bk.Bv - (this.Bp / 2)) {
                kh();
            } else {
                this.Bq.ki();
            }
            this.mScroller.startScroll(0, this.Bg.getHeight(), 0, this.Bk.Bt - this.Bg.getHeight(), 200);
            invalidate();
            this.Bl = false;
        }
    }

    public void kh() {
        if (this.Bq != null) {
            this.Bq.kj();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Bq = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.Bq.G(360.0f - ((f * 360.0f) / this.Bp));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bs;
        public int Bt;
        public int Bu;
        public int Bv;

        public b(int i, int i2, int i3, int i4) {
            this.Bs = i;
            this.Bt = i2;
            this.Bu = i3;
            this.Bv = i4;
        }

        public int H(float f) {
            return (int) (this.Bt + (f / 2.5f));
        }
    }
}

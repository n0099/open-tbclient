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
    private View GX;
    private int GY;
    private float GZ;
    private float Ha;
    private b Hb;
    private boolean Hc;
    private float Hd;
    private float He;
    private final int Hf;
    private final int Hg;
    public a Hh;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void k(float f);

        void nm();

        void nn();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hc = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hf = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hg = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.GX = view;
        this.GY = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ha = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GX.getHeight();
                    this.GZ = this.Ha;
                    this.Hd = this.He;
                    this.Hb = new b(0, height, 0, this.Hg + height);
                    break;
                case 1:
                case 3:
                    if (this.Hc) {
                        nk();
                    } else {
                        this.Hh.nm();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.He - this.Hd;
                    float f2 = this.Ha - this.GZ;
                    this.Hd = this.He;
                    if (this.GX.getParent() == this && this.Hb != null && this.GX.isShown() && this.GX.getTop() >= 0 && Math.abs(f2) >= this.Hf && Math.abs(f) < this.Hf) {
                        int l = this.Hb.l(this.Ha - this.GZ);
                        if (l > this.Hb.startY && l <= this.Hb.Hk) {
                            this.Hc = true;
                            this.GX.setLayoutParams(new AbsListView.LayoutParams(this.GX.getWidth(), l));
                            j(l - this.Hb.startY);
                            break;
                        } else if (l <= this.Hb.startY) {
                            this.Hc = false;
                            break;
                        } else if (l > this.Hb.Hk) {
                            this.Hc = true;
                            break;
                        } else {
                            this.Hc = false;
                            break;
                        }
                    } else {
                        this.Hc = false;
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
        if (this.Hc) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hc) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.Hb != null) {
            if (this.GX.getHeight() >= this.Hb.Hk - (this.Hg / 2)) {
                nl();
            } else {
                this.Hh.nm();
            }
            this.mScroller.startScroll(0, this.GX.getHeight(), 0, this.Hb.startY - this.GX.getHeight(), 200);
            invalidate();
            this.Hc = false;
        }
    }

    public void nl() {
        if (this.Hh != null) {
            this.Hh.nn();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Hh = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GX.setLayoutParams(new AbsListView.LayoutParams(this.GX.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Hh.k(360.0f - ((f * 360.0f) / this.Hg));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hj;
        public int Hk;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.Hj = i3;
            this.Hk = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

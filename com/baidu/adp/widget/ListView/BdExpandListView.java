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
    private View GY;
    private int GZ;
    private float Ha;
    private float Hb;
    private b Hc;
    private boolean Hd;
    private float He;
    private float Hf;
    private final int Hg;
    private final int Hh;
    public a Hi;
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
        this.Hd = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hg = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hh = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.GY = view;
        this.GZ = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hb = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GY.getHeight();
                    this.Ha = this.Hb;
                    this.He = this.Hf;
                    this.Hc = new b(0, height, 0, this.Hh + height);
                    break;
                case 1:
                case 3:
                    if (this.Hd) {
                        nk();
                    } else {
                        this.Hi.nm();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Hf - this.He;
                    float f2 = this.Hb - this.Ha;
                    this.He = this.Hf;
                    if (this.GY.getParent() == this && this.Hc != null && this.GY.isShown() && this.GY.getTop() >= 0 && Math.abs(f2) >= this.Hg && Math.abs(f) < this.Hg) {
                        int l = this.Hc.l(this.Hb - this.Ha);
                        if (l > this.Hc.startY && l <= this.Hc.Hl) {
                            this.Hd = true;
                            this.GY.setLayoutParams(new AbsListView.LayoutParams(this.GY.getWidth(), l));
                            j(l - this.Hc.startY);
                            break;
                        } else if (l <= this.Hc.startY) {
                            this.Hd = false;
                            break;
                        } else if (l > this.Hc.Hl) {
                            this.Hd = true;
                            break;
                        } else {
                            this.Hd = false;
                            break;
                        }
                    } else {
                        this.Hd = false;
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
        if (this.Hd) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hd) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.Hc != null) {
            if (this.GY.getHeight() >= this.Hc.Hl - (this.Hh / 2)) {
                nl();
            } else {
                this.Hi.nm();
            }
            this.mScroller.startScroll(0, this.GY.getHeight(), 0, this.Hc.startY - this.GY.getHeight(), 200);
            invalidate();
            this.Hd = false;
        }
    }

    public void nl() {
        if (this.Hi != null) {
            this.Hi.nn();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Hi = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GY.setLayoutParams(new AbsListView.LayoutParams(this.GY.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Hi.k(360.0f - ((f * 360.0f) / this.Hh));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hk;
        public int Hl;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.Hk = i3;
            this.Hl = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

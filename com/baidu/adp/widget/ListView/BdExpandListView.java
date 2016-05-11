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
    private final Context mContext;
    private final Scroller mScroller;
    public a yA;
    private View yq;
    private int yr;
    private float ys;
    private float yt;
    private b yu;
    private boolean yv;
    private float yw;
    private float yx;
    private final int yy;
    private final int yz;

    /* loaded from: classes.dex */
    public interface a {
        void jl();

        void jm();

        void k(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yv = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.yy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.yz = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yq = view;
        this.yr = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.yt = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.yq.getHeight();
                    this.ys = this.yt;
                    this.yw = this.yx;
                    this.yu = new b(0, height, 0, this.yz + height);
                    break;
                case 1:
                case 3:
                    if (this.yv) {
                        jj();
                    } else {
                        this.yA.jl();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.yx - this.yw;
                    float f2 = this.yt - this.ys;
                    this.yw = this.yx;
                    if (this.yq.getParent() == this && this.yu != null && this.yq.isShown() && this.yq.getTop() >= 0 && Math.abs(f2) >= this.yy && Math.abs(f) < this.yy) {
                        int l = this.yu.l(this.yt - this.ys);
                        if (l > this.yu.yD && l <= this.yu.yF) {
                            this.yv = true;
                            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), l));
                            j(l - this.yu.yD);
                            break;
                        } else if (l <= this.yu.yD) {
                            this.yv = false;
                            break;
                        } else if (l > this.yu.yF) {
                            this.yv = true;
                            break;
                        } else {
                            this.yv = false;
                            break;
                        }
                    } else {
                        this.yv = false;
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
        if (this.yv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jj() {
        if (this.yu != null) {
            if (this.yq.getHeight() >= this.yu.yF - (this.yz / 2)) {
                jk();
            } else {
                this.yA.jl();
            }
            this.mScroller.startScroll(0, this.yq.getHeight(), 0, this.yu.yD - this.yq.getHeight(), 200);
            invalidate();
            this.yv = false;
        }
    }

    public void jk() {
        if (this.yA != null) {
            this.yA.jm();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.yA = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.yA.k(360.0f - ((f * 360.0f) / this.yz));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int yC;
        public int yD;
        public int yE;
        public int yF;

        public b(int i, int i2, int i3, int i4) {
            this.yC = i;
            this.yD = i2;
            this.yE = i3;
            this.yF = i4;
        }

        public int l(float f) {
            return (int) (this.yD + (f / 2.5f));
        }
    }
}

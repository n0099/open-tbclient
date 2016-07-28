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
    private View yT;
    private int yU;
    private float yV;
    private float yW;
    private b yX;
    private boolean yY;
    private float yZ;
    private float za;
    private final int zb;
    private final int zc;
    public a zd;

    /* loaded from: classes.dex */
    public interface a {
        void jn();

        void jo();

        void u(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yY = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.zb = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.zc = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yT = view;
        this.yU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.yW = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.yT.getHeight();
                    this.yV = this.yW;
                    this.yZ = this.za;
                    this.yX = new b(0, height, 0, this.zc + height);
                    break;
                case 1:
                case 3:
                    if (this.yY) {
                        jl();
                    } else {
                        this.zd.jn();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.za - this.yZ;
                    float f2 = this.yW - this.yV;
                    this.yZ = this.za;
                    if (this.yT.getParent() == this && this.yX != null && this.yT.isShown() && this.yT.getTop() >= 0 && Math.abs(f2) >= this.zb && Math.abs(f) < this.zb) {
                        int v = this.yX.v(this.yW - this.yV);
                        if (v > this.yX.startY && v <= this.yX.zf) {
                            this.yY = true;
                            this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), v));
                            t(v - this.yX.startY);
                            break;
                        } else if (v <= this.yX.startY) {
                            this.yY = false;
                            break;
                        } else if (v > this.yX.zf) {
                            this.yY = true;
                            break;
                        } else {
                            this.yY = false;
                            break;
                        }
                    } else {
                        this.yY = false;
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
        if (this.yY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yY) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jl() {
        if (this.yX != null) {
            if (this.yT.getHeight() >= this.yX.zf - (this.zc / 2)) {
                jm();
            } else {
                this.zd.jn();
            }
            this.mScroller.startScroll(0, this.yT.getHeight(), 0, this.yX.startY - this.yT.getHeight(), 200);
            invalidate();
            this.yY = false;
        }
    }

    public void jm() {
        if (this.zd != null) {
            this.zd.jo();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.zd = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void t(float f) {
        this.zd.u(360.0f - ((f * 360.0f) / this.zc));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int startX;
        public int startY;
        public int zf;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.zf = i4;
        }

        public int v(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

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
    private View GZ;
    private int Ha;
    private float Hb;
    private float Hc;
    private b Hd;
    private boolean He;
    private float Hf;
    private float Hg;
    private final int Hh;
    private final int Hi;
    public a Hj;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void k(float f);

        void nn();

        void no();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.He = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hh = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hi = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.GZ = view;
        this.Ha = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hc = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GZ.getHeight();
                    this.Hb = this.Hc;
                    this.Hf = this.Hg;
                    this.Hd = new b(0, height, 0, this.Hi + height);
                    break;
                case 1:
                case 3:
                    if (this.He) {
                        nl();
                    } else {
                        this.Hj.nn();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.Hg - this.Hf;
                    float f2 = this.Hc - this.Hb;
                    this.Hf = this.Hg;
                    if (this.GZ.getParent() == this && this.Hd != null && this.GZ.isShown() && this.GZ.getTop() >= 0 && Math.abs(f2) >= this.Hh && Math.abs(f) < this.Hh) {
                        int l = this.Hd.l(this.Hc - this.Hb);
                        if (l > this.Hd.startY && l <= this.Hd.Hm) {
                            this.He = true;
                            this.GZ.setLayoutParams(new AbsListView.LayoutParams(this.GZ.getWidth(), l));
                            j(l - this.Hd.startY);
                            break;
                        } else if (l <= this.Hd.startY) {
                            this.He = false;
                            break;
                        } else if (l > this.Hd.Hm) {
                            this.He = true;
                            break;
                        } else {
                            this.He = false;
                            break;
                        }
                    } else {
                        this.He = false;
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
        if (this.He) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.He) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nl() {
        if (this.Hd != null) {
            if (this.GZ.getHeight() >= this.Hd.Hm - (this.Hi / 2)) {
                nm();
            } else {
                this.Hj.nn();
            }
            this.mScroller.startScroll(0, this.GZ.getHeight(), 0, this.Hd.startY - this.GZ.getHeight(), 200);
            invalidate();
            this.He = false;
        }
    }

    public void nm() {
        if (this.Hj != null) {
            this.Hj.no();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Hj = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GZ.setLayoutParams(new AbsListView.LayoutParams(this.GZ.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Hj.k(360.0f - ((f * 360.0f) / this.Hi));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hl;
        public int Hm;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.Hl = i3;
            this.Hm = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

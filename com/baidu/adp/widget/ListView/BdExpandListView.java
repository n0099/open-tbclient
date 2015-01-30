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
    private View wi;
    private int wj;
    private float wk;
    private float wl;
    private d wm;
    private boolean wn;
    private float wo;
    private float wp;
    private final int wq;
    private final int wr;
    public c ws;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wn = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.wq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.wr = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.wi = view;
        this.wj = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.wl = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.wi.getHeight();
                    this.wk = this.wl;
                    this.wo = this.wp;
                    this.wm = new d(0, height, 0, this.wr + height);
                    break;
                case 1:
                case 3:
                    if (this.wn) {
                        ju();
                    } else {
                        this.ws.jw();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.wp - this.wo;
                    float f2 = this.wl - this.wk;
                    this.wo = this.wp;
                    if (this.wi.getParent() == this && this.wm != null && this.wi.isShown() && this.wi.getTop() >= 0 && Math.abs(f2) >= this.wq && Math.abs(f) < this.wq) {
                        int l = this.wm.l(this.wl - this.wk);
                        if (l > this.wm.startY && l <= this.wm.wv) {
                            this.wn = true;
                            this.wi.setLayoutParams(new AbsListView.LayoutParams(this.wi.getWidth(), l));
                            j(l - this.wm.startY);
                            break;
                        } else if (l <= this.wm.startY) {
                            this.wn = false;
                            break;
                        } else if (l > this.wm.wv) {
                            this.wn = true;
                            break;
                        } else {
                            this.wn = false;
                            break;
                        }
                    } else {
                        this.wn = false;
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
        if (this.wn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.wn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ju() {
        if (this.wm != null) {
            if (this.wi.getHeight() >= this.wm.wv - (this.wr / 2)) {
                jv();
            } else {
                this.ws.jw();
            }
            this.mScroller.startScroll(0, this.wi.getHeight(), 0, this.wm.startY - this.wi.getHeight(), 200);
            invalidate();
            this.wn = false;
        }
    }

    public void jv() {
        if (this.ws != null) {
            this.ws.jx();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.ws = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.wi.setLayoutParams(new AbsListView.LayoutParams(this.wi.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.ws.k(360.0f - ((f * 360.0f) / this.wr));
    }
}

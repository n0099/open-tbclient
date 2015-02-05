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
    private View wf;
    private int wg;
    private float wh;
    private float wi;
    private d wj;
    private boolean wk;
    private float wl;
    private float wm;
    private final int wn;
    private final int wo;
    public c wp;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wk = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.wn = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.wo = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.wf = view;
        this.wg = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.wi = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.wf.getHeight();
                    this.wh = this.wi;
                    this.wl = this.wm;
                    this.wj = new d(0, height, 0, this.wo + height);
                    break;
                case 1:
                case 3:
                    if (this.wk) {
                        jn();
                    } else {
                        this.wp.jp();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.wm - this.wl;
                    float f2 = this.wi - this.wh;
                    this.wl = this.wm;
                    if (this.wf.getParent() == this && this.wj != null && this.wf.isShown() && this.wf.getTop() >= 0 && Math.abs(f2) >= this.wn && Math.abs(f) < this.wn) {
                        int l = this.wj.l(this.wi - this.wh);
                        if (l > this.wj.startY && l <= this.wj.ws) {
                            this.wk = true;
                            this.wf.setLayoutParams(new AbsListView.LayoutParams(this.wf.getWidth(), l));
                            j(l - this.wj.startY);
                            break;
                        } else if (l <= this.wj.startY) {
                            this.wk = false;
                            break;
                        } else if (l > this.wj.ws) {
                            this.wk = true;
                            break;
                        } else {
                            this.wk = false;
                            break;
                        }
                    } else {
                        this.wk = false;
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
        if (this.wk) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.wk) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jn() {
        if (this.wj != null) {
            if (this.wf.getHeight() >= this.wj.ws - (this.wo / 2)) {
                jo();
            } else {
                this.wp.jp();
            }
            this.mScroller.startScroll(0, this.wf.getHeight(), 0, this.wj.startY - this.wf.getHeight(), 200);
            invalidate();
            this.wk = false;
        }
    }

    public void jo() {
        if (this.wp != null) {
            this.wp.jq();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.wp = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.wf.setLayoutParams(new AbsListView.LayoutParams(this.wf.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.wp.k(360.0f - ((f * 360.0f) / this.wo));
    }
}

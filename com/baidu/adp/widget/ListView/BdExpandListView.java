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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
public class BdExpandListView extends BdListView {
    private final Context mContext;
    private final Scroller mScroller;
    private View wc;
    private int wd;
    private float we;
    private float wf;
    private d wg;
    private boolean wh;
    private float wi;
    private float wj;
    private final int wk;
    private final int wl;
    public c wm;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wh = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.wk = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.wl = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.wc = view;
        this.wd = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.wf = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.wc.getHeight();
                    this.we = this.wf;
                    this.wi = this.wj;
                    this.wg = new d(0, height, 0, this.wl + height);
                    break;
                case 1:
                case 3:
                    if (this.wh) {
                        jt();
                    } else {
                        this.wm.jv();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.wj - this.wi;
                    float f2 = this.wf - this.we;
                    this.wi = this.wj;
                    if (this.wc.getParent() == this && this.wg != null && this.wc.isShown() && this.wc.getTop() >= 0 && Math.abs(f2) >= this.wk && Math.abs(f) < this.wk) {
                        int l = this.wg.l(this.wf - this.we);
                        if (l > this.wg.startY && l <= this.wg.wp) {
                            this.wh = true;
                            this.wc.setLayoutParams(new AbsListView.LayoutParams(this.wc.getWidth(), l));
                            j(l - this.wg.startY);
                            break;
                        } else if (l <= this.wg.startY) {
                            this.wh = false;
                            break;
                        } else if (l > this.wg.wp) {
                            this.wh = true;
                            break;
                        } else {
                            this.wh = false;
                            break;
                        }
                    } else {
                        this.wh = false;
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
        if (this.wh) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.wh) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jt() {
        if (this.wg != null) {
            if (this.wc.getHeight() >= this.wg.wp - (this.wl / 2)) {
                ju();
            } else {
                this.wm.jv();
            }
            this.mScroller.startScroll(0, this.wc.getHeight(), 0, this.wg.startY - this.wc.getHeight(), Constants.MEDIA_INFO);
            invalidate();
            this.wh = false;
        }
    }

    public void ju() {
        if (this.wm != null) {
            this.wm.jw();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.wm = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.wc.setLayoutParams(new AbsListView.LayoutParams(this.wc.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.wm.k(360.0f - ((f * 360.0f) / this.wl));
    }
}

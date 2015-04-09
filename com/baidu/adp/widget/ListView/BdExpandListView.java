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
    private View Hg;
    private int Hh;
    private float Hi;
    private float Hj;
    private d Hk;
    private boolean Hl;
    private float Hm;
    private float Hn;
    private final int Ho;
    private final int Hp;
    public c Hq;
    private final Context mContext;
    private final Scroller mScroller;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Ho = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hp = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.Hg = view;
        this.Hh = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hj = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hg.getHeight();
                    this.Hi = this.Hj;
                    this.Hm = this.Hn;
                    this.Hk = new d(0, height, 0, this.Hp + height);
                    break;
                case 1:
                case 3:
                    if (this.Hl) {
                        mJ();
                    } else {
                        this.Hq.mL();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.Hn - this.Hm;
                    float f2 = this.Hj - this.Hi;
                    this.Hm = this.Hn;
                    if (this.Hg.getParent() == this && this.Hk != null && this.Hg.isShown() && this.Hg.getTop() >= 0 && Math.abs(f2) >= this.Ho && Math.abs(f) < this.Ho) {
                        int l = this.Hk.l(this.Hj - this.Hi);
                        if (l > this.Hk.startY && l <= this.Hk.Ht) {
                            this.Hl = true;
                            this.Hg.setLayoutParams(new AbsListView.LayoutParams(this.Hg.getWidth(), l));
                            j(l - this.Hk.startY);
                            break;
                        } else if (l <= this.Hk.startY) {
                            this.Hl = false;
                            break;
                        } else if (l > this.Hk.Ht) {
                            this.Hl = true;
                            break;
                        } else {
                            this.Hl = false;
                            break;
                        }
                    } else {
                        this.Hl = false;
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
        if (this.Hl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mJ() {
        if (this.Hk != null) {
            if (this.Hg.getHeight() >= this.Hk.Ht - (this.Hp / 2)) {
                mK();
            } else {
                this.Hq.mL();
            }
            this.mScroller.startScroll(0, this.Hg.getHeight(), 0, this.Hk.startY - this.Hg.getHeight(), 200);
            invalidate();
            this.Hl = false;
        }
    }

    public void mK() {
        if (this.Hq != null) {
            this.Hq.mM();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.Hq = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Hg.setLayoutParams(new AbsListView.LayoutParams(this.Hg.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Hq.k(360.0f - ((f * 360.0f) / this.Hp));
    }
}

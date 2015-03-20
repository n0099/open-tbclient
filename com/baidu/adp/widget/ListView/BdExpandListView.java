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
    private View He;
    private int Hf;
    private float Hg;
    private float Hh;
    private d Hi;
    private boolean Hj;
    private float Hk;
    private float Hl;
    private final int Hm;
    private final int Hn;
    public c Ho;
    private final Context mContext;
    private final Scroller mScroller;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hj = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hm = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hn = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.He = view;
        this.Hf = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hh = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.He.getHeight();
                    this.Hg = this.Hh;
                    this.Hk = this.Hl;
                    this.Hi = new d(0, height, 0, this.Hn + height);
                    break;
                case 1:
                case 3:
                    if (this.Hj) {
                        mJ();
                    } else {
                        this.Ho.mL();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.Hl - this.Hk;
                    float f2 = this.Hh - this.Hg;
                    this.Hk = this.Hl;
                    if (this.He.getParent() == this && this.Hi != null && this.He.isShown() && this.He.getTop() >= 0 && Math.abs(f2) >= this.Hm && Math.abs(f) < this.Hm) {
                        int l = this.Hi.l(this.Hh - this.Hg);
                        if (l > this.Hi.startY && l <= this.Hi.Hr) {
                            this.Hj = true;
                            this.He.setLayoutParams(new AbsListView.LayoutParams(this.He.getWidth(), l));
                            j(l - this.Hi.startY);
                            break;
                        } else if (l <= this.Hi.startY) {
                            this.Hj = false;
                            break;
                        } else if (l > this.Hi.Hr) {
                            this.Hj = true;
                            break;
                        } else {
                            this.Hj = false;
                            break;
                        }
                    } else {
                        this.Hj = false;
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
        if (this.Hj) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hj) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mJ() {
        if (this.Hi != null) {
            if (this.He.getHeight() >= this.Hi.Hr - (this.Hn / 2)) {
                mK();
            } else {
                this.Ho.mL();
            }
            this.mScroller.startScroll(0, this.He.getHeight(), 0, this.Hi.startY - this.He.getHeight(), 200);
            invalidate();
            this.Hj = false;
        }
    }

    public void mK() {
        if (this.Ho != null) {
            this.Ho.mM();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.Ho = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.He.setLayoutParams(new AbsListView.LayoutParams(this.He.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Ho.k(360.0f - ((f * 360.0f) / this.Hn));
    }
}

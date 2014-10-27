package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.content.res.TypedArray;
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
    private View tU;
    private float tV;
    private float tW;
    private c tX;
    private boolean tY;
    private float tZ;
    private float ua;
    private final int ub;
    private final int uc;
    public b ud;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tY = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.ub = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.uc = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.tU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.tW = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.tU.getHeight();
                    this.tV = this.tW;
                    this.tZ = this.ua;
                    this.tX = new c(0, height, 0, this.uc + height);
                    break;
                case 1:
                case 3:
                    if (this.tY) {
                        hw();
                    }
                    this.tY = false;
                    break;
                case 2:
                    float f = this.ua - this.tZ;
                    float f2 = this.tW - this.tV;
                    this.tZ = this.ua;
                    if (this.tU.getParent() == this && this.tX != null && this.tU.isShown() && this.tU.getTop() >= 0 && Math.abs(f2) >= this.ub && Math.abs(f) < this.ub) {
                        int k = this.tX.k(this.tW - this.tV);
                        if (k > this.tX.uf && k <= this.tX.uh) {
                            this.tY = true;
                            this.tU.setLayoutParams(new AbsListView.LayoutParams(this.tU.getWidth(), k));
                            i(k - this.tX.uf);
                        } else if (k <= this.tX.uf) {
                            this.tY = false;
                        } else if (k > this.tX.uh) {
                            this.tY = true;
                        } else {
                            this.tY = false;
                        }
                        if (!this.tY) {
                            this.ud.hy();
                            break;
                        }
                    } else {
                        this.ud.hy();
                        this.tY = false;
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
        if (this.tY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tY) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void hw() {
        if (this.tX != null) {
            if (this.tU.getHeight() >= this.tX.uh - (this.uc / 2)) {
                hx();
            } else {
                this.ud.hy();
            }
            this.mScroller.startScroll(0, this.tU.getHeight(), 0, this.tX.uf - this.tU.getHeight(), Constants.MEDIA_INFO);
            invalidate();
            this.tY = false;
        }
    }

    public void hx() {
        if (this.ud != null) {
            this.ud.hz();
        }
    }

    public void setExpandListRefreshListener(b bVar) {
        this.ud = bVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.tU.setLayoutParams(new AbsListView.LayoutParams(this.tU.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void i(float f) {
        this.ud.j(360.0f - ((f * 360.0f) / this.uc));
    }
}

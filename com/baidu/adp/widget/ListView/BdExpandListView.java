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
    private View GW;
    private int GX;
    private float GY;
    private float GZ;
    private d Ha;
    private boolean Hb;
    private float Hc;
    private float Hd;
    private final int He;
    private final int Hf;
    public c Hg;
    private final Context mContext;
    private final Scroller mScroller;

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hb = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.He = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hf = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.GW = view;
        this.GX = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GZ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GW.getHeight();
                    this.GY = this.GZ;
                    this.Hc = this.Hd;
                    this.Ha = new d(0, height, 0, this.Hf + height);
                    break;
                case 1:
                case 3:
                    if (this.Hb) {
                        nc();
                    } else {
                        this.Hg.ne();
                    }
                    new Handler().postDelayed(new b(this), 200L);
                    break;
                case 2:
                    float f = this.Hd - this.Hc;
                    float f2 = this.GZ - this.GY;
                    this.Hc = this.Hd;
                    if (this.GW.getParent() == this && this.Ha != null && this.GW.isShown() && this.GW.getTop() >= 0 && Math.abs(f2) >= this.He && Math.abs(f) < this.He) {
                        int l = this.Ha.l(this.GZ - this.GY);
                        if (l > this.Ha.startY && l <= this.Ha.Hj) {
                            this.Hb = true;
                            this.GW.setLayoutParams(new AbsListView.LayoutParams(this.GW.getWidth(), l));
                            j(l - this.Ha.startY);
                            break;
                        } else if (l <= this.Ha.startY) {
                            this.Hb = false;
                            break;
                        } else if (l > this.Ha.Hj) {
                            this.Hb = true;
                            break;
                        } else {
                            this.Hb = false;
                            break;
                        }
                    } else {
                        this.Hb = false;
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
        if (this.Hb) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hb) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nc() {
        if (this.Ha != null) {
            if (this.GW.getHeight() >= this.Ha.Hj - (this.Hf / 2)) {
                nd();
            } else {
                this.Hg.ne();
            }
            this.mScroller.startScroll(0, this.GW.getHeight(), 0, this.Ha.startY - this.GW.getHeight(), 200);
            invalidate();
            this.Hb = false;
        }
    }

    public void nd() {
        if (this.Hg != null) {
            this.Hg.nf();
        }
    }

    public void setExpandListRefreshListener(c cVar) {
        this.Hg = cVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GW.setLayoutParams(new AbsListView.LayoutParams(this.GW.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.Hg.k(360.0f - ((f * 360.0f) / this.Hf));
    }
}

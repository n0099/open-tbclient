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
    private boolean MA;
    private float MB;
    private final int MC;
    private final int MD;
    public a ME;
    private View Mw;
    private int Mx;
    private float My;
    private b Mz;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nF();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MA = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.MC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.MD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Mw = view;
        this.Mx = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.My = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Mw.getHeight();
                    this.startY = this.My;
                    this.startX = this.MB;
                    this.Mz = new b(0, height, 0, this.MD + height);
                    break;
                case 1:
                case 3:
                    if (this.MA) {
                        nD();
                    } else {
                        this.ME.nF();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Mw.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Mw.getWidth(), BdExpandListView.this.Mx));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.MB - this.startX;
                    float f2 = this.My - this.startY;
                    this.startX = this.MB;
                    if (this.Mw.getParent() == this && this.Mz != null && this.Mw.isShown() && this.Mw.getTop() >= 0 && Math.abs(f2) >= this.MC && Math.abs(f) < this.MC) {
                        int O = this.Mz.O(this.My - this.startY);
                        if (O > this.Mz.startY && O <= this.Mz.endY) {
                            this.MA = true;
                            this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), O));
                            M(O - this.Mz.startY);
                            break;
                        } else if (O <= this.Mz.startY) {
                            this.MA = false;
                            break;
                        } else if (O > this.Mz.endY) {
                            this.MA = true;
                            break;
                        } else {
                            this.MA = false;
                            break;
                        }
                    } else {
                        this.MA = false;
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
        if (this.MA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nD() {
        if (this.Mz != null) {
            if (this.Mw.getHeight() >= this.Mz.endY - (this.MD / 2)) {
                nE();
            } else {
                this.ME.nF();
            }
            this.mScroller.startScroll(0, this.Mw.getHeight(), 0, this.Mz.startY - this.Mw.getHeight(), 200);
            invalidate();
            this.MA = false;
        }
    }

    public void nE() {
        if (this.ME != null) {
            this.ME.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.ME = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.ME.N(360.0f - ((f * 360.0f) / this.MD));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

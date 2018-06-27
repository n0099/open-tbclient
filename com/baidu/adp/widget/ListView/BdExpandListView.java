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
    private boolean LA;
    private float LB;
    private float LC;
    private final int LD;
    private final int LE;
    public a LG;
    private View Lv;
    private int Lw;
    private float Lx;
    private float Ly;
    private b Lz;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void nm();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LA = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.LD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.LE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lv = view;
        this.Lw = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ly = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lv.getHeight();
                    this.Lx = this.Ly;
                    this.LB = this.LC;
                    this.Lz = new b(0, height, 0, this.LE + height);
                    break;
                case 1:
                case 3:
                    if (this.LA) {
                        nk();
                    } else {
                        this.LG.nm();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Lv.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lv.getWidth(), BdExpandListView.this.Lw));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.LC - this.LB;
                    float f2 = this.Ly - this.Lx;
                    this.LB = this.LC;
                    if (this.Lv.getParent() == this && this.Lz != null && this.Lv.isShown() && this.Lv.getTop() >= 0 && Math.abs(f2) >= this.LD && Math.abs(f) < this.LD) {
                        int O = this.Lz.O(this.Ly - this.Lx);
                        if (O > this.Lz.startY && O <= this.Lz.endY) {
                            this.LA = true;
                            this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), O));
                            M(O - this.Lz.startY);
                            break;
                        } else if (O <= this.Lz.startY) {
                            this.LA = false;
                            break;
                        } else if (O > this.Lz.endY) {
                            this.LA = true;
                            break;
                        } else {
                            this.LA = false;
                            break;
                        }
                    } else {
                        this.LA = false;
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
        if (this.LA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.LA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.Lz != null) {
            if (this.Lv.getHeight() >= this.Lz.endY - (this.LE / 2)) {
                nl();
            } else {
                this.LG.nm();
            }
            this.mScroller.startScroll(0, this.Lv.getHeight(), 0, this.Lz.startY - this.Lv.getHeight(), 200);
            invalidate();
            this.LA = false;
        }
    }

    public void nl() {
        if (this.LG != null) {
            this.LG.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.LG = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.LG.N(360.0f - ((f * 360.0f) / this.LE));
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

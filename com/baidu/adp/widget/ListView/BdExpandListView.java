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
    private float LA;
    private final int LB;
    private final int LC;
    public a LD;
    private View Lt;
    private int Lu;
    private float Lv;
    private float Lw;
    private b Lx;
    private boolean Ly;
    private float Lz;
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
        this.Ly = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.LB = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.LC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Lt = view;
        this.Lu = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Lw = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lt.getHeight();
                    this.Lv = this.Lw;
                    this.Lz = this.LA;
                    this.Lx = new b(0, height, 0, this.LC + height);
                    break;
                case 1:
                case 3:
                    if (this.Ly) {
                        nk();
                    } else {
                        this.LD.nm();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Lt.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Lt.getWidth(), BdExpandListView.this.Lu));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.LA - this.Lz;
                    float f2 = this.Lw - this.Lv;
                    this.Lz = this.LA;
                    if (this.Lt.getParent() == this && this.Lx != null && this.Lt.isShown() && this.Lt.getTop() >= 0 && Math.abs(f2) >= this.LB && Math.abs(f) < this.LB) {
                        int O = this.Lx.O(this.Lw - this.Lv);
                        if (O > this.Lx.startY && O <= this.Lx.endY) {
                            this.Ly = true;
                            this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), O));
                            M(O - this.Lx.startY);
                            break;
                        } else if (O <= this.Lx.startY) {
                            this.Ly = false;
                            break;
                        } else if (O > this.Lx.endY) {
                            this.Ly = true;
                            break;
                        } else {
                            this.Ly = false;
                            break;
                        }
                    } else {
                        this.Ly = false;
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
        if (this.Ly) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ly) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nk() {
        if (this.Lx != null) {
            if (this.Lt.getHeight() >= this.Lx.endY - (this.LC / 2)) {
                nl();
            } else {
                this.LD.nm();
            }
            this.mScroller.startScroll(0, this.Lt.getHeight(), 0, this.Lx.startY - this.Lt.getHeight(), 200);
            invalidate();
            this.Ly = false;
        }
    }

    public void nl() {
        if (this.LD != null) {
            this.LD.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.LD = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.LD.N(360.0f - ((f * 360.0f) / this.LC));
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

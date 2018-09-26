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
    private View NU;
    private int NV;
    private float NW;
    private float NX;
    private b NY;
    private boolean NZ;
    private float Oa;
    private float Ob;
    private final int Oc;
    private final int Od;
    public a Oe;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void onRefresh();

        void ou();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NZ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Oc = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Od = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.NU = view;
        this.NV = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.NX = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.NU.getHeight();
                    this.NW = this.NX;
                    this.Oa = this.Ob;
                    this.NY = new b(0, height, 0, this.Od + height);
                    break;
                case 1:
                case 3:
                    if (this.NZ) {
                        os();
                    } else {
                        this.Oe.ou();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.NU.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.NU.getWidth(), BdExpandListView.this.NV));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Ob - this.Oa;
                    float f2 = this.NX - this.NW;
                    this.Oa = this.Ob;
                    if (this.NU.getParent() == this && this.NY != null && this.NU.isShown() && this.NU.getTop() >= 0 && Math.abs(f2) >= this.Oc && Math.abs(f) < this.Oc) {
                        int O = this.NY.O(this.NX - this.NW);
                        if (O > this.NY.startY && O <= this.NY.endY) {
                            this.NZ = true;
                            this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), O));
                            M(O - this.NY.startY);
                            break;
                        } else if (O <= this.NY.startY) {
                            this.NZ = false;
                            break;
                        } else if (O > this.NY.endY) {
                            this.NZ = true;
                            break;
                        } else {
                            this.NZ = false;
                            break;
                        }
                    } else {
                        this.NZ = false;
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
        if (this.NZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.NZ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void os() {
        if (this.NY != null) {
            if (this.NU.getHeight() >= this.NY.endY - (this.Od / 2)) {
                ot();
            } else {
                this.Oe.ou();
            }
            this.mScroller.startScroll(0, this.NU.getHeight(), 0, this.NY.startY - this.NU.getHeight(), 200);
            invalidate();
            this.NZ = false;
        }
    }

    public void ot() {
        if (this.Oe != null) {
            this.Oe.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Oe = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.Oe.N(360.0f - ((f * 360.0f) / this.Od));
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

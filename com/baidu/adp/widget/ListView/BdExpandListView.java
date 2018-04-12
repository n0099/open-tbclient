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
    public a FA;
    private View Fq;
    private int Fr;
    private float Fs;
    private float Ft;
    private b Fu;
    private boolean Fv;
    private float Fw;
    private float Fx;
    private final int Fy;
    private final int Fz;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void D(float f);

        void kz();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fv = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Fy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Fz = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2, int i) {
        this.Fq = view2;
        this.Fr = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ft = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Fq.getHeight();
                    this.Fs = this.Ft;
                    this.Fw = this.Fx;
                    this.Fu = new b(0, height, 0, this.Fz + height);
                    break;
                case 1:
                case 3:
                    if (this.Fv) {
                        kx();
                    } else {
                        this.FA.kz();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Fq.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Fq.getWidth(), BdExpandListView.this.Fr));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Fx - this.Fw;
                    float f2 = this.Ft - this.Fs;
                    this.Fw = this.Fx;
                    if (this.Fq.getParent() == this && this.Fu != null && this.Fq.isShown() && this.Fq.getTop() >= 0 && Math.abs(f2) >= this.Fy && Math.abs(f) < this.Fy) {
                        int E = this.Fu.E(this.Ft - this.Fs);
                        if (E > this.Fu.startY && E <= this.Fu.endY) {
                            this.Fv = true;
                            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), E));
                            C(E - this.Fu.startY);
                            break;
                        } else if (E <= this.Fu.startY) {
                            this.Fv = false;
                            break;
                        } else if (E > this.Fu.endY) {
                            this.Fv = true;
                            break;
                        } else {
                            this.Fv = false;
                            break;
                        }
                    } else {
                        this.Fv = false;
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
        if (this.Fv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Fv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kx() {
        if (this.Fu != null) {
            if (this.Fq.getHeight() >= this.Fu.endY - (this.Fz / 2)) {
                ky();
            } else {
                this.FA.kz();
            }
            this.mScroller.startScroll(0, this.Fq.getHeight(), 0, this.Fu.startY - this.Fq.getHeight(), 200);
            invalidate();
            this.Fv = false;
        }
    }

    public void ky() {
        if (this.FA != null) {
            this.FA.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.FA = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void C(float f) {
        this.FA.D(360.0f - ((f * 360.0f) / this.Fz));
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

        public int E(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

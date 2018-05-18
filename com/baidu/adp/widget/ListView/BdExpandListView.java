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
    private View Fm;
    private int Fn;
    private float Fo;
    private float Fp;
    private b Fq;
    private boolean Fr;
    private float Fs;
    private float Ft;
    private final int Fu;
    private final int Fv;
    public a Fw;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void D(float f);

        void ky();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fr = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Fu = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Fv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2, int i) {
        this.Fm = view2;
        this.Fn = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Fp = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Fm.getHeight();
                    this.Fo = this.Fp;
                    this.Fs = this.Ft;
                    this.Fq = new b(0, height, 0, this.Fv + height);
                    break;
                case 1:
                case 3:
                    if (this.Fr) {
                        kw();
                    } else {
                        this.Fw.ky();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Fm.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Fm.getWidth(), BdExpandListView.this.Fn));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Ft - this.Fs;
                    float f2 = this.Fp - this.Fo;
                    this.Fs = this.Ft;
                    if (this.Fm.getParent() == this && this.Fq != null && this.Fm.isShown() && this.Fm.getTop() >= 0 && Math.abs(f2) >= this.Fu && Math.abs(f) < this.Fu) {
                        int E = this.Fq.E(this.Fp - this.Fo);
                        if (E > this.Fq.startY && E <= this.Fq.endY) {
                            this.Fr = true;
                            this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), E));
                            C(E - this.Fq.startY);
                            break;
                        } else if (E <= this.Fq.startY) {
                            this.Fr = false;
                            break;
                        } else if (E > this.Fq.endY) {
                            this.Fr = true;
                            break;
                        } else {
                            this.Fr = false;
                            break;
                        }
                    } else {
                        this.Fr = false;
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
        if (this.Fr) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Fr) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kw() {
        if (this.Fq != null) {
            if (this.Fm.getHeight() >= this.Fq.endY - (this.Fv / 2)) {
                kx();
            } else {
                this.Fw.ky();
            }
            this.mScroller.startScroll(0, this.Fm.getHeight(), 0, this.Fq.startY - this.Fm.getHeight(), 200);
            invalidate();
            this.Fr = false;
        }
    }

    public void kx() {
        if (this.Fw != null) {
            this.Fw.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Fw = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void C(float f) {
        this.Fw.D(360.0f - ((f * 360.0f) / this.Fv));
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

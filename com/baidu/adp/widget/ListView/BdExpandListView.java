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
    private View Ji;
    private int Jj;
    private float Jk;
    private float Jl;
    private b Jm;
    private boolean Jn;
    private float Jo;
    private float Jp;
    private final int Jq;
    private final int Jr;
    public a Js;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void li();

        void lj();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jn = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Jr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ji = view;
        this.Jj = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Jl = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ji.getHeight();
                    this.Jk = this.Jl;
                    this.Jo = this.Jp;
                    this.Jm = new b(0, height, 0, this.Jr + height);
                    break;
                case 1:
                case 3:
                    if (this.Jn) {
                        lg();
                    } else {
                        this.Js.li();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Ji.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ji.getWidth(), BdExpandListView.this.Jj));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Jp - this.Jo;
                    float f2 = this.Jl - this.Jk;
                    this.Jo = this.Jp;
                    if (this.Ji.getParent() == this && this.Jm != null && this.Ji.isShown() && this.Ji.getTop() >= 0 && Math.abs(f2) >= this.Jq && Math.abs(f) < this.Jq) {
                        int H = this.Jm.H(this.Jl - this.Jk);
                        if (H > this.Jm.Jv && H <= this.Jm.Jx) {
                            this.Jn = true;
                            this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), H));
                            F(H - this.Jm.Jv);
                            break;
                        } else if (H <= this.Jm.Jv) {
                            this.Jn = false;
                            break;
                        } else if (H > this.Jm.Jx) {
                            this.Jn = true;
                            break;
                        } else {
                            this.Jn = false;
                            break;
                        }
                    } else {
                        this.Jn = false;
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
        if (this.Jn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lg() {
        if (this.Jm != null) {
            if (this.Ji.getHeight() >= this.Jm.Jx - (this.Jr / 2)) {
                lh();
            } else {
                this.Js.li();
            }
            this.mScroller.startScroll(0, this.Ji.getHeight(), 0, this.Jm.Jv - this.Ji.getHeight(), 200);
            invalidate();
            this.Jn = false;
        }
    }

    public void lh() {
        if (this.Js != null) {
            this.Js.lj();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Js = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.Js.G(360.0f - ((f * 360.0f) / this.Jr));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Ju;
        public int Jv;
        public int Jw;
        public int Jx;

        public b(int i, int i2, int i3, int i4) {
            this.Ju = i;
            this.Jv = i2;
            this.Jw = i3;
            this.Jx = i4;
        }

        public int H(float f) {
            return (int) (this.Jv + (f / 2.5f));
        }
    }
}

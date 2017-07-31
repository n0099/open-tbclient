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
    private View Jg;
    private int Jh;
    private float Ji;
    private float Jj;
    private b Jk;
    private boolean Jl;
    private float Jm;
    private float Jn;
    private final int Jo;
    private final int Jp;
    public a Jq;
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
        this.Jl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Jp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Jg = view;
        this.Jh = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Jj = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Jg.getHeight();
                    this.Ji = this.Jj;
                    this.Jm = this.Jn;
                    this.Jk = new b(0, height, 0, this.Jp + height);
                    break;
                case 1:
                case 3:
                    if (this.Jl) {
                        lg();
                    } else {
                        this.Jq.li();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Jg.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Jg.getWidth(), BdExpandListView.this.Jh));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Jn - this.Jm;
                    float f2 = this.Jj - this.Ji;
                    this.Jm = this.Jn;
                    if (this.Jg.getParent() == this && this.Jk != null && this.Jg.isShown() && this.Jg.getTop() >= 0 && Math.abs(f2) >= this.Jo && Math.abs(f) < this.Jo) {
                        int H = this.Jk.H(this.Jj - this.Ji);
                        if (H > this.Jk.Jt && H <= this.Jk.Jv) {
                            this.Jl = true;
                            this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), H));
                            F(H - this.Jk.Jt);
                            break;
                        } else if (H <= this.Jk.Jt) {
                            this.Jl = false;
                            break;
                        } else if (H > this.Jk.Jv) {
                            this.Jl = true;
                            break;
                        } else {
                            this.Jl = false;
                            break;
                        }
                    } else {
                        this.Jl = false;
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
        if (this.Jl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lg() {
        if (this.Jk != null) {
            if (this.Jg.getHeight() >= this.Jk.Jv - (this.Jp / 2)) {
                lh();
            } else {
                this.Jq.li();
            }
            this.mScroller.startScroll(0, this.Jg.getHeight(), 0, this.Jk.Jt - this.Jg.getHeight(), 200);
            invalidate();
            this.Jl = false;
        }
    }

    public void lh() {
        if (this.Jq != null) {
            this.Jq.lj();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Jq = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.Jq.G(360.0f - ((f * 360.0f) / this.Jp));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Js;
        public int Jt;
        public int Ju;
        public int Jv;

        public b(int i, int i2, int i3, int i4) {
            this.Js = i;
            this.Jt = i2;
            this.Ju = i3;
            this.Jv = i4;
        }

        public int H(float f) {
            return (int) (this.Jt + (f / 2.5f));
        }
    }
}

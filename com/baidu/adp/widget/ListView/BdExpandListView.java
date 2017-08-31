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
    private View Ha;
    private int Hb;
    private float Hc;
    private float Hd;
    private b He;
    private boolean Hf;
    private float Hg;
    private float Hh;
    private final int Hi;
    private final int Hj;
    public a Hk;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kZ();

        void la();

        void v(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hf = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hi = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Hj = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ha = view;
        this.Hb = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hd = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ha.getHeight();
                    this.Hc = this.Hd;
                    this.Hg = this.Hh;
                    this.He = new b(0, height, 0, this.Hj + height);
                    break;
                case 1:
                case 3:
                    if (this.Hf) {
                        kX();
                    } else {
                        this.Hk.kZ();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Ha.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ha.getWidth(), BdExpandListView.this.Hb));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Hh - this.Hg;
                    float f2 = this.Hd - this.Hc;
                    this.Hg = this.Hh;
                    if (this.Ha.getParent() == this && this.He != null && this.Ha.isShown() && this.Ha.getTop() >= 0 && Math.abs(f2) >= this.Hi && Math.abs(f) < this.Hi) {
                        int w = this.He.w(this.Hd - this.Hc);
                        if (w > this.He.Hn && w <= this.He.Hp) {
                            this.Hf = true;
                            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), w));
                            u(w - this.He.Hn);
                            break;
                        } else if (w <= this.He.Hn) {
                            this.Hf = false;
                            break;
                        } else if (w > this.He.Hp) {
                            this.Hf = true;
                            break;
                        } else {
                            this.Hf = false;
                            break;
                        }
                    } else {
                        this.Hf = false;
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
        if (this.Hf) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hf) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kX() {
        if (this.He != null) {
            if (this.Ha.getHeight() >= this.He.Hp - (this.Hj / 2)) {
                kY();
            } else {
                this.Hk.kZ();
            }
            this.mScroller.startScroll(0, this.Ha.getHeight(), 0, this.He.Hn - this.Ha.getHeight(), 200);
            invalidate();
            this.Hf = false;
        }
    }

    public void kY() {
        if (this.Hk != null) {
            this.Hk.la();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Hk = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void u(float f) {
        this.Hk.v(360.0f - ((f * 360.0f) / this.Hj));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hm;
        public int Hn;
        public int Ho;
        public int Hp;

        public b(int i, int i2, int i3, int i4) {
            this.Hm = i;
            this.Hn = i2;
            this.Ho = i3;
            this.Hp = i4;
        }

        public int w(float f) {
            return (int) (this.Hn + (f / 2.5f));
        }
    }
}

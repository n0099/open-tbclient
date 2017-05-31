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
    private View HG;
    private int HH;
    private float HI;
    private float HJ;
    private b HK;
    private boolean HL;
    private float HM;
    private float HN;
    private final int HO;
    private final int HP;
    public a HQ;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void lc();

        void ld();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HL = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HO = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HP = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HG = view;
        this.HH = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HJ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HG.getHeight();
                    this.HI = this.HJ;
                    this.HM = this.HN;
                    this.HK = new b(0, height, 0, this.HP + height);
                    break;
                case 1:
                case 3:
                    if (this.HL) {
                        la();
                    } else {
                        this.HQ.lc();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.HN - this.HM;
                    float f2 = this.HJ - this.HI;
                    this.HM = this.HN;
                    if (this.HG.getParent() == this && this.HK != null && this.HG.isShown() && this.HG.getTop() >= 0 && Math.abs(f2) >= this.HO && Math.abs(f) < this.HO) {
                        int H = this.HK.H(this.HJ - this.HI);
                        if (H > this.HK.HT && H <= this.HK.HV) {
                            this.HL = true;
                            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), H));
                            F(H - this.HK.HT);
                            break;
                        } else if (H <= this.HK.HT) {
                            this.HL = false;
                            break;
                        } else if (H > this.HK.HV) {
                            this.HL = true;
                            break;
                        } else {
                            this.HL = false;
                            break;
                        }
                    } else {
                        this.HL = false;
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
        if (this.HL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HL) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void la() {
        if (this.HK != null) {
            if (this.HG.getHeight() >= this.HK.HV - (this.HP / 2)) {
                lb();
            } else {
                this.HQ.lc();
            }
            this.mScroller.startScroll(0, this.HG.getHeight(), 0, this.HK.HT - this.HG.getHeight(), 200);
            invalidate();
            this.HL = false;
        }
    }

    public void lb() {
        if (this.HQ != null) {
            this.HQ.ld();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.HQ = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.HQ.G(360.0f - ((f * 360.0f) / this.HP));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HS;
        public int HT;
        public int HU;
        public int HV;

        public b(int i, int i2, int i3, int i4) {
            this.HS = i;
            this.HT = i2;
            this.HU = i3;
            this.HV = i4;
        }

        public int H(float f) {
            return (int) (this.HT + (f / 2.5f));
        }
    }
}

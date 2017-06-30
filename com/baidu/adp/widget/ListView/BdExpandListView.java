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
    private View HF;
    private int HG;
    private float HH;
    private float HI;
    private b HJ;
    private boolean HK;
    private float HL;
    private float HM;
    private final int HN;
    private final int HO;
    public a HP;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void la();

        void lb();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HK = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HO = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HF = view;
        this.HG = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HI = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HF.getHeight();
                    this.HH = this.HI;
                    this.HL = this.HM;
                    this.HJ = new b(0, height, 0, this.HO + height);
                    break;
                case 1:
                case 3:
                    if (this.HK) {
                        kY();
                    } else {
                        this.HP.la();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.HM - this.HL;
                    float f2 = this.HI - this.HH;
                    this.HL = this.HM;
                    if (this.HF.getParent() == this && this.HJ != null && this.HF.isShown() && this.HF.getTop() >= 0 && Math.abs(f2) >= this.HN && Math.abs(f) < this.HN) {
                        int H = this.HJ.H(this.HI - this.HH);
                        if (H > this.HJ.HS && H <= this.HJ.HU) {
                            this.HK = true;
                            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), H));
                            F(H - this.HJ.HS);
                            break;
                        } else if (H <= this.HJ.HS) {
                            this.HK = false;
                            break;
                        } else if (H > this.HJ.HU) {
                            this.HK = true;
                            break;
                        } else {
                            this.HK = false;
                            break;
                        }
                    } else {
                        this.HK = false;
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
        if (this.HK) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HK) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kY() {
        if (this.HJ != null) {
            if (this.HF.getHeight() >= this.HJ.HU - (this.HO / 2)) {
                kZ();
            } else {
                this.HP.la();
            }
            this.mScroller.startScroll(0, this.HF.getHeight(), 0, this.HJ.HS - this.HF.getHeight(), 200);
            invalidate();
            this.HK = false;
        }
    }

    public void kZ() {
        if (this.HP != null) {
            this.HP.lb();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.HP = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.HP.G(360.0f - ((f * 360.0f) / this.HO));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HR;
        public int HS;
        public int HT;
        public int HU;

        public b(int i, int i2, int i3, int i4) {
            this.HR = i;
            this.HS = i2;
            this.HT = i3;
            this.HU = i4;
        }

        public int H(float f) {
            return (int) (this.HS + (f / 2.5f));
        }
    }
}

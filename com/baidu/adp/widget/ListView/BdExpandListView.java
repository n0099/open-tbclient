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
    private View HH;
    private int HI;
    private float HJ;
    private float HK;
    private b HL;
    private boolean HM;
    private float HN;
    private float HO;
    private final int HP;
    private final int HQ;
    public a HR;
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
        this.HM = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HP = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HQ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HH = view;
        this.HI = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HK = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HH.getHeight();
                    this.HJ = this.HK;
                    this.HN = this.HO;
                    this.HL = new b(0, height, 0, this.HQ + height);
                    break;
                case 1:
                case 3:
                    if (this.HM) {
                        la();
                    } else {
                        this.HR.lc();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.HO - this.HN;
                    float f2 = this.HK - this.HJ;
                    this.HN = this.HO;
                    if (this.HH.getParent() == this && this.HL != null && this.HH.isShown() && this.HH.getTop() >= 0 && Math.abs(f2) >= this.HP && Math.abs(f) < this.HP) {
                        int H = this.HL.H(this.HK - this.HJ);
                        if (H > this.HL.HU && H <= this.HL.HW) {
                            this.HM = true;
                            this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), H));
                            F(H - this.HL.HU);
                            break;
                        } else if (H <= this.HL.HU) {
                            this.HM = false;
                            break;
                        } else if (H > this.HL.HW) {
                            this.HM = true;
                            break;
                        } else {
                            this.HM = false;
                            break;
                        }
                    } else {
                        this.HM = false;
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
        if (this.HM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HM) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void la() {
        if (this.HL != null) {
            if (this.HH.getHeight() >= this.HL.HW - (this.HQ / 2)) {
                lb();
            } else {
                this.HR.lc();
            }
            this.mScroller.startScroll(0, this.HH.getHeight(), 0, this.HL.HU - this.HH.getHeight(), 200);
            invalidate();
            this.HM = false;
        }
    }

    public void lb() {
        if (this.HR != null) {
            this.HR.ld();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.HR = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.HR.G(360.0f - ((f * 360.0f) / this.HQ));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HT;
        public int HU;
        public int HV;
        public int HW;

        public b(int i, int i2, int i3, int i4) {
            this.HT = i;
            this.HU = i2;
            this.HV = i3;
            this.HW = i4;
        }

        public int H(float f) {
            return (int) (this.HU + (f / 2.5f));
        }
    }
}

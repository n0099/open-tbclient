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
        void k(float f);

        void mR();

        void mS();
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

    public void c(View view, int i) {
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
                        mP();
                    } else {
                        this.HQ.mR();
                    }
                    new Handler().postDelayed(new com.baidu.adp.widget.ListView.b(this), 200L);
                    break;
                case 2:
                    float f = this.HN - this.HM;
                    float f2 = this.HJ - this.HI;
                    this.HM = this.HN;
                    if (this.HG.getParent() == this && this.HK != null && this.HG.isShown() && this.HG.getTop() >= 0 && Math.abs(f2) >= this.HO && Math.abs(f) < this.HO) {
                        int l = this.HK.l(this.HJ - this.HI);
                        if (l > this.HK.startY && l <= this.HK.HT) {
                            this.HL = true;
                            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), l));
                            j(l - this.HK.startY);
                            break;
                        } else if (l <= this.HK.startY) {
                            this.HL = false;
                            break;
                        } else if (l > this.HK.HT) {
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

    public void mP() {
        if (this.HK != null) {
            if (this.HG.getHeight() >= this.HK.HT - (this.HP / 2)) {
                mQ();
            } else {
                this.HQ.mR();
            }
            this.mScroller.startScroll(0, this.HG.getHeight(), 0, this.HK.startY - this.HG.getHeight(), 200);
            invalidate();
            this.HL = false;
        }
    }

    public void mQ() {
        if (this.HQ != null) {
            this.HQ.mS();
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

    private void j(float f) {
        this.HQ.k(360.0f - ((f * 360.0f) / this.HP));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HS;
        public int HT;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.HS = i3;
            this.HT = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

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
    private boolean OA;
    private float OB;
    private final int OC;
    private final int OD;
    public a OE;
    private View Ow;
    private int Ox;
    private float Oy;
    private b Oz;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oG();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OA = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.OD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Ow = view;
        this.Ox = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Oy = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ow.getHeight();
                    this.startY = this.Oy;
                    this.startX = this.OB;
                    this.Oz = new b(0, height, 0, this.OD + height);
                    break;
                case 1:
                case 3:
                    if (this.OA) {
                        oE();
                    } else {
                        this.OE.oG();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Ow.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ow.getWidth(), BdExpandListView.this.Ox));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.OB - this.startX;
                    float f2 = this.Oy - this.startY;
                    this.startX = this.OB;
                    if (this.Ow.getParent() == this && this.Oz != null && this.Ow.isShown() && this.Ow.getTop() >= 0 && Math.abs(f2) >= this.OC && Math.abs(f) < this.OC) {
                        int O = this.Oz.O(this.Oy - this.startY);
                        if (O > this.Oz.startY && O <= this.Oz.endY) {
                            this.OA = true;
                            this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), O));
                            M(O - this.Oz.startY);
                            break;
                        } else if (O <= this.Oz.startY) {
                            this.OA = false;
                            break;
                        } else if (O > this.Oz.endY) {
                            this.OA = true;
                            break;
                        } else {
                            this.OA = false;
                            break;
                        }
                    } else {
                        this.OA = false;
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
        if (this.OA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oE() {
        if (this.Oz != null) {
            if (this.Ow.getHeight() >= this.Oz.endY - (this.OD / 2)) {
                oF();
            } else {
                this.OE.oG();
            }
            this.mScroller.startScroll(0, this.Ow.getHeight(), 0, this.Oz.startY - this.Ow.getHeight(), 200);
            invalidate();
            this.OA = false;
        }
    }

    public void oF() {
        if (this.OE != null) {
            this.OE.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.OE = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.OE.N(360.0f - ((f * 360.0f) / this.OD));
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

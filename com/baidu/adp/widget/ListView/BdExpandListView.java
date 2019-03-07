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
    private View OO;
    private int OP;
    private float OQ;
    private b OR;
    private boolean OT;
    private float OU;
    private final int OV;
    private final int OW;
    public a OX;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oL();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OT = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.OW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.OO = view;
        this.OP = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.OQ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.OO.getHeight();
                    this.startY = this.OQ;
                    this.startX = this.OU;
                    this.OR = new b(0, height, 0, this.OW + height);
                    break;
                case 1:
                case 3:
                    if (this.OT) {
                        oJ();
                    } else {
                        this.OX.oL();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.OO.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.OO.getWidth(), BdExpandListView.this.OP));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.OU - this.startX;
                    float f2 = this.OQ - this.startY;
                    this.startX = this.OU;
                    if (this.OO.getParent() == this && this.OR != null && this.OO.isShown() && this.OO.getTop() >= 0 && Math.abs(f2) >= this.OV && Math.abs(f) < this.OV) {
                        int O = this.OR.O(this.OQ - this.startY);
                        if (O > this.OR.startY && O <= this.OR.endY) {
                            this.OT = true;
                            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), O));
                            M(O - this.OR.startY);
                            break;
                        } else if (O <= this.OR.startY) {
                            this.OT = false;
                            break;
                        } else if (O > this.OR.endY) {
                            this.OT = true;
                            break;
                        } else {
                            this.OT = false;
                            break;
                        }
                    } else {
                        this.OT = false;
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
        if (this.OT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oJ() {
        if (this.OR != null) {
            if (this.OO.getHeight() >= this.OR.endY - (this.OW / 2)) {
                oK();
            } else {
                this.OX.oL();
            }
            this.mScroller.startScroll(0, this.OO.getHeight(), 0, this.OR.startY - this.OO.getHeight(), 200);
            invalidate();
            this.OT = false;
        }
    }

    public void oK() {
        if (this.OX != null) {
            this.OX.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.OX = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.OX.N(360.0f - ((f * 360.0f) / this.OW));
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

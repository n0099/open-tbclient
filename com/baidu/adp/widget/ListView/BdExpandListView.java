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
    private View OP;
    private int OQ;
    private float OR;
    private b OT;
    private boolean OU;
    private float OV;
    private final int OW;
    private final int OX;
    public a OY;
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
        this.OU = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.OX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.OP = view;
        this.OQ = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.OR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.OP.getHeight();
                    this.startY = this.OR;
                    this.startX = this.OV;
                    this.OT = new b(0, height, 0, this.OX + height);
                    break;
                case 1:
                case 3:
                    if (this.OU) {
                        oJ();
                    } else {
                        this.OY.oL();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.OP.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.OP.getWidth(), BdExpandListView.this.OQ));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.OV - this.startX;
                    float f2 = this.OR - this.startY;
                    this.startX = this.OV;
                    if (this.OP.getParent() == this && this.OT != null && this.OP.isShown() && this.OP.getTop() >= 0 && Math.abs(f2) >= this.OW && Math.abs(f) < this.OW) {
                        int O = this.OT.O(this.OR - this.startY);
                        if (O > this.OT.startY && O <= this.OT.endY) {
                            this.OU = true;
                            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), O));
                            M(O - this.OT.startY);
                            break;
                        } else if (O <= this.OT.startY) {
                            this.OU = false;
                            break;
                        } else if (O > this.OT.endY) {
                            this.OU = true;
                            break;
                        } else {
                            this.OU = false;
                            break;
                        }
                    } else {
                        this.OU = false;
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
        if (this.OU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oJ() {
        if (this.OT != null) {
            if (this.OP.getHeight() >= this.OT.endY - (this.OX / 2)) {
                oK();
            } else {
                this.OY.oL();
            }
            this.mScroller.startScroll(0, this.OP.getHeight(), 0, this.OT.startY - this.OP.getHeight(), 200);
            invalidate();
            this.OU = false;
        }
    }

    public void oK() {
        if (this.OY != null) {
            this.OY.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.OY = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.OY.N(360.0f - ((f * 360.0f) / this.OX));
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

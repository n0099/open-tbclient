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
    private View On;
    private int Oo;
    private float Op;
    private b Oq;
    private boolean Or;
    private float Os;
    private final int Ot;
    private final int Ou;
    public a Ov;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oC();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Or = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ou = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.On = view;
        this.Oo = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Op = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.On.getHeight();
                    this.startY = this.Op;
                    this.startX = this.Os;
                    this.Oq = new b(0, height, 0, this.Ou + height);
                    break;
                case 1:
                case 3:
                    if (this.Or) {
                        oA();
                    } else {
                        this.Ov.oC();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.On.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.On.getWidth(), BdExpandListView.this.Oo));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Os - this.startX;
                    float f2 = this.Op - this.startY;
                    this.startX = this.Os;
                    if (this.On.getParent() == this && this.Oq != null && this.On.isShown() && this.On.getTop() >= 0 && Math.abs(f2) >= this.Ot && Math.abs(f) < this.Ot) {
                        int O = this.Oq.O(this.Op - this.startY);
                        if (O > this.Oq.startY && O <= this.Oq.endY) {
                            this.Or = true;
                            this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), O));
                            M(O - this.Oq.startY);
                            break;
                        } else if (O <= this.Oq.startY) {
                            this.Or = false;
                            break;
                        } else if (O > this.Oq.endY) {
                            this.Or = true;
                            break;
                        } else {
                            this.Or = false;
                            break;
                        }
                    } else {
                        this.Or = false;
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
        if (this.Or) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Or) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oA() {
        if (this.Oq != null) {
            if (this.On.getHeight() >= this.Oq.endY - (this.Ou / 2)) {
                oB();
            } else {
                this.Ov.oC();
            }
            this.mScroller.startScroll(0, this.On.getHeight(), 0, this.Oq.startY - this.On.getHeight(), 200);
            invalidate();
            this.Or = false;
        }
    }

    public void oB() {
        if (this.Ov != null) {
            this.Ov.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Ov = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.Ov.N(360.0f - ((f * 360.0f) / this.Ou));
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

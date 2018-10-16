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
    private View Ok;
    private int Ol;
    private float Om;
    private float On;
    private b Oo;
    private boolean Op;
    private float Oq;
    private float Or;
    private final int Os;
    private final int Ot;
    public a Ou;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oF();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Op = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Os = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Ot = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.Ok = view;
        this.Ol = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.On = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ok.getHeight();
                    this.Om = this.On;
                    this.Oq = this.Or;
                    this.Oo = new b(0, height, 0, this.Ot + height);
                    break;
                case 1:
                case 3:
                    if (this.Op) {
                        oD();
                    } else {
                        this.Ou.oF();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.Ok.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ok.getWidth(), BdExpandListView.this.Ol));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.Or - this.Oq;
                    float f2 = this.On - this.Om;
                    this.Oq = this.Or;
                    if (this.Ok.getParent() == this && this.Oo != null && this.Ok.isShown() && this.Ok.getTop() >= 0 && Math.abs(f2) >= this.Os && Math.abs(f) < this.Os) {
                        int O = this.Oo.O(this.On - this.Om);
                        if (O > this.Oo.startY && O <= this.Oo.endY) {
                            this.Op = true;
                            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), O));
                            M(O - this.Oo.startY);
                            break;
                        } else if (O <= this.Oo.startY) {
                            this.Op = false;
                            break;
                        } else if (O > this.Oo.endY) {
                            this.Op = true;
                            break;
                        } else {
                            this.Op = false;
                            break;
                        }
                    } else {
                        this.Op = false;
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
        if (this.Op) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Op) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oD() {
        if (this.Oo != null) {
            if (this.Ok.getHeight() >= this.Oo.endY - (this.Ot / 2)) {
                oE();
            } else {
                this.Ou.oF();
            }
            this.mScroller.startScroll(0, this.Ok.getHeight(), 0, this.Oo.startY - this.Ok.getHeight(), 200);
            invalidate();
            this.Op = false;
        }
    }

    public void oE() {
        if (this.Ou != null) {
            this.Ou.onRefresh();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.Ou = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void M(float f) {
        this.Ou.N(360.0f - ((f * 360.0f) / this.Ot));
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

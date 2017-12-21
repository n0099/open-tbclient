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
    private View GO;
    private int GP;
    private float GQ;
    private float GR;
    private b GT;
    private boolean GU;
    private float GV;
    private float GW;
    private final int GX;
    private final int GY;
    public a GZ;
    private final Context mContext;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.GX = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.GY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.GO = view;
        this.GP = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GO.getHeight();
                    this.GQ = this.GR;
                    this.GV = this.GW;
                    this.GT = new b(0, height, 0, this.GY + height);
                    break;
                case 1:
                case 3:
                    if (this.GU) {
                        kT();
                    } else {
                        this.GZ.kV();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.GO.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GO.getWidth(), BdExpandListView.this.GP));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.GW - this.GV;
                    float f2 = this.GR - this.GQ;
                    this.GV = this.GW;
                    if (this.GO.getParent() == this && this.GT != null && this.GO.isShown() && this.GO.getTop() >= 0 && Math.abs(f2) >= this.GX && Math.abs(f) < this.GX) {
                        int w = this.GT.w(this.GR - this.GQ);
                        if (w > this.GT.startY && w <= this.GT.Hb) {
                            this.GU = true;
                            this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), w));
                            u(w - this.GT.startY);
                            break;
                        } else if (w <= this.GT.startY) {
                            this.GU = false;
                            break;
                        } else if (w > this.GT.Hb) {
                            this.GU = true;
                            break;
                        } else {
                            this.GU = false;
                            break;
                        }
                    } else {
                        this.GU = false;
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
        if (this.GU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kT() {
        if (this.GT != null) {
            if (this.GO.getHeight() >= this.GT.Hb - (this.GY / 2)) {
                kU();
            } else {
                this.GZ.kV();
            }
            this.mScroller.startScroll(0, this.GO.getHeight(), 0, this.GT.startY - this.GO.getHeight(), 200);
            invalidate();
            this.GU = false;
        }
    }

    public void kU() {
        if (this.GZ != null) {
            this.GZ.kW();
        }
    }

    public void setExpandListRefreshListener(a aVar) {
        this.GZ = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void u(float f) {
        this.GZ.v(360.0f - ((f * 360.0f) / this.GY));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hb;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Hb = i4;
        }

        public int w(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}

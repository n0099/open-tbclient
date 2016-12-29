package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int YW;
    private int YX;
    private a YY;
    private c YZ;
    private final Rect Za;
    private final Rect Zb;
    private final Rect Zc;
    private int Zd;
    private int Ze;
    private int Zf;
    private int Zg;
    private int Zh;
    private int Zi;
    private int Zj;
    private boolean Zk;
    private boolean Zl;
    private boolean Zm;
    private int Zn;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.YX = -1;
        this.Za = new Rect();
        this.Zb = new Rect();
        this.Zc = new Rect();
        this.mPaint = new Paint();
        this.Zg = 0;
        this.Zk = true;
        this.Zl = false;
        this.Zm = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YX = -1;
        this.Za = new Rect();
        this.Zb = new Rect();
        this.Zc = new Rect();
        this.mPaint = new Paint();
        this.Zg = 0;
        this.Zk = true;
        this.Zl = false;
        this.Zm = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.Zd = getResources().getDimensionPixelSize(r.e.ds1);
        this.Ze = k.dip2px(getContext(), 1.0f);
        this.Zf = k.dip2px(getContext(), 3.0f);
        this.Zn = getResources().getDimensionPixelSize(r.e.ds10);
        setWillNotDraw(false);
        this.YW = r.d.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.YX != i) {
                if (this.YX != -1) {
                    getChildAt(this.YX).setSelected(false);
                }
                this.YX = i;
                getChildAt(this.YX).setSelected(true);
                if (z) {
                    b(this.YX, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.YZ != null) {
            this.YZ.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        B(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        B(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void B(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.Zm) {
            view.setPadding(0, 0, 0, this.Zn);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.YX = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Zj = this.mWidth / this.mChildCount;
            if (this.YX != -1) {
                b(this.YX, 0.0f);
            }
            int i5 = this.mHeight - this.Zd;
            this.Zb.set(0, i5, this.mWidth, this.Zd + i5);
            this.Zc.set(0, 0, this.mWidth, this.Ze);
        }
    }

    public void b(int i, float f) {
        this.left = this.Zj * i;
        this.left += (int) (this.Zj * f);
        int i2 = this.mHeight - this.Zf;
        if (this.Zg != 0) {
            this.Za.set((this.left + (this.Zj / 2)) - (this.Zg / 2), i2, this.left + (this.Zj / 2) + (this.Zg / 2), this.mHeight);
        } else {
            this.Za.set(this.left, i2, this.left + this.Zj, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YW = i;
    }

    public void onChangeSkinType(int i) {
        if (this.YW != 0) {
            ar.l(this, this.YW);
        }
        this.Zi = ar.getColor(r.d.cp_link_tip_a);
        this.Zh = ar.getColor(r.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).m14do(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.Zh);
        canvas.drawRect(this.Zb, this.mPaint);
        if (this.Zl) {
            canvas.drawRect(this.Zc, this.mPaint);
        }
        if (this.Zk) {
            this.mPaint.setColor(this.Zi);
            canvas.drawRect(this.Za, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Zk = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Zl = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YY = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.YZ = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int Zo;

        private b(int i) {
            this.Zo = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YY.f(this.Zo, true);
        }
    }

    public void aD(boolean z) {
        this.Zm = z;
    }

    public void setDviderRectWidth(int i) {
        this.Zg = i;
    }
}

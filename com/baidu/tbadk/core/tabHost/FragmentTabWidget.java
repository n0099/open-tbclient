package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int adO;
    private int adP;
    private a adQ;
    private c adR;
    private final Rect adS;
    private final Rect adT;
    private final Rect adU;
    private int adV;
    private int adW;
    private int adX;
    private int adY;
    private int adZ;
    private int aea;
    private int aeb;
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private int aef;
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
        this.adP = -1;
        this.adS = new Rect();
        this.adT = new Rect();
        this.adU = new Rect();
        this.mPaint = new Paint();
        this.adY = 0;
        this.aec = true;
        this.aed = false;
        this.aee = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adP = -1;
        this.adS = new Rect();
        this.adT = new Rect();
        this.adU = new Rect();
        this.mPaint = new Paint();
        this.adY = 0;
        this.aec = true;
        this.aed = false;
        this.aee = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adV = getResources().getDimensionPixelSize(w.f.ds1);
        this.adW = k.dip2px(getContext(), 1.0f);
        this.adX = k.dip2px(getContext(), 3.0f);
        this.aef = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.adO = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.adP != i) {
                if (this.adP != -1) {
                    getChildAt(this.adP).setSelected(false);
                }
                this.adP = i;
                getChildAt(this.adP).setSelected(true);
                if (z) {
                    b(this.adP, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adR != null) {
            this.adR.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        x(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        x(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void x(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aee) {
            view.setPadding(0, 0, 0, this.aef);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adP = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeb = this.mWidth / this.mChildCount;
            if (this.adP != -1) {
                b(this.adP, 0.0f);
            }
            int i5 = this.mHeight - this.adV;
            this.adT.set(0, i5, this.mWidth, this.adV + i5);
            this.adU.set(0, 0, this.mWidth, this.adW);
        }
    }

    public void b(int i, float f) {
        this.left = this.aeb * i;
        this.left += (int) (this.aeb * f);
        int i2 = this.mHeight - this.adX;
        if (this.adY != 0) {
            this.adS.set((this.left + (this.aeb / 2)) - (this.adY / 2), i2, this.left + (this.aeb / 2) + (this.adY / 2), this.mHeight);
        } else {
            this.adS.set(this.left, i2, this.left + this.aeb, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adO = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adO != 0) {
            aq.k(this, this.adO);
        }
        this.aea = aq.getColor(w.e.cp_link_tip_a);
        this.adZ = aq.getColor(w.e.cp_bg_line_c);
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
        this.mPaint.setColor(this.adZ);
        canvas.drawRect(this.adT, this.mPaint);
        if (this.aed) {
            canvas.drawRect(this.adU, this.mPaint);
        }
        if (this.aec) {
            this.mPaint.setColor(this.aea);
            canvas.drawRect(this.adS, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aec = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aed = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adQ = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adR = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aeg;

        private b(int i) {
            this.aeg = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adQ.f(this.aeg, true);
        }
    }

    public void aE(boolean z) {
        this.aee = z;
    }

    public void setDviderRectWidth(int i) {
        this.adY = i;
    }
}

package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private boolean avA;
    private boolean avB;
    private boolean avC;
    private int avD;
    private boolean avE;
    private boolean avF;
    private int avo;
    private a avp;
    private c avq;
    private final Rect avr;
    private final Rect avs;
    private final Rect avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private Paint mPaint;
    private int mSelectedTabIndex;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.mSelectedTabIndex = -1;
        this.avr = new Rect();
        this.avs = new Rect();
        this.avt = new Rect();
        this.mPaint = new Paint();
        this.avx = 0;
        this.avA = true;
        this.avB = false;
        this.avC = false;
        this.avE = false;
        this.avF = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.avr = new Rect();
        this.avs = new Rect();
        this.avt = new Rect();
        this.mPaint = new Paint();
        this.avx = 0;
        this.avA = true;
        this.avB = false;
        this.avC = false;
        this.avE = false;
        this.avF = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.avu = getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.avv = l.dip2px(getContext(), 1.0f);
        this.avw = l.dip2px(getContext(), 2.0f);
        this.avD = getResources().getDimensionPixelSize(e.C0175e.ds10);
        setWillNotDraw(false);
        this.avo = e.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.ck(i == i2);
                    i2++;
                }
            }
            if (this.mSelectedTabIndex != i) {
                if (this.mSelectedTabIndex != -1) {
                    getChildAt(this.mSelectedTabIndex).setSelected(false);
                }
                this.mSelectedTabIndex = i;
                getChildAt(this.mSelectedTabIndex).setSelected(true);
                if (z) {
                    d(this.mSelectedTabIndex, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.avq != null) {
            this.avq.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        I(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        I(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void I(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.avE) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.avC) {
            view.setPadding(0, 0, 0, this.avD);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.mSelectedTabIndex = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.avz = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.avu;
            this.avs.set(0, i5, this.mWidth, this.avu + i5);
            this.avt.set(0, 0, this.mWidth, this.avv);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds64);
        int i2 = (this.avz - dimensionPixelSize) / 2;
        this.left = this.avz * i;
        this.left += (int) (this.avz * f);
        int i3 = this.mHeight - this.avw;
        if (this.avx == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.avr.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.avr.set((this.left + (this.avz / 2)) - (this.avx / 2), i3, this.left + (this.avz / 2) + (this.avx / 2), this.mHeight);
                }
            } else {
                this.avr.set((this.left + (this.avz / 2)) - (this.avx / 2), i3, this.left + (this.avz / 2) + (this.avx / 2), this.mHeight);
            }
        } else if (this.avx != 0) {
            this.avr.set((this.left + (this.avz / 2)) - (this.avx / 2), i3, this.left + (this.avz / 2) + (this.avx / 2), this.mHeight);
        } else {
            this.avr.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.avo = i;
    }

    public void onChangeSkinType(int i) {
        if (this.avo != 0) {
            al.j(this, this.avo);
        }
        this.avy = al.getColor(e.d.cp_cont_b);
        this.mDividerColor = al.getColor(e.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).ea(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.avF) {
            canvas.drawRect(this.avs, this.mPaint);
        }
        if (this.avB) {
            canvas.drawRect(this.avt, this.mPaint);
        }
        if (this.avA) {
            this.mPaint.setColor(this.avy);
            canvas.drawRoundRect(new RectF(this.avr), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.avF = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.avA = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.avB = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.avp = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.avq = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int avG;

        private b(int i) {
            this.avG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.avp.onTabSelectionChanged(this.avG, true);
        }
    }

    public void ba(boolean z) {
        this.avC = z;
    }

    public void setDviderRectWidth(int i) {
        this.avx = i;
    }

    public void setDviderRectHeight(int i) {
        this.avw = i;
    }

    public void setDiverColor(int i) {
        this.avy = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.avE = z;
    }
}

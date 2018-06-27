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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private boolean aoA;
    private boolean aoB;
    private boolean aoC;
    private int aoD;
    private boolean aoE;
    private boolean aoF;
    private int aop;
    private a aoq;
    private c aor;
    private final Rect aos;
    private final Rect aot;
    private final Rect aou;
    private int aov;
    private int aow;
    private int aox;
    private int aoy;
    private int aoz;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private int mItemWidth;
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
        this.aos = new Rect();
        this.aot = new Rect();
        this.aou = new Rect();
        this.mPaint = new Paint();
        this.aoy = 0;
        this.aoA = true;
        this.aoB = false;
        this.aoC = false;
        this.aoE = false;
        this.aoF = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.aos = new Rect();
        this.aot = new Rect();
        this.aou = new Rect();
        this.mPaint = new Paint();
        this.aoy = 0;
        this.aoA = true;
        this.aoB = false;
        this.aoC = false;
        this.aoE = false;
        this.aoF = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aov = getResources().getDimensionPixelSize(d.e.ds1);
        this.aow = l.dip2px(getContext(), 1.0f);
        this.aox = l.dip2px(getContext(), 2.0f);
        this.aoD = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aop = d.C0142d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.bQ(i == i2);
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
        if (this.aor != null) {
            this.aor.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        y(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        y(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void y(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.aoE) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aoC) {
            view.setPadding(0, 0, 0, this.aoD);
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
            this.mItemWidth = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.aov;
            this.aot.set(0, i5, this.mWidth, this.aov + i5);
            this.aou.set(0, 0, this.mWidth, this.aow);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.mItemWidth - dimensionPixelSize) / 2;
        this.left = this.mItemWidth * i;
        this.left += (int) (this.mItemWidth * f);
        int i3 = this.mHeight - this.aox;
        if (this.aoy == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.aos.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aos.set((this.left + (this.mItemWidth / 2)) - (this.aoy / 2), i3, this.left + (this.mItemWidth / 2) + (this.aoy / 2), this.mHeight);
                }
            } else {
                this.aos.set((this.left + (this.mItemWidth / 2)) - (this.aoy / 2), i3, this.left + (this.mItemWidth / 2) + (this.aoy / 2), this.mHeight);
            }
        } else if (this.aoy != 0) {
            this.aos.set((this.left + (this.mItemWidth / 2)) - (this.aoy / 2), i3, this.left + (this.mItemWidth / 2) + (this.aoy / 2), this.mHeight);
        } else {
            this.aos.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aop = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aop != 0) {
            am.j(this, this.aop);
        }
        this.aoz = am.getColor(d.C0142d.cp_cont_b);
        this.mDividerColor = am.getColor(d.C0142d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dD(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aoF) {
            canvas.drawRect(this.aot, this.mPaint);
        }
        if (this.aoB) {
            canvas.drawRect(this.aou, this.mPaint);
        }
        if (this.aoA) {
            this.mPaint.setColor(this.aoz);
            canvas.drawRoundRect(new RectF(this.aos), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aoF = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aoA = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aoB = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aoq = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aor = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aoG;

        private b(int i) {
            this.aoG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aoq.onTabSelectionChanged(this.aoG, true);
        }
    }

    public void aI(boolean z) {
        this.aoC = z;
    }

    public void setDviderRectWidth(int i) {
        this.aoy = i;
    }

    public void setDviderRectHeight(int i) {
        this.aox = i;
    }

    public void setDiverColor(int i) {
        this.aoz = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aoE = z;
    }
}

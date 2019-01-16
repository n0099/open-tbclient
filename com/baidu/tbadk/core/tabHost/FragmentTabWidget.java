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
    private int aAd;
    private a aAe;
    private c aAf;
    private final Rect aAg;
    private final Rect aAh;
    private final Rect aAi;
    private int aAj;
    private int aAk;
    private int aAl;
    private int aAm;
    private int aAn;
    private int aAo;
    private boolean aAp;
    private boolean aAq;
    private boolean aAr;
    private int aAs;
    private boolean aAt;
    private boolean aAu;
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
        this.aAg = new Rect();
        this.aAh = new Rect();
        this.aAi = new Rect();
        this.mPaint = new Paint();
        this.aAm = 0;
        this.aAp = true;
        this.aAq = false;
        this.aAr = false;
        this.aAt = false;
        this.aAu = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.aAg = new Rect();
        this.aAh = new Rect();
        this.aAi = new Rect();
        this.mPaint = new Paint();
        this.aAm = 0;
        this.aAp = true;
        this.aAq = false;
        this.aAr = false;
        this.aAt = false;
        this.aAu = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aAj = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.aAk = l.dip2px(getContext(), 1.0f);
        this.aAl = l.dip2px(getContext(), 2.0f);
        this.aAs = getResources().getDimensionPixelSize(e.C0210e.ds10);
        setWillNotDraw(false);
        this.aAd = e.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.cF(i == i2);
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
        if (this.aAf != null) {
            this.aAf.onSizeChanged(i, i2, i3, i4);
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
        if (this.aAt) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aAr) {
            view.setPadding(0, 0, 0, this.aAs);
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
            this.aAo = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.aAj;
            this.aAh.set(0, i5, this.mWidth, this.aAj + i5);
            this.aAi.set(0, 0, this.mWidth, this.aAk);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
        int i2 = (this.aAo - dimensionPixelSize) / 2;
        this.left = this.aAo * i;
        this.left += (int) (this.aAo * f);
        int i3 = this.mHeight - this.aAl;
        if (this.aAm == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.aAg.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aAg.set((this.left + (this.aAo / 2)) - (this.aAm / 2), i3, this.left + (this.aAo / 2) + (this.aAm / 2), this.mHeight);
                }
            } else {
                this.aAg.set((this.left + (this.aAo / 2)) - (this.aAm / 2), i3, this.left + (this.aAo / 2) + (this.aAm / 2), this.mHeight);
            }
        } else if (this.aAm != 0) {
            this.aAg.set((this.left + (this.aAo / 2)) - (this.aAm / 2), i3, this.left + (this.aAo / 2) + (this.aAm / 2), this.mHeight);
        } else {
            this.aAg.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aAd = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aAd != 0) {
            al.j(this, this.aAd);
        }
        this.aAn = al.getColor(e.d.cp_cont_b);
        this.mDividerColor = al.getColor(e.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).eD(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aAu) {
            canvas.drawRect(this.aAh, this.mPaint);
        }
        if (this.aAq) {
            canvas.drawRect(this.aAi, this.mPaint);
        }
        if (this.aAp) {
            this.mPaint.setColor(this.aAn);
            canvas.drawRoundRect(new RectF(this.aAg), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aAu = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aAp = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aAq = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aAe = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aAf = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aAv;

        private b(int i) {
            this.aAv = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aAe.onTabSelectionChanged(this.aAv, true);
        }
    }

    public void bs(boolean z) {
        this.aAr = z;
    }

    public void setDviderRectWidth(int i) {
        this.aAm = i;
    }

    public void setDviderRectHeight(int i) {
        this.aAl = i;
    }

    public void setDiverColor(int i) {
        this.aAn = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aAt = z;
    }
}

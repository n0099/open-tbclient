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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int bQS;
    private a bQT;
    private c bQU;
    private final Rect bQV;
    private final Rect bQW;
    private final Rect bQX;
    private int bQY;
    private int bQZ;
    private int bRa;
    private int bRb;
    private int bRc;
    private int bRd;
    private boolean bRe;
    private boolean bRf;
    private boolean bRg;
    private int bRh;
    private boolean bRi;
    private boolean bRj;
    private View bRk;
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
        this.bQV = new Rect();
        this.bQW = new Rect();
        this.bQX = new Rect();
        this.mPaint = new Paint();
        this.bRb = 0;
        this.bRe = true;
        this.bRf = false;
        this.bRg = false;
        this.bRi = false;
        this.bRj = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bQV = new Rect();
        this.bQW = new Rect();
        this.bQX = new Rect();
        this.mPaint = new Paint();
        this.bRb = 0;
        this.bRe = true;
        this.bRf = false;
        this.bRg = false;
        this.bRi = false;
        this.bRj = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bQY = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.bQZ = l.dip2px(getContext(), 1.0f);
        this.bRa = l.dip2px(getContext(), 2.0f);
        this.bRh = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.bQS = R.color.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.ft(i == i2);
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
        if (this.bQU != null) {
            this.bQU.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        aJ(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        aJ(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public void addView(View view, int i, boolean z) {
        e(view, z);
        super.addView(view, i);
        if (z) {
            this.bRk = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bRk;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int g = !z ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73) : 0;
        if (this.bRi) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, g, 0, 0);
        if (this.bRg) {
            view.setPadding(0, 0, 0, this.bRh);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aJ(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bRi) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bRg) {
            view.setPadding(0, 0, 0, this.bRh);
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
            this.bRd = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bQY;
            this.bQW.set(0, i5, this.mWidth, this.bQY + i5);
            this.bQX.set(0, 0, this.mWidth, this.bQZ);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.bRd - dimensionPixelSize) / 2;
        this.left = this.bRd * i;
        this.left += (int) (this.bRd * f);
        int i3 = this.mHeight - this.bRa;
        if (this.bRb == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bQV.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bQV.set((this.left + (this.bRd / 2)) - (this.bRb / 2), i3, this.left + (this.bRd / 2) + (this.bRb / 2), this.mHeight);
                }
            } else {
                this.bQV.set((this.left + (this.bRd / 2)) - (this.bRb / 2), i3, this.left + (this.bRd / 2) + (this.bRb / 2), this.mHeight);
            }
        } else if (this.bRb != 0) {
            this.bQV.set((this.left + (this.bRd / 2)) - (this.bRb / 2), i3, this.left + (this.bRd / 2) + (this.bRb / 2), this.mHeight);
        } else {
            this.bQV.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bQS = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bQS != 0) {
            am.l(this, this.bQS);
        }
        this.bRc = am.getColor(R.color.cp_cont_b);
        this.mDividerColor = am.getColor(R.color.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).jd(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bRj) {
            canvas.drawRect(this.bQW, this.mPaint);
        }
        if (this.bRf) {
            canvas.drawRect(this.bQX, this.mPaint);
        }
        if (this.bRe) {
            this.mPaint.setColor(this.bRc);
            canvas.drawRoundRect(new RectF(this.bQV), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bRj = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bRe = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bRf = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bQT = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bQU = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bRl;

        private b(int i) {
            this.bRl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bQT.onTabSelectionChanged(this.bRl, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bRb = i;
    }

    public void setDviderRectHeight(int i) {
        this.bRa = i;
    }

    public void setDiverColor(int i) {
        this.bRc = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bRi = z;
    }
}

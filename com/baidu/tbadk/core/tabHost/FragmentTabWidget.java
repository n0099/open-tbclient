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
    private int bRA;
    private int bRB;
    private int bRC;
    private int bRD;
    private int bRE;
    private boolean bRF;
    private boolean bRG;
    private boolean bRH;
    private int bRI;
    private boolean bRJ;
    private boolean bRK;
    private View bRL;
    private int bRt;
    private a bRu;
    private c bRv;
    private final Rect bRw;
    private final Rect bRx;
    private final Rect bRy;
    private int bRz;
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
        this.bRw = new Rect();
        this.bRx = new Rect();
        this.bRy = new Rect();
        this.mPaint = new Paint();
        this.bRC = 0;
        this.bRF = true;
        this.bRG = false;
        this.bRH = false;
        this.bRJ = false;
        this.bRK = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bRw = new Rect();
        this.bRx = new Rect();
        this.bRy = new Rect();
        this.mPaint = new Paint();
        this.bRC = 0;
        this.bRF = true;
        this.bRG = false;
        this.bRH = false;
        this.bRJ = false;
        this.bRK = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bRz = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.bRA = l.dip2px(getContext(), 1.0f);
        this.bRB = l.dip2px(getContext(), 2.0f);
        this.bRI = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.bRt = R.color.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.fw(i == i2);
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
        if (this.bRv != null) {
            this.bRv.onSizeChanged(i, i2, i3, i4);
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
            this.bRL = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bRL;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int g = !z ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73) : 0;
        if (this.bRJ) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, g, 0, 0);
        if (this.bRH) {
            view.setPadding(0, 0, 0, this.bRI);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aJ(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bRJ) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bRH) {
            view.setPadding(0, 0, 0, this.bRI);
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
            this.bRE = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bRz;
            this.bRx.set(0, i5, this.mWidth, this.bRz + i5);
            this.bRy.set(0, 0, this.mWidth, this.bRA);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.bRE - dimensionPixelSize) / 2;
        this.left = this.bRE * i;
        this.left += (int) (this.bRE * f);
        int i3 = this.mHeight - this.bRB;
        if (this.bRC == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bRw.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bRw.set((this.left + (this.bRE / 2)) - (this.bRC / 2), i3, this.left + (this.bRE / 2) + (this.bRC / 2), this.mHeight);
                }
            } else {
                this.bRw.set((this.left + (this.bRE / 2)) - (this.bRC / 2), i3, this.left + (this.bRE / 2) + (this.bRC / 2), this.mHeight);
            }
        } else if (this.bRC != 0) {
            this.bRw.set((this.left + (this.bRE / 2)) - (this.bRC / 2), i3, this.left + (this.bRE / 2) + (this.bRC / 2), this.mHeight);
        } else {
            this.bRw.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bRt = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bRt != 0) {
            am.l(this, this.bRt);
        }
        this.bRD = am.getColor(R.color.cp_cont_b);
        this.mDividerColor = am.getColor(R.color.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).jg(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bRK) {
            canvas.drawRect(this.bRx, this.mPaint);
        }
        if (this.bRG) {
            canvas.drawRect(this.bRy, this.mPaint);
        }
        if (this.bRF) {
            this.mPaint.setColor(this.bRD);
            canvas.drawRoundRect(new RectF(this.bRw), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bRK = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bRF = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bRG = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bRu = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bRv = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bRM;

        private b(int i) {
            this.bRM = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bRu.onTabSelectionChanged(this.bRM, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bRC = i;
    }

    public void setDviderRectHeight(int i) {
        this.bRB = i;
    }

    public void setDiverColor(int i) {
        this.bRD = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bRJ = z;
    }
}

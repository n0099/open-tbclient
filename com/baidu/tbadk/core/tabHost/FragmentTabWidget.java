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
    private int cYs;
    private a cYt;
    private c cYu;
    private boolean cYv;
    private View cYw;
    private boolean isAbsoluteDivide;
    private int left;
    private int mBackgroundColorResId;
    private int mBottomDividerHeight;
    private final Rect mButtomRectDviderRect;
    private int mChildCount;
    private int mCursorColor;
    private int mCursorHeight;
    private final Rect mCursorRect;
    private int mCursorWidth;
    private int mDividerColor;
    private int mHeight;
    private int mItemWidth;
    private Paint mPaint;
    private int mSelectedTabIndex;
    private int mTopDividerHeight;
    private final Rect mTopDviderRect;
    private int mWidth;
    private boolean shouldDrawIndicatorLine;
    private boolean shouldDrawTopLine;
    private boolean tabItemNeedPadding;
    private int tabItemPaddingBottom;

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
        this.mCursorRect = new Rect();
        this.mButtomRectDviderRect = new Rect();
        this.mTopDviderRect = new Rect();
        this.cYs = 0;
        this.mSelectedTabIndex = -1;
        this.mPaint = new Paint();
        this.mCursorWidth = 0;
        this.shouldDrawIndicatorLine = true;
        this.shouldDrawTopLine = false;
        this.tabItemNeedPadding = false;
        this.isAbsoluteDivide = false;
        this.cYv = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCursorRect = new Rect();
        this.mButtomRectDviderRect = new Rect();
        this.mTopDviderRect = new Rect();
        this.cYs = 0;
        this.mSelectedTabIndex = -1;
        this.mPaint = new Paint();
        this.mCursorWidth = 0;
        this.shouldDrawIndicatorLine = true;
        this.shouldDrawTopLine = false;
        this.tabItemNeedPadding = false;
        this.isAbsoluteDivide = false;
        this.cYv = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mBottomDividerHeight = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mTopDividerHeight = l.dip2px(getContext(), 1.0f);
        this.mCursorHeight = l.dip2px(getContext(), 2.0f);
        this.tabItemPaddingBottom = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.mBackgroundColorResId = R.color.common_color_10274;
        setLayerType(1, null);
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.onTabSelected(i == i2);
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
                    changeLeft(this.mSelectedTabIndex, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.cYu != null) {
            this.cYu.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        fixChild(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        fixChild(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public void addView(View view, int i, boolean z) {
        c(view, z);
        super.addView(view, i);
        if (z) {
            this.cYw = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.cYw;
    }

    public void c(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73);
        if (this.isAbsoluteDivide) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, dimens, 0, 0);
        if (this.tabItemNeedPadding) {
            view.setPadding(0, 0, 0, this.tabItemPaddingBottom);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void fixChild(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.isAbsoluteDivide) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.tabItemNeedPadding) {
            view.setPadding(0, 0, 0, this.tabItemPaddingBottom);
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
                changeLeft(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.mBottomDividerHeight;
            this.mButtomRectDviderRect.set(0, i5, this.mWidth, this.mBottomDividerHeight + i5);
            this.mTopDviderRect.set(0, 0, this.mWidth, this.mTopDividerHeight);
        }
    }

    public void changeLeft(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.mItemWidth - dimensionPixelSize) / 2;
        this.left = this.mItemWidth * i;
        this.left += (int) (this.mItemWidth * f);
        int i3 = this.mHeight - this.mCursorHeight;
        if (this.mCursorWidth == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.mCursorRect.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.mCursorRect.set((this.left + (this.mItemWidth / 2)) - (this.mCursorWidth / 2), i3, this.left + (this.mItemWidth / 2) + (this.mCursorWidth / 2), this.mHeight);
                }
            } else {
                this.mCursorRect.set((this.left + (this.mItemWidth / 2)) - (this.mCursorWidth / 2), i3, this.left + (this.mItemWidth / 2) + (this.mCursorWidth / 2), this.mHeight);
            }
        } else if (this.mCursorWidth != 0) {
            this.mCursorRect.set((this.left + (this.mItemWidth / 2)) - (this.mCursorWidth / 2), i3, this.left + (this.mItemWidth / 2) + (this.mCursorWidth / 2), this.mHeight);
        } else {
            this.mCursorRect.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.mBackgroundColorResId = i;
    }

    public void onChangeSkinType(int i) {
        if (this.mBackgroundColorResId != 0 && this.cYs == 0) {
            am.setBackgroundColor(this, this.mBackgroundColorResId);
        }
        this.mCursorColor = am.getColor(R.color.cp_cont_b);
        this.mDividerColor = am.getColor(R.color.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).onChangeSkin(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.cYv) {
            canvas.drawRect(this.mButtomRectDviderRect, this.mPaint);
        }
        if (this.shouldDrawTopLine) {
            canvas.drawRect(this.mTopDviderRect, this.mPaint);
        }
        if (this.shouldDrawIndicatorLine) {
            this.mPaint.setColor(this.mCursorColor);
            canvas.drawRoundRect(new RectF(this.mCursorRect), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.cYv = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.shouldDrawIndicatorLine = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.shouldDrawTopLine = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.cYt = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.cYu = cVar;
    }

    public void setDviderRectWidth(int i) {
        this.mCursorWidth = i;
    }

    public void setDviderRectHeight(int i) {
        this.mCursorHeight = i;
    }

    public void setDiverColor(int i) {
        this.mCursorColor = i;
    }

    public void setBackGroundStyle(int i) {
        this.cYs = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.isAbsoluteDivide = z;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.cYt.onTabSelectionChanged(this.mTabIndex, true);
        }
    }
}

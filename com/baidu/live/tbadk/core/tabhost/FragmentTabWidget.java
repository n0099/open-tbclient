package com.baidu.live.tbadk.core.tabhost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.maintab.FragmentTabIndicator;
import com.baidu.live.tbadk.maintab.TbFragmentTabIndicator;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class FragmentTabWidget extends LinearLayout {
    private static final int DEFAULT_PAINT_FLAGS = 6;
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
    private OnSizeChanged mOnSizeChangedListener;
    private Paint mPaint;
    private int mSelectedTabIndex;
    private OnTabSelectionChanged mSelectionChangedListener;
    private int mTopDividerHeight;
    private final Rect mTopDviderRect;
    private int mWidth;
    private boolean shouldDrawIndicatorLine;
    private boolean shouldDrawTopLine;
    private boolean tabItemNeedPadding;
    private int tabItemPaddingBottom;

    /* loaded from: classes3.dex */
    public interface OnSizeChanged {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public interface OnTabSelectionChanged {
        void onTabSelectionChanged(int i, boolean z);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.mSelectedTabIndex = -1;
        this.mCursorRect = new Rect();
        this.mButtomRectDviderRect = new Rect();
        this.mTopDviderRect = new Rect();
        this.mPaint = new Paint();
        this.mCursorWidth = 0;
        this.shouldDrawIndicatorLine = true;
        this.shouldDrawTopLine = false;
        this.tabItemNeedPadding = false;
        this.isAbsoluteDivide = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.mCursorRect = new Rect();
        this.mButtomRectDviderRect = new Rect();
        this.mTopDviderRect = new Rect();
        this.mPaint = new Paint();
        this.mCursorWidth = 0;
        this.shouldDrawIndicatorLine = true;
        this.shouldDrawTopLine = false;
        this.tabItemNeedPadding = false;
        this.isAbsoluteDivide = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mBottomDividerHeight = getResources().getDimensionPixelSize(a.e.sdk_ds1);
        this.mTopDividerHeight = BdUtilHelper.dip2px(getContext(), 1.0f);
        this.mCursorHeight = BdUtilHelper.dip2px(getContext(), 2.0f);
        this.tabItemPaddingBottom = getResources().getDimensionPixelSize(a.e.sdk_ds10);
        setWillNotDraw(false);
        this.mBackgroundColorResId = a.d.sdk_common_color_10274;
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
        if (this.mOnSizeChangedListener != null) {
            this.mOnSizeChangedListener.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        fixChild(view);
        super.addView(view);
        view.setOnClickListener(new TabClickListener(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        fixChild(view);
        super.addView(view, i);
        view.setOnClickListener(new TabClickListener(getChildCount() - 1));
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
        int width;
        int width2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_ds64);
        int i2 = (this.mItemWidth - dimensionPixelSize) / 2;
        this.left = this.mItemWidth * i;
        this.left += (int) (this.mItemWidth * f);
        int i3 = this.mHeight - this.mCursorHeight;
        if (this.mCursorWidth == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    int nextContentLeft = getNextContentLeft(i, f);
                    if (nextContentLeft > -1) {
                        this.left = (int) (((childAt.getLeft() + contentTv.getLeft()) * (1.0f - f)) + (nextContentLeft * f));
                        width = (int) (((getNextContentWidth(i, f) - width2) * f) + contentTv.getWidth() + this.left);
                    } else {
                        this.left = childAt.getLeft() + contentTv.getLeft();
                        width = contentTv.getWidth() + this.left;
                    }
                    this.mCursorRect.set(this.left, i3, width, this.mHeight);
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

    private int getNextContentLeft(int i, float f) {
        View childAt;
        View contentTv;
        if (f <= 0.0f || i >= getChildCount() - 1 || (childAt = getChildAt(i + 1)) == null || !(childAt instanceof TbFragmentTabIndicator) || (contentTv = ((TbFragmentTabIndicator) childAt).getContentTv()) == null) {
            return -1;
        }
        return contentTv.getLeft() + childAt.getLeft();
    }

    private int getNextContentWidth(int i, float f) {
        View childAt;
        View contentTv;
        if (f <= 0.0f || i >= getChildCount() - 1 || (childAt = getChildAt(i + 1)) == null || !(childAt instanceof TbFragmentTabIndicator) || (contentTv = ((TbFragmentTabIndicator) childAt).getContentTv()) == null) {
            return -1;
        }
        return contentTv.getWidth();
    }

    public void setBackGroundDrawableResId(int i) {
        this.mBackgroundColorResId = i;
    }

    public void onChangeSkinType(int i) {
        if (this.mBackgroundColorResId != 0) {
            SkinManager.setBackgroundColor(this, this.mBackgroundColorResId);
        }
        this.mCursorColor = SkinManager.getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = SkinManager.getColor(a.d.sdk_cp_bg_line_c);
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
        canvas.drawRect(this.mButtomRectDviderRect, this.mPaint);
        if (this.shouldDrawTopLine) {
            canvas.drawRect(this.mTopDviderRect, this.mPaint);
        }
        if (this.shouldDrawIndicatorLine) {
            this.mPaint.setColor(this.mCursorColor);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.mPaint.setShader(new LinearGradient(this.mCursorRect.left, this.mCursorRect.top, this.mCursorRect.right, this.mCursorRect.bottom, TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_start), TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_hk_gradient_color_end), Shader.TileMode.CLAMP));
                canvas.drawRect(new RectF(this.mCursorRect), this.mPaint);
                return;
            }
            this.mPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_qm_main_color));
            canvas.drawRect(new RectF(this.mCursorRect), this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.shouldDrawIndicatorLine = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.shouldDrawTopLine = z;
    }

    public void setTabSelectionListener(OnTabSelectionChanged onTabSelectionChanged) {
        this.mSelectionChangedListener = onTabSelectionChanged;
    }

    public void setOnSizeChangedListener(OnSizeChanged onSizeChanged) {
        this.mOnSizeChangedListener = onSizeChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TabClickListener implements View.OnClickListener {
        private final int mTabIndex;

        private TabClickListener(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.mSelectionChangedListener.onTabSelectionChanged(this.mTabIndex, true);
        }
    }

    public void isTabItemNeedPadding(boolean z) {
        this.tabItemNeedPadding = z;
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

    public void setAbsoluteWeight(boolean z) {
        this.isAbsoluteDivide = z;
    }
}

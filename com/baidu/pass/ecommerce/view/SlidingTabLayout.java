package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener;
import com.baidu.sapi2.ecommerce.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    public static final int STYLE_BLOCK = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_TRIANGLE = 1;
    public static final int TEXT_BOLD_BOTH = 2;
    public static final int TEXT_BOLD_NONE = 0;
    public static final int TEXT_BOLD_WHEN_SELECT = 1;
    public Context mContext;
    public float mCurrentPositionOffset;
    public int mCurrentTab;
    public int mDividerColor;
    public float mDividerPadding;
    public Paint mDividerPaint;
    public float mDividerWidth;
    public int mHeight;
    public int mIndicatorColor;
    public float mIndicatorCornerRadius;
    public GradientDrawable mIndicatorDrawable;
    public int mIndicatorGravity;
    public float mIndicatorHeight;
    public float mIndicatorMarginBottom;
    public float mIndicatorMarginLeft;
    public float mIndicatorMarginRight;
    public float mIndicatorMarginTop;
    public Rect mIndicatorRect;
    public int mIndicatorStyle;
    public float mIndicatorWidth;
    public boolean mIndicatorWidthEqualTitle;
    public int mLastScrollX;
    public OnTabSelectListener mListener;
    public Paint mRectPaint;
    public int mTabCount;
    public float mTabPadding;
    public Rect mTabRect;
    public boolean mTabSpaceEqual;
    public float mTabWidth;
    public LinearLayout mTabsContainer;
    public boolean mTextAllCaps;
    public int mTextBold;
    public Paint mTextPaint;
    public int mTextSelectColor;
    public int mTextUnselectColor;
    public float mTextsize;
    public List<String> mTitles;
    public Paint mTrianglePaint;
    public Path mTrianglePath;
    public int mUnderlineColor;
    public int mUnderlineGravity;
    public float mUnderlineHeight;
    public ViewPager mViewPager;
    public float margin;

    /* loaded from: classes2.dex */
    public class InnerPagerAdapter extends FragmentPagerAdapter {
        public ArrayList<Fragment> fragments;
        public String[] titles;

        public InnerPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            this.fragments = new ArrayList<>();
            this.fragments = arrayList;
            this.titles = strArr;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.fragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return this.fragments.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return this.titles[i2];
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    private void addTab(int i2, String str, View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.view.SlidingTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int indexOfChild = SlidingTabLayout.this.mTabsContainer.indexOfChild(view2);
                if (indexOfChild != -1) {
                    if (SlidingTabLayout.this.mViewPager.getCurrentItem() != indexOfChild) {
                        if (SlidingTabLayout.this.mListener != null) {
                            SlidingTabLayout.this.mListener.onTabSelect(indexOfChild);
                        }
                    } else if (SlidingTabLayout.this.mListener != null) {
                        SlidingTabLayout.this.mListener.onTabReselect(indexOfChild);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.mTabSpaceEqual ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        float f2 = this.mTabWidth;
        if (f2 > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) f2, -1);
        }
        this.mTabsContainer.addView(view, i2, layoutParams);
    }

    private void calcIndicatorRect() {
        int i2;
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            this.mTextPaint.setTextSize(this.mTextsize);
            this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
        }
        int i3 = this.mCurrentTab;
        if (i3 < this.mTabCount - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(i3 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f2 = this.mCurrentPositionOffset;
            left += (left2 - left) * f2;
            right += f2 * (right2 - right);
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                float f3 = this.margin;
                this.margin = f3 + (this.mCurrentPositionOffset * ((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - f3));
            }
        }
        Rect rect = this.mIndicatorRect;
        int i4 = (int) left;
        rect.left = i4;
        int i5 = (int) right;
        rect.right = i5;
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            float f4 = this.margin;
            rect.left = (int) ((left + f4) - 1.0f);
            rect.right = (int) ((right - f4) - 1.0f);
        }
        Rect rect2 = this.mTabRect;
        rect2.left = i4;
        rect2.right = i5;
        if (this.mIndicatorWidth >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.mIndicatorWidth) / 2.0f);
            if (this.mCurrentTab < this.mTabCount - 1) {
                left3 += this.mCurrentPositionOffset * ((childAt.getWidth() / 2) + (this.mTabsContainer.getChildAt(i2 + 1).getWidth() / 2));
            }
            Rect rect3 = this.mIndicatorRect;
            int i6 = (int) left3;
            rect3.left = i6;
            rect3.right = (int) (i6 + this.mIndicatorWidth);
        }
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        float f2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SapiSdkSlidingTabLayout);
        int i2 = obtainStyledAttributes.getInt(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorStyle, 0);
        this.mIndicatorStyle = i2;
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorColor, Color.parseColor(i2 == 2 ? "#4B6A87" : "#ffffff"));
        int i3 = R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorHeight;
        int i4 = this.mIndicatorStyle;
        if (i4 == 1) {
            f2 = 4.0f;
        } else {
            f2 = i4 == 2 ? -1 : 2;
        }
        this.mIndicatorHeight = obtainStyledAttributes.getDimension(i3, dp2px(f2));
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorWidth, dp2px(this.mIndicatorStyle == 1 ? 10.0f : -1.0f));
        this.mIndicatorCornerRadius = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorCornerRadius, dp2px(this.mIndicatorStyle == 2 ? -1.0f : 0.0f));
        this.mIndicatorMarginLeft = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorMarginLeft, dp2px(0.0f));
        this.mIndicatorMarginTop = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorMarginTop, dp2px(this.mIndicatorStyle == 2 ? 7.0f : 0.0f));
        this.mIndicatorMarginRight = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorMarginRight, dp2px(0.0f));
        this.mIndicatorMarginBottom = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorMarginBottom, dp2px(this.mIndicatorStyle != 2 ? 0.0f : 7.0f));
        this.mIndicatorGravity = obtainStyledAttributes.getInt(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorGravity, 80);
        this.mIndicatorWidthEqualTitle = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkSlidingTabLayout_SapiSdkIndicatorWidthEqualTitle, false);
        this.mUnderlineColor = obtainStyledAttributes.getColor(R.styleable.SapiSdkSlidingTabLayout_SapiSdkUnderlineColor, Color.parseColor("#ffffff"));
        this.mUnderlineHeight = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkUnderlineHeight, dp2px(0.0f));
        this.mUnderlineGravity = obtainStyledAttributes.getInt(R.styleable.SapiSdkSlidingTabLayout_SapiSdkUnderlineGravity, 80);
        this.mDividerColor = obtainStyledAttributes.getColor(R.styleable.SapiSdkSlidingTabLayout_SapiSdkDividerColor, Color.parseColor("#ffffff"));
        this.mDividerWidth = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkDividerWidth, dp2px(0.0f));
        this.mDividerPadding = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkDividerPadding, dp2px(12.0f));
        this.mTextsize = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabTextSize, sp2px(14.0f));
        this.mTextSelectColor = obtainStyledAttributes.getColor(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabTextSelectColor, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = obtainStyledAttributes.getColor(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabTextUnselectColor, Color.parseColor("#AAffffff"));
        this.mTextBold = obtainStyledAttributes.getInt(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabTextBold, 0);
        this.mTextAllCaps = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabTextAllCaps, false);
        this.mTabSpaceEqual = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabSpaceEqual, false);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabWidth, dp2px(-1.0f));
        this.mTabWidth = dimension;
        this.mTabPadding = obtainStyledAttributes.getDimension(R.styleable.SapiSdkSlidingTabLayout_SapiSdkTabPadding, (this.mTabSpaceEqual || dimension > 0.0f) ? dp2px(0.0f) : dp2px(20.0f));
        obtainStyledAttributes.recycle();
    }

    private void scrollToCurrentTab() {
        if (this.mTabCount <= 0) {
            return;
        }
        int width = (int) (this.mCurrentPositionOffset * this.mTabsContainer.getChildAt(this.mCurrentTab).getWidth());
        int left = this.mTabsContainer.getChildAt(this.mCurrentTab).getLeft() + width;
        if (this.mCurrentTab > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            calcIndicatorRect();
            Rect rect = this.mTabRect;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.mLastScrollX) {
            this.mLastScrollX = left;
            scrollTo(left, 0);
        }
    }

    private void updateTabSelection(int i2) {
        int i3 = 0;
        while (i3 < this.mTabCount) {
            View childAt = this.mTabsContainer.getChildAt(i3);
            boolean z = i3 == i2;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(z ? this.mTextSelectColor : this.mTextUnselectColor);
                if (this.mTextBold == 1) {
                    textView.getPaint().setFakeBoldText(z);
                }
            }
            i3++;
        }
    }

    private void updateTabStyles() {
        int i2 = 0;
        while (i2 < this.mTabCount) {
            TextView textView = (TextView) this.mTabsContainer.getChildAt(i2).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(i2 == this.mCurrentTab ? this.mTextSelectColor : this.mTextUnselectColor);
                textView.setTextSize(0, this.mTextsize);
                int i3 = (int) this.mTabPadding;
                textView.setPadding(i3, 0, i3, 0);
                if (this.mTextAllCaps) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i4 = this.mTextBold;
                if (i4 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i4 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
            i2++;
        }
    }

    public void addNewTab(String str) {
        View inflate = View.inflate(this.mContext, R.layout.layout_sapi_sdk_dialog_address_selector_tab, null);
        List<String> list = this.mTitles;
        if (list != null) {
            list.add(str);
        }
        List<String> list2 = this.mTitles;
        addTab(this.mTabCount, (list2 == null ? this.mViewPager.getAdapter().getPageTitle(this.mTabCount) : list2.get(this.mTabCount)).toString(), inflate);
        List<String> list3 = this.mTitles;
        this.mTabCount = list3 == null ? this.mViewPager.getAdapter().getCount() : list3.size();
        updateTabStyles();
    }

    public int dp2px(float f2) {
        return (int) ((f2 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public int getDividerColor() {
        return this.mDividerColor;
    }

    public float getDividerPadding() {
        return this.mDividerPadding;
    }

    public float getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public float getIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public float getIndicatorMarginBottom() {
        return this.mIndicatorMarginBottom;
    }

    public float getIndicatorMarginLeft() {
        return this.mIndicatorMarginLeft;
    }

    public float getIndicatorMarginRight() {
        return this.mIndicatorMarginRight;
    }

    public float getIndicatorMarginTop() {
        return this.mIndicatorMarginTop;
    }

    public int getIndicatorStyle() {
        return this.mIndicatorStyle;
    }

    public float getIndicatorWidth() {
        return this.mIndicatorWidth;
    }

    public int getTabCount() {
        return this.mTabCount;
    }

    public float getTabPadding() {
        return this.mTabPadding;
    }

    public float getTabWidth() {
        return this.mTabWidth;
    }

    public int getTextBold() {
        return this.mTextBold;
    }

    public int getTextSelectColor() {
        return this.mTextSelectColor;
    }

    public int getTextUnselectColor() {
        return this.mTextUnselectColor;
    }

    public float getTextsize() {
        return this.mTextsize;
    }

    public TextView getTitleView(int i2) {
        return (TextView) this.mTabsContainer.getChildAt(i2).findViewById(R.id.tv_tab_title);
    }

    public List<String> getTitles() {
        return this.mTitles;
    }

    public int getUnderlineColor() {
        return this.mUnderlineColor;
    }

    public float getUnderlineHeight() {
        return this.mUnderlineHeight;
    }

    public boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public void notifyDataSetChanged() {
        this.mTabsContainer.removeAllViews();
        List<String> list = this.mTitles;
        this.mTabCount = list == null ? this.mViewPager.getAdapter().getCount() : list.size();
        for (int i2 = 0; i2 < this.mTabCount; i2++) {
            View inflate = View.inflate(this.mContext, R.layout.layout_sapi_sdk_dialog_address_selector_tab, null);
            List<String> list2 = this.mTitles;
            addTab(i2, (list2 == null ? this.mViewPager.getAdapter().getPageTitle(i2) : list2.get(i2)).toString(), inflate);
        }
        updateTabStyles();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount <= 0) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        float f2 = this.mDividerWidth;
        if (f2 > 0.0f) {
            this.mDividerPaint.setStrokeWidth(f2);
            this.mDividerPaint.setColor(this.mDividerColor);
            for (int i2 = 0; i2 < this.mTabCount - 1; i2++) {
                View childAt = this.mTabsContainer.getChildAt(i2);
                canvas.drawLine(childAt.getRight() + paddingLeft, this.mDividerPadding, childAt.getRight() + paddingLeft, height - this.mDividerPadding, this.mDividerPaint);
            }
        }
        if (this.mUnderlineHeight > 0.0f) {
            this.mRectPaint.setColor(this.mUnderlineColor);
            if (this.mUnderlineGravity == 80) {
                float f3 = height;
                canvas.drawRect(paddingLeft, f3 - this.mUnderlineHeight, this.mTabsContainer.getWidth() + paddingLeft, f3, this.mRectPaint);
            } else {
                canvas.drawRect(paddingLeft, 0.0f, this.mTabsContainer.getWidth() + paddingLeft, this.mUnderlineHeight, this.mRectPaint);
            }
        }
        calcIndicatorRect();
        int i3 = this.mIndicatorStyle;
        if (i3 == 1) {
            if (this.mIndicatorHeight > 0.0f) {
                this.mTrianglePaint.setColor(this.mIndicatorColor);
                this.mTrianglePath.reset();
                float f4 = height;
                this.mTrianglePath.moveTo(this.mIndicatorRect.left + paddingLeft, f4);
                Path path = this.mTrianglePath;
                Rect rect2 = this.mIndicatorRect;
                path.lineTo((rect2.left / 2) + paddingLeft + (rect2.right / 2), f4 - this.mIndicatorHeight);
                this.mTrianglePath.lineTo(paddingLeft + this.mIndicatorRect.right, f4);
                this.mTrianglePath.close();
                canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
            }
        } else if (i3 == 2) {
            float f5 = this.mIndicatorHeight;
            if (f5 < 0.0f) {
                this.mIndicatorHeight = (height - this.mIndicatorMarginTop) - this.mIndicatorMarginBottom;
            } else if (f5 > 0.0f) {
                float f6 = this.mIndicatorCornerRadius;
                if (f6 < 0.0f || f6 > f5 / 2.0f) {
                    this.mIndicatorCornerRadius = this.mIndicatorHeight / 2.0f;
                }
                this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                GradientDrawable gradientDrawable = this.mIndicatorDrawable;
                int i4 = ((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left;
                float f7 = this.mIndicatorMarginTop;
                gradientDrawable.setBounds(i4, (int) f7, (int) ((paddingLeft + rect.right) - this.mIndicatorMarginRight), (int) (f7 + this.mIndicatorHeight));
                this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                this.mIndicatorDrawable.draw(canvas);
            }
        } else if (this.mIndicatorHeight > 0.0f) {
            this.mIndicatorDrawable.setColor(this.mIndicatorColor);
            if (this.mIndicatorGravity == 80) {
                GradientDrawable gradientDrawable2 = this.mIndicatorDrawable;
                Rect rect3 = this.mIndicatorRect;
                int i5 = (int) this.mIndicatorMarginBottom;
                gradientDrawable2.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + rect3.left, (height - ((int) this.mIndicatorHeight)) - i5, (paddingLeft + rect3.right) - ((int) this.mIndicatorMarginRight), height - i5);
            } else {
                GradientDrawable gradientDrawable3 = this.mIndicatorDrawable;
                Rect rect4 = this.mIndicatorRect;
                int i6 = ((int) this.mIndicatorMarginLeft) + paddingLeft + rect4.left;
                int i7 = (int) this.mIndicatorMarginTop;
                gradientDrawable3.setBounds(i6, i7, (paddingLeft + rect4.right) - ((int) this.mIndicatorMarginRight), ((int) this.mIndicatorHeight) + i7);
            }
            this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
            this.mIndicatorDrawable.draw(canvas);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        this.mCurrentTab = i2;
        this.mCurrentPositionOffset = f2;
        scrollToCurrentTab();
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        updateTabSelection(i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.mTabsContainer.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
                scrollToCurrentTab();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    public void setCurrentTab(int i2) {
        this.mCurrentTab = i2;
        this.mViewPager.setCurrentItem(i2);
    }

    public void setDividerColor(int i2) {
        this.mDividerColor = i2;
        invalidate();
    }

    public void setDividerPadding(float f2) {
        this.mDividerPadding = dp2px(f2);
        invalidate();
    }

    public void setDividerWidth(float f2) {
        this.mDividerWidth = dp2px(f2);
        invalidate();
    }

    public void setIndicatorColor(int i2) {
        this.mIndicatorColor = i2;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.mIndicatorCornerRadius = dp2px(f2);
        invalidate();
    }

    public void setIndicatorGravity(int i2) {
        this.mIndicatorGravity = i2;
        invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.mIndicatorHeight = dp2px(f2);
        invalidate();
    }

    public void setIndicatorMargin(float f2, float f3, float f4, float f5) {
        this.mIndicatorMarginLeft = dp2px(f2);
        this.mIndicatorMarginTop = dp2px(f3);
        this.mIndicatorMarginRight = dp2px(f4);
        this.mIndicatorMarginBottom = dp2px(f5);
        invalidate();
    }

    public void setIndicatorStyle(int i2) {
        this.mIndicatorStyle = i2;
        invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.mIndicatorWidth = dp2px(f2);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        this.mIndicatorWidthEqualTitle = z;
        invalidate();
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.mListener = onTabSelectListener;
    }

    public void setTabPadding(float f2) {
        this.mTabPadding = dp2px(f2);
        updateTabStyles();
    }

    public void setTabSpaceEqual(boolean z) {
        this.mTabSpaceEqual = z;
        updateTabStyles();
    }

    public void setTabWidth(float f2) {
        this.mTabWidth = dp2px(f2);
        updateTabStyles();
    }

    public void setTextAllCaps(boolean z) {
        this.mTextAllCaps = z;
        updateTabStyles();
    }

    public void setTextBold(int i2) {
        this.mTextBold = i2;
        updateTabStyles();
    }

    public void setTextSelectColor(int i2) {
        this.mTextSelectColor = i2;
        updateTabStyles();
    }

    public void setTextUnselectColor(int i2) {
        this.mTextUnselectColor = i2;
        updateTabStyles();
    }

    public void setTextsize(float f2) {
        this.mTextsize = sp2px(f2);
        updateTabStyles();
    }

    public void setTitles(List<String> list) {
        this.mTitles = list;
    }

    public void setUnderlineColor(int i2) {
        this.mUnderlineColor = i2;
        invalidate();
    }

    public void setUnderlineGravity(int i2) {
        this.mUnderlineGravity = i2;
        invalidate();
    }

    public void setUnderlineHeight(float f2) {
        this.mUnderlineHeight = dp2px(f2);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.removeOnPageChangeListener(this);
            this.mViewPager.addOnPageChangeListener(this);
            notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public int sp2px(float f2) {
        return (int) ((f2 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIndicatorRect = new Rect();
        this.mTabRect = new Rect();
        this.mIndicatorDrawable = new GradientDrawable();
        this.mRectPaint = new Paint(1);
        this.mDividerPaint = new Paint(1);
        this.mTrianglePaint = new Paint(1);
        this.mTrianglePath = new Path();
        this.mIndicatorStyle = 0;
        this.mTextPaint = new Paint(1);
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabsContainer = linearLayout;
        addView(linearLayout);
        obtainAttributes(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (attributeValue.equals("-1") || attributeValue.equals("-2")) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
        obtainStyledAttributes.recycle();
    }

    public void setCurrentTab(int i2, boolean z) {
        this.mCurrentTab = i2;
        this.mViewPager.setCurrentItem(i2, z);
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            if (strArr != null && strArr.length != 0) {
                if (strArr.length == viewPager.getAdapter().getCount()) {
                    this.mViewPager = viewPager;
                    ArrayList arrayList = new ArrayList();
                    this.mTitles = arrayList;
                    Collections.addAll(arrayList, strArr);
                    this.mViewPager.removeOnPageChangeListener(this);
                    this.mViewPager.addOnPageChangeListener(this);
                    notifyDataSetChanged();
                    return;
                }
                throw new IllegalStateException("Titles length must be the same as the page count !");
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        if (viewPager != null) {
            if (strArr != null && strArr.length != 0) {
                this.mViewPager = viewPager;
                viewPager.setAdapter(new InnerPagerAdapter(fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
                this.mViewPager.removeOnPageChangeListener(this);
                this.mViewPager.addOnPageChangeListener(this);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager can not be NULL !");
    }
}

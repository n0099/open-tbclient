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
import com.baidu.tieba.R;
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes2.dex */
    public class InnerPagerAdapter extends FragmentPagerAdapter {
        public ArrayList<Fragment> fragments;
        public String[] titles;

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public InnerPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            this.fragments = new ArrayList<>();
            this.fragments = arrayList;
            this.titles = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.fragments.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.fragments.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.titles[i];
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    public int dp2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public TextView getTitleView(int i) {
        return (TextView) this.mTabsContainer.getChildAt(i).findViewById(R.id.obfuscated_res_0x7f092619);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        updateTabSelection(i);
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

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        this.mViewPager.setCurrentItem(i);
    }

    public void setDividerColor(int i) {
        this.mDividerColor = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.mDividerPadding = dp2px(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.mDividerWidth = dp2px(f);
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.mIndicatorCornerRadius = dp2px(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.mIndicatorGravity = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.mIndicatorHeight = dp2px(f);
        invalidate();
    }

    public void setIndicatorStyle(int i) {
        this.mIndicatorStyle = i;
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.mIndicatorWidth = dp2px(f);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        this.mIndicatorWidthEqualTitle = z;
        invalidate();
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.mListener = onTabSelectListener;
    }

    public void setTabPadding(float f) {
        this.mTabPadding = dp2px(f);
        updateTabStyles();
    }

    public void setTabSpaceEqual(boolean z) {
        this.mTabSpaceEqual = z;
        updateTabStyles();
    }

    public void setTabWidth(float f) {
        this.mTabWidth = dp2px(f);
        updateTabStyles();
    }

    public void setTextAllCaps(boolean z) {
        this.mTextAllCaps = z;
        updateTabStyles();
    }

    public void setTextBold(int i) {
        this.mTextBold = i;
        updateTabStyles();
    }

    public void setTextSelectColor(int i) {
        this.mTextSelectColor = i;
        updateTabStyles();
    }

    public void setTextUnselectColor(int i) {
        this.mTextUnselectColor = i;
        updateTabStyles();
    }

    public void setTextsize(float f) {
        this.mTextsize = sp2px(f);
        updateTabStyles();
    }

    public void setTitles(List<String> list) {
        this.mTitles = list;
    }

    public void setUnderlineColor(int i) {
        this.mUnderlineColor = i;
        invalidate();
    }

    public void setUnderlineGravity(int i) {
        this.mUnderlineGravity = i;
        invalidate();
    }

    public void setUnderlineHeight(float f) {
        this.mUnderlineHeight = dp2px(f);
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

    public int sp2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCurrentTab(int i, boolean z) {
        this.mCurrentTab = i;
        this.mViewPager.setCurrentItem(i, z);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    private void addTab(int i, String str, View view2) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092619);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.view.SlidingTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                int indexOfChild = SlidingTabLayout.this.mTabsContainer.indexOfChild(view3);
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
        if (this.mTabSpaceEqual) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        float f = this.mTabWidth;
        if (f > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) f, -1);
        }
        this.mTabsContainer.addView(view2, i, layoutParams);
    }

    private void calcIndicatorRect() {
        int i;
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            this.mTextPaint.setTextSize(this.mTextsize);
            this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.obfuscated_res_0x7f092619)).getText().toString())) / 2.0f;
        }
        int i2 = this.mCurrentTab;
        if (i2 < this.mTabCount - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(i2 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.mCurrentPositionOffset;
            left += (left2 - left) * f;
            right += f * (right2 - right);
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                float f2 = this.margin;
                this.margin = f2 + (this.mCurrentPositionOffset * ((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.obfuscated_res_0x7f092619)).getText().toString())) / 2.0f) - f2));
            }
        }
        Rect rect = this.mIndicatorRect;
        int i3 = (int) left;
        rect.left = i3;
        int i4 = (int) right;
        rect.right = i4;
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            float f3 = this.margin;
            rect.left = (int) ((left + f3) - 1.0f);
            rect.right = (int) ((right - f3) - 1.0f);
        }
        Rect rect2 = this.mTabRect;
        rect2.left = i3;
        rect2.right = i4;
        if (this.mIndicatorWidth >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.mIndicatorWidth) / 2.0f);
            if (this.mCurrentTab < this.mTabCount - 1) {
                left3 += this.mCurrentPositionOffset * ((childAt.getWidth() / 2) + (this.mTabsContainer.getChildAt(i + 1).getWidth() / 2));
            }
            Rect rect3 = this.mIndicatorRect;
            int i5 = (int) left3;
            rect3.left = i5;
            rect3.right = (int) (i5 + this.mIndicatorWidth);
        }
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        String str;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        int dp2px;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.sapi2.ecommerce.R.styleable.SapiSdkSlidingTabLayout);
        int i2 = obtainStyledAttributes.getInt(11, 0);
        this.mIndicatorStyle = i2;
        if (i2 != 2) {
            str = "#ffffff";
        } else {
            str = "#4B6A87";
        }
        this.mIndicatorColor = obtainStyledAttributes.getColor(3, Color.parseColor(str));
        int i3 = this.mIndicatorStyle;
        if (i3 == 1) {
            f = 4.0f;
        } else {
            if (i3 == 2) {
                i = -1;
            } else {
                i = 2;
            }
            f = i;
        }
        this.mIndicatorHeight = obtainStyledAttributes.getDimension(6, dp2px(f));
        if (this.mIndicatorStyle == 1) {
            f2 = 10.0f;
        } else {
            f2 = -1.0f;
        }
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(12, dp2px(f2));
        if (this.mIndicatorStyle == 2) {
            f3 = -1.0f;
        } else {
            f3 = 0.0f;
        }
        this.mIndicatorCornerRadius = obtainStyledAttributes.getDimension(4, dp2px(f3));
        this.mIndicatorMarginLeft = obtainStyledAttributes.getDimension(8, dp2px(0.0f));
        float f5 = 7.0f;
        if (this.mIndicatorStyle == 2) {
            f4 = 7.0f;
        } else {
            f4 = 0.0f;
        }
        this.mIndicatorMarginTop = obtainStyledAttributes.getDimension(10, dp2px(f4));
        this.mIndicatorMarginRight = obtainStyledAttributes.getDimension(9, dp2px(0.0f));
        if (this.mIndicatorStyle != 2) {
            f5 = 0.0f;
        }
        this.mIndicatorMarginBottom = obtainStyledAttributes.getDimension(7, dp2px(f5));
        this.mIndicatorGravity = obtainStyledAttributes.getInt(5, 80);
        this.mIndicatorWidthEqualTitle = obtainStyledAttributes.getBoolean(13, false);
        this.mUnderlineColor = obtainStyledAttributes.getColor(22, Color.parseColor("#ffffff"));
        this.mUnderlineHeight = obtainStyledAttributes.getDimension(24, dp2px(0.0f));
        this.mUnderlineGravity = obtainStyledAttributes.getInt(23, 80);
        this.mDividerColor = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.mDividerWidth = obtainStyledAttributes.getDimension(2, dp2px(0.0f));
        this.mDividerPadding = obtainStyledAttributes.getDimension(1, dp2px(12.0f));
        this.mTextsize = obtainStyledAttributes.getDimension(19, sp2px(14.0f));
        this.mTextSelectColor = obtainStyledAttributes.getColor(18, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = obtainStyledAttributes.getColor(20, Color.parseColor("#AAffffff"));
        this.mTextBold = obtainStyledAttributes.getInt(17, 0);
        this.mTextAllCaps = obtainStyledAttributes.getBoolean(16, false);
        this.mTabSpaceEqual = obtainStyledAttributes.getBoolean(15, false);
        float dimension = obtainStyledAttributes.getDimension(21, dp2px(-1.0f));
        this.mTabWidth = dimension;
        if (!this.mTabSpaceEqual && dimension <= 0.0f) {
            dp2px = dp2px(20.0f);
        } else {
            dp2px = dp2px(0.0f);
        }
        this.mTabPadding = obtainStyledAttributes.getDimension(14, dp2px);
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

    private void updateTabStyles() {
        int i;
        for (int i2 = 0; i2 < this.mTabCount; i2++) {
            TextView textView = (TextView) this.mTabsContainer.getChildAt(i2).findViewById(R.id.obfuscated_res_0x7f092619);
            if (textView != null) {
                if (i2 == this.mCurrentTab) {
                    i = this.mTextSelectColor;
                } else {
                    i = this.mTextUnselectColor;
                }
                textView.setTextColor(i);
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
        }
    }

    public void notifyDataSetChanged() {
        int size;
        String str;
        this.mTabsContainer.removeAllViews();
        List<String> list = this.mTitles;
        if (list == null) {
            size = this.mViewPager.getAdapter().getCount();
        } else {
            size = list.size();
        }
        this.mTabCount = size;
        for (int i = 0; i < this.mTabCount; i++) {
            View inflate = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0538, null);
            List<String> list2 = this.mTitles;
            if (list2 == null) {
                str = this.mViewPager.getAdapter().getPageTitle(i);
            } else {
                str = list2.get(i);
            }
            addTab(i, str.toString(), inflate);
        }
        updateTabStyles();
    }

    private void updateTabSelection(int i) {
        boolean z;
        int i2;
        for (int i3 = 0; i3 < this.mTabCount; i3++) {
            View childAt = this.mTabsContainer.getChildAt(i3);
            if (i3 == i) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.obfuscated_res_0x7f092619);
            if (textView != null) {
                if (z) {
                    i2 = this.mTextSelectColor;
                } else {
                    i2 = this.mTextUnselectColor;
                }
                textView.setTextColor(i2);
                if (this.mTextBold == 1) {
                    textView.getPaint().setFakeBoldText(z);
                }
            }
        }
    }

    public void addNewTab(String str) {
        String str2;
        int size;
        View inflate = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0538, null);
        List<String> list = this.mTitles;
        if (list != null) {
            list.add(str);
        }
        List<String> list2 = this.mTitles;
        if (list2 == null) {
            str2 = this.mViewPager.getAdapter().getPageTitle(this.mTabCount);
        } else {
            str2 = list2.get(this.mTabCount);
        }
        addTab(this.mTabCount, str2.toString(), inflate);
        List<String> list3 = this.mTitles;
        if (list3 == null) {
            size = this.mViewPager.getAdapter().getCount();
        } else {
            size = list3.size();
        }
        this.mTabCount = size;
        updateTabStyles();
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

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f = this.mDividerWidth;
            if (f > 0.0f) {
                this.mDividerPaint.setStrokeWidth(f);
                this.mDividerPaint.setColor(this.mDividerColor);
                for (int i = 0; i < this.mTabCount - 1; i++) {
                    View childAt = this.mTabsContainer.getChildAt(i);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.mDividerPadding, childAt.getRight() + paddingLeft, height - this.mDividerPadding, this.mDividerPaint);
                }
            }
            if (this.mUnderlineHeight > 0.0f) {
                this.mRectPaint.setColor(this.mUnderlineColor);
                if (this.mUnderlineGravity == 80) {
                    float f2 = height;
                    canvas.drawRect(paddingLeft, f2 - this.mUnderlineHeight, this.mTabsContainer.getWidth() + paddingLeft, f2, this.mRectPaint);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, this.mTabsContainer.getWidth() + paddingLeft, this.mUnderlineHeight, this.mRectPaint);
                }
            }
            calcIndicatorRect();
            int i2 = this.mIndicatorStyle;
            if (i2 == 1) {
                if (this.mIndicatorHeight > 0.0f) {
                    this.mTrianglePaint.setColor(this.mIndicatorColor);
                    this.mTrianglePath.reset();
                    float f3 = height;
                    this.mTrianglePath.moveTo(this.mIndicatorRect.left + paddingLeft, f3);
                    Path path = this.mTrianglePath;
                    Rect rect2 = this.mIndicatorRect;
                    path.lineTo((rect2.left / 2) + paddingLeft + (rect2.right / 2), f3 - this.mIndicatorHeight);
                    this.mTrianglePath.lineTo(paddingLeft + this.mIndicatorRect.right, f3);
                    this.mTrianglePath.close();
                    canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
                }
            } else if (i2 == 2) {
                float f4 = this.mIndicatorHeight;
                if (f4 < 0.0f) {
                    this.mIndicatorHeight = (height - this.mIndicatorMarginTop) - this.mIndicatorMarginBottom;
                } else if (f4 > 0.0f) {
                    float f5 = this.mIndicatorCornerRadius;
                    if (f5 < 0.0f || f5 > f4 / 2.0f) {
                        this.mIndicatorCornerRadius = this.mIndicatorHeight / 2.0f;
                    }
                    this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                    GradientDrawable gradientDrawable = this.mIndicatorDrawable;
                    int i3 = ((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left;
                    float f6 = this.mIndicatorMarginTop;
                    gradientDrawable.setBounds(i3, (int) f6, (int) ((paddingLeft + rect.right) - this.mIndicatorMarginRight), (int) (f6 + this.mIndicatorHeight));
                    this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                    this.mIndicatorDrawable.draw(canvas);
                }
            } else if (this.mIndicatorHeight > 0.0f) {
                this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                if (this.mIndicatorGravity == 80) {
                    GradientDrawable gradientDrawable2 = this.mIndicatorDrawable;
                    Rect rect3 = this.mIndicatorRect;
                    int i4 = (int) this.mIndicatorMarginBottom;
                    gradientDrawable2.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + rect3.left, (height - ((int) this.mIndicatorHeight)) - i4, (paddingLeft + rect3.right) - ((int) this.mIndicatorMarginRight), height - i4);
                } else {
                    GradientDrawable gradientDrawable3 = this.mIndicatorDrawable;
                    Rect rect4 = this.mIndicatorRect;
                    int i5 = ((int) this.mIndicatorMarginLeft) + paddingLeft + rect4.left;
                    int i6 = (int) this.mIndicatorMarginTop;
                    gradientDrawable3.setBounds(i5, i6, (paddingLeft + rect4.right) - ((int) this.mIndicatorMarginRight), ((int) this.mIndicatorHeight) + i6);
                }
                this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                this.mIndicatorDrawable.draw(canvas);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.mCurrentTab = i;
        this.mCurrentPositionOffset = f;
        scrollToCurrentTab();
        invalidate();
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        this.mIndicatorMarginLeft = dp2px(f);
        this.mIndicatorMarginTop = dp2px(f2);
        this.mIndicatorMarginRight = dp2px(f3);
        this.mIndicatorMarginBottom = dp2px(f4);
        invalidate();
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

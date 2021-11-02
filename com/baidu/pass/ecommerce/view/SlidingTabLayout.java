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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STYLE_BLOCK = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_TRIANGLE = 1;
    public static final int TEXT_BOLD_BOTH = 2;
    public static final int TEXT_BOLD_NONE = 0;
    public static final int TEXT_BOLD_WHEN_SELECT = 1;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public class InnerPagerAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<Fragment> fragments;
        public final /* synthetic */ SlidingTabLayout this$0;
        public String[] titles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerPagerAdapter(SlidingTabLayout slidingTabLayout, FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout, fragmentManager, arrayList, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = slidingTabLayout;
            this.fragments = new ArrayList<>();
            this.fragments = arrayList;
            this.titles = strArr;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fragments.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.fragments.get(i2) : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.titles[i2] : (CharSequence) invokeI.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addTab(int i2, String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(AdIconUtil.BAIDU_LOGO_ID, this, i2, str, view) == null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
            if (textView != null && str != null) {
                textView.setText(str);
            }
            view.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SlidingTabLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SlidingTabLayout this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int indexOfChild;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || (indexOfChild = this.this$0.mTabsContainer.indexOfChild(view2)) == -1) {
                        return;
                    }
                    if (this.this$0.mViewPager.getCurrentItem() != indexOfChild) {
                        if (this.this$0.mListener != null) {
                            this.this$0.mListener.onTabSelect(indexOfChild);
                        }
                    } else if (this.this$0.mListener != null) {
                        this.this$0.mListener.onTabReselect(indexOfChild);
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
    }

    private void calcIndicatorRect() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
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
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, attributeSet) == null) {
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
    }

    private void scrollToCurrentTab() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.mTabCount <= 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
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
    }

    private void updateTabStyles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
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
    }

    public void addNewTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
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
    }

    public int dp2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? (int) ((f2 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentTab : invokeV.intValue;
    }

    public int getDividerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDividerColor : invokeV.intValue;
    }

    public float getDividerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDividerPadding : invokeV.floatValue;
    }

    public float getDividerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDividerWidth : invokeV.floatValue;
    }

    public int getIndicatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIndicatorColor : invokeV.intValue;
    }

    public float getIndicatorCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIndicatorCornerRadius : invokeV.floatValue;
    }

    public float getIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIndicatorHeight : invokeV.floatValue;
    }

    public float getIndicatorMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIndicatorMarginBottom : invokeV.floatValue;
    }

    public float getIndicatorMarginLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIndicatorMarginLeft : invokeV.floatValue;
    }

    public float getIndicatorMarginRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIndicatorMarginRight : invokeV.floatValue;
    }

    public float getIndicatorMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIndicatorMarginTop : invokeV.floatValue;
    }

    public int getIndicatorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIndicatorStyle : invokeV.intValue;
    }

    public float getIndicatorWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIndicatorWidth : invokeV.floatValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTabCount : invokeV.intValue;
    }

    public float getTabPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTabPadding : invokeV.floatValue;
    }

    public float getTabWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mTabWidth : invokeV.floatValue;
    }

    public int getTextBold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mTextBold : invokeV.intValue;
    }

    public int getTextSelectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mTextSelectColor : invokeV.intValue;
    }

    public int getTextUnselectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mTextUnselectColor : invokeV.intValue;
    }

    public float getTextsize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mTextsize : invokeV.floatValue;
    }

    public TextView getTitleView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? (TextView) this.mTabsContainer.getChildAt(i2).findViewById(R.id.tv_tab_title) : (TextView) invokeI.objValue;
    }

    public List<String> getTitles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTitles : (List) invokeV.objValue;
    }

    public int getUnderlineColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mUnderlineColor : invokeV.intValue;
    }

    public float getUnderlineHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mUnderlineHeight : invokeV.floatValue;
    }

    public boolean isTabSpaceEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mTabSpaceEqual : invokeV.booleanValue;
    }

    public boolean isTextAllCaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mTextAllCaps : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, canvas) == null) {
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
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            this.mCurrentTab = i2;
            this.mCurrentPositionOffset = f2;
            scrollToCurrentTab();
            invalidate();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            updateTabSelection(i2);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, parcelable) == null) {
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
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            bundle.putInt("mCurrentTab", this.mCurrentTab);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.mCurrentTab = i2;
            this.mViewPager.setCurrentItem(i2);
        }
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mDividerColor = i2;
            invalidate();
        }
    }

    public void setDividerPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            this.mDividerPadding = dp2px(f2);
            invalidate();
        }
    }

    public void setDividerWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            this.mDividerWidth = dp2px(f2);
            invalidate();
        }
    }

    public void setIndicatorColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.mIndicatorColor = i2;
            invalidate();
        }
    }

    public void setIndicatorCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.mIndicatorCornerRadius = dp2px(f2);
            invalidate();
        }
    }

    public void setIndicatorGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mIndicatorGravity = i2;
            invalidate();
        }
    }

    public void setIndicatorHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            this.mIndicatorHeight = dp2px(f2);
            invalidate();
        }
    }

    public void setIndicatorMargin(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mIndicatorMarginLeft = dp2px(f2);
            this.mIndicatorMarginTop = dp2px(f3);
            this.mIndicatorMarginRight = dp2px(f4);
            this.mIndicatorMarginBottom = dp2px(f5);
            invalidate();
        }
    }

    public void setIndicatorStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.mIndicatorStyle = i2;
            invalidate();
        }
    }

    public void setIndicatorWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            this.mIndicatorWidth = dp2px(f2);
            invalidate();
        }
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mIndicatorWidthEqualTitle = z;
            invalidate();
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onTabSelectListener) == null) {
            this.mListener = onTabSelectListener;
        }
    }

    public void setTabPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f2) == null) {
            this.mTabPadding = dp2px(f2);
            updateTabStyles();
        }
    }

    public void setTabSpaceEqual(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mTabSpaceEqual = z;
            updateTabStyles();
        }
    }

    public void setTabWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f2) == null) {
            this.mTabWidth = dp2px(f2);
            updateTabStyles();
        }
    }

    public void setTextAllCaps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.mTextAllCaps = z;
            updateTabStyles();
        }
    }

    public void setTextBold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.mTextBold = i2;
            updateTabStyles();
        }
    }

    public void setTextSelectColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.mTextSelectColor = i2;
            updateTabStyles();
        }
    }

    public void setTextUnselectColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.mTextUnselectColor = i2;
            updateTabStyles();
        }
    }

    public void setTextsize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            this.mTextsize = sp2px(f2);
            updateTabStyles();
        }
    }

    public void setTitles(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, list) == null) {
            this.mTitles = list;
        }
    }

    public void setUnderlineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.mUnderlineColor = i2;
            invalidate();
        }
    }

    public void setUnderlineGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.mUnderlineGravity = i2;
            invalidate();
        }
    }

    public void setUnderlineHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f2) == null) {
            this.mUnderlineHeight = dp2px(f2);
            invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, viewPager) == null) {
            if (viewPager != null && viewPager.getAdapter() != null) {
                this.mViewPager = viewPager;
                viewPager.removeOnPageChangeListener(this);
                this.mViewPager.addOnPageChangeListener(this);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
    }

    public int sp2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048640, this, f2)) == null) ? (int) ((f2 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeF.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        if (attributeValue.equals("-1") || attributeValue.equals(StatHelper.SENSOR_ERR_2)) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
        obtainStyledAttributes.recycle();
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mCurrentTab = i2;
            this.mViewPager.setCurrentItem(i2, z);
        }
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, viewPager, strArr) == null) {
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
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048639, this, viewPager, strArr, fragmentActivity, arrayList) == null) {
            if (viewPager != null) {
                if (strArr != null && strArr.length != 0) {
                    this.mViewPager = viewPager;
                    viewPager.setAdapter(new InnerPagerAdapter(this, fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
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
}

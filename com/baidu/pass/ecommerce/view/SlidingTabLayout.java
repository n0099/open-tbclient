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
import com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class InnerPagerAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<Fragment> fragments;
        public final /* synthetic */ SlidingTabLayout this$0;
        public String[] titles;

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
            }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerPagerAdapter(SlidingTabLayout slidingTabLayout, FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout, fragmentManager, arrayList, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.fragments.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.fragments.get(i);
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.titles[i];
            }
            return (CharSequence) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void addNewTab(String str) {
        String str2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            View inflate = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d050d, null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    public int dp2px(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            return (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeF.intValue;
    }

    public TextView getTitleView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return (TextView) this.mTabsContainer.getChildAt(i).findViewById(R.id.obfuscated_res_0x7f092516);
        }
        return (TextView) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            updateTabSelection(i);
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mCurrentTab = i;
            this.mViewPager.setCurrentItem(i);
        }
    }

    public void setDividerColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.mDividerColor = i;
            invalidate();
        }
    }

    public void setDividerPadding(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f) == null) {
            this.mDividerPadding = dp2px(f);
            invalidate();
        }
    }

    public void setDividerWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f) == null) {
            this.mDividerWidth = dp2px(f);
            invalidate();
        }
    }

    public void setIndicatorColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mIndicatorColor = i;
            invalidate();
        }
    }

    public void setIndicatorCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f) == null) {
            this.mIndicatorCornerRadius = dp2px(f);
            invalidate();
        }
    }

    public void setIndicatorGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mIndicatorGravity = i;
            invalidate();
        }
    }

    public void setIndicatorHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            this.mIndicatorHeight = dp2px(f);
            invalidate();
        }
    }

    public void setIndicatorStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mIndicatorStyle = i;
            invalidate();
        }
    }

    public void setIndicatorWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f) == null) {
            this.mIndicatorWidth = dp2px(f);
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

    public void setTabPadding(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f) == null) {
            this.mTabPadding = dp2px(f);
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

    public void setTabWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f) == null) {
            this.mTabWidth = dp2px(f);
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

    public void setTextBold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mTextBold = i;
            updateTabStyles();
        }
    }

    public void setTextSelectColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mTextSelectColor = i;
            updateTabStyles();
        }
    }

    public void setTextUnselectColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mTextUnselectColor = i;
            updateTabStyles();
        }
    }

    public void setTextsize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f) == null) {
            this.mTextsize = sp2px(f);
            updateTabStyles();
        }
    }

    public void setTitles(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, list) == null) {
            this.mTitles = list;
        }
    }

    public void setUnderlineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.mUnderlineColor = i;
            invalidate();
        }
    }

    public void setUnderlineGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.mUnderlineGravity = i;
            invalidate();
        }
    }

    public void setUnderlineHeight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f) == null) {
            this.mUnderlineHeight = dp2px(f);
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

    public int sp2px(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048640, this, f)) == null) {
            return (int) ((f * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return invokeF.intValue;
    }

    private void addTab(int i, String str, View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, str, view2) == null) {
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092516);
            if (textView != null && str != null) {
                textView.setText(str);
            }
            view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.SlidingTabLayout.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    int indexOfChild;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) && (indexOfChild = this.this$0.mTabsContainer.indexOfChild(view3)) != -1) {
                        if (this.this$0.mViewPager.getCurrentItem() != indexOfChild) {
                            if (this.this$0.mListener != null) {
                                this.this$0.mListener.onTabSelect(indexOfChild);
                            }
                        } else if (this.this$0.mListener != null) {
                            this.this$0.mListener.onTabReselect(indexOfChild);
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
    }

    private void calcIndicatorRect() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.obfuscated_res_0x7f092516)).getText().toString())) / 2.0f;
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
                    this.margin = f2 + (this.mCurrentPositionOffset * ((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.obfuscated_res_0x7f092516)).getText().toString())) / 2.0f) - f2));
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
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        String str;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        int dp2px;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, attributeSet) == null) {
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
    }

    private void scrollToCurrentTab() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65545, this) != null) || this.mTabCount <= 0) {
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

    public void notifyDataSetChanged() {
        int size;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mTabsContainer.removeAllViews();
            List<String> list = this.mTitles;
            if (list == null) {
                size = this.mViewPager.getAdapter().getCount();
            } else {
                size = list.size();
            }
            this.mTabCount = size;
            for (int i = 0; i < this.mTabCount; i++) {
                View inflate = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d050d, null);
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
    }

    private void updateTabSelection(int i) {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i) == null) {
            for (int i3 = 0; i3 < this.mTabCount; i3++) {
                View childAt = this.mTabsContainer.getChildAt(i3);
                if (i3 == i) {
                    z = true;
                } else {
                    z = false;
                }
                TextView textView = (TextView) childAt.findViewById(R.id.obfuscated_res_0x7f092516);
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

    private void updateTabStyles() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            for (int i2 = 0; i2 < this.mTabCount; i2++) {
                TextView textView = (TextView) this.mTabsContainer.getChildAt(i2).findViewById(R.id.obfuscated_res_0x7f092516);
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
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCurrentTab;
        }
        return invokeV.intValue;
    }

    public int getDividerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDividerColor;
        }
        return invokeV.intValue;
    }

    public float getDividerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDividerPadding;
        }
        return invokeV.floatValue;
    }

    public float getDividerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDividerWidth;
        }
        return invokeV.floatValue;
    }

    public int getIndicatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mIndicatorColor;
        }
        return invokeV.intValue;
    }

    public float getIndicatorCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIndicatorCornerRadius;
        }
        return invokeV.floatValue;
    }

    public float getIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mIndicatorHeight;
        }
        return invokeV.floatValue;
    }

    public float getIndicatorMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIndicatorMarginBottom;
        }
        return invokeV.floatValue;
    }

    public float getIndicatorMarginLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIndicatorMarginLeft;
        }
        return invokeV.floatValue;
    }

    public float getIndicatorMarginRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIndicatorMarginRight;
        }
        return invokeV.floatValue;
    }

    public float getIndicatorMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mIndicatorMarginTop;
        }
        return invokeV.floatValue;
    }

    public int getIndicatorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mIndicatorStyle;
        }
        return invokeV.intValue;
    }

    public float getIndicatorWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mIndicatorWidth;
        }
        return invokeV.floatValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTabCount;
        }
        return invokeV.intValue;
    }

    public float getTabPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mTabPadding;
        }
        return invokeV.floatValue;
    }

    public float getTabWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mTabWidth;
        }
        return invokeV.floatValue;
    }

    public int getTextBold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mTextBold;
        }
        return invokeV.intValue;
    }

    public int getTextSelectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mTextSelectColor;
        }
        return invokeV.intValue;
    }

    public int getTextUnselectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mTextUnselectColor;
        }
        return invokeV.intValue;
    }

    public float getTextsize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTextsize;
        }
        return invokeV.floatValue;
    }

    public List<String> getTitles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mTitles;
        }
        return (List) invokeV.objValue;
    }

    public int getUnderlineColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mUnderlineColor;
        }
        return invokeV.intValue;
    }

    public float getUnderlineHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mUnderlineHeight;
        }
        return invokeV.floatValue;
    }

    public boolean isTabSpaceEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mTabSpaceEqual;
        }
        return invokeV.booleanValue;
    }

    public boolean isTextAllCaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mTextAllCaps;
        }
        return invokeV.booleanValue;
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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, canvas) == null) {
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
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            this.mCurrentTab = i;
            this.mCurrentPositionOffset = f;
            scrollToCurrentTab();
            invalidate();
        }
    }

    public void setCurrentTab(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mCurrentTab = i;
            this.mViewPager.setCurrentItem(i, z);
        }
    }

    public void setIndicatorMargin(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mIndicatorMarginLeft = dp2px(f);
            this.mIndicatorMarginTop = dp2px(f2);
            this.mIndicatorMarginRight = dp2px(f3);
            this.mIndicatorMarginBottom = dp2px(f4);
            invalidate();
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

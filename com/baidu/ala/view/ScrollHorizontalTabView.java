package com.baidu.ala.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.ala.data.TabData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mCurrentPositionOffset;
    public int mCurrentTabIndex;
    public final int mIndicatorHeight;
    public final int mIndicatorWidth;
    public boolean mIsClicked;
    public int mLastScrollX;
    public View.OnClickListener mOnItemClickListener;
    public final InnerScrollTabPageListener mPageListener;
    public ViewPager mPager;
    public Paint mRectPaint;
    public int mScrollOffset;
    public ScrollTabPageListener mScrollTabPageListener;
    public int mSelectorColor;
    public final List<TabData> mTabDataList;
    public final List<View> mTabItemView;
    public LinearLayout mTabsContainer;
    public int mTextSize;
    public OnTabClickListener onTabClickListener;

    /* loaded from: classes.dex */
    public class InnerScrollTabPageListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLastPosition;
        public final /* synthetic */ ScrollHorizontalTabView this$0;

        public InnerScrollTabPageListener(ScrollHorizontalTabView scrollHorizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollHorizontalTabView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.this$0.mTabsContainer.getChildCount() == 0 || this.this$0.mPager == null || i != 0) {
                return;
            }
            this.this$0.mCurrentPositionOffset = 0.0f;
            this.this$0.mIsClicked = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                if (this.this$0.mScrollTabPageListener != null) {
                    this.this$0.mScrollTabPageListener.onPageScrolled(i, f, i2);
                }
                if (this.this$0.mTabsContainer.getChildCount() == 0 || this.this$0.mIsClicked) {
                    return;
                }
                if (this.this$0.mCurrentTabIndex != i) {
                    this.mLastPosition = this.this$0.mCurrentTabIndex;
                }
                this.this$0.mCurrentTabIndex = i;
                this.this$0.mCurrentPositionOffset = f;
                ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                scrollHorizontalTabView.scrollToChild(i, (int) (f * scrollHorizontalTabView.mTabsContainer.getChildAt(i).getWidth()));
                this.this$0.updateTabStyles();
                this.this$0.invalidate();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                TabData tabData = (TabData) ListUtils.getItem(this.this$0.mTabDataList, i);
                if (this.this$0.mScrollTabPageListener == null || this.this$0.mScrollTabPageListener.onPrePageSelect(i, tabData)) {
                    if (this.this$0.mScrollTabPageListener != null) {
                        this.this$0.mScrollTabPageListener.onPageSelected(i, tabData);
                    }
                    if (this.this$0.mIsClicked) {
                        if (this.this$0.mCurrentTabIndex != i) {
                            this.mLastPosition = this.this$0.mCurrentTabIndex;
                        }
                        this.this$0.mCurrentTabIndex = i;
                        ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                        scrollHorizontalTabView.scrollToChild(i, (int) (scrollHorizontalTabView.mCurrentPositionOffset * this.this$0.mTabsContainer.getChildAt(i).getWidth()));
                        this.this$0.updateTabStyles();
                        this.this$0.invalidate();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnTabClickListener {
        void onClick(int i);
    }

    /* loaded from: classes.dex */
    public interface ScrollTabPageListener {
        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i, TabData tabData);

        boolean onPrePageSelect(int i, TabData tabData);
    }

    /* loaded from: classes.dex */
    public class ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView icon;
        public final /* synthetic */ ScrollHorizontalTabView this$0;
        public TextView title;

        public ViewHolder(ScrollHorizontalTabView scrollHorizontalTabView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollHorizontalTabView;
            this.title = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ab);
            this.icon = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921a7);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d4);
        this.mIndicatorWidth = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener(this) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollHorizontalTabView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (view2 == this.this$0.mTabItemView.get(i4)) {
                            i3 = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i3);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i3);
                    }
                }
            }
        };
        init();
    }

    private void fillTabData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            int size = this.mTabDataList.size();
            int size2 = this.mTabItemView.size();
            for (int i = 0; i < size && i < size2; i++) {
                TabData tabData = this.mTabDataList.get(i);
                if (tabData == null) {
                    return;
                }
                ViewHolder viewHolder = new ViewHolder(this, this.mTabItemView.get(i));
                TextView textView = viewHolder.title;
                if (textView != null) {
                    textView.setText(tabData.tabName);
                }
                if (viewHolder.icon != null) {
                    Object obj = tabData.extra;
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        viewHolder.icon.setVisibility(0);
                    }
                }
                viewHolder.icon.setVisibility(8);
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            setHorizontalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mTabsContainer = linearLayout;
            linearLayout.setGravity(16);
            this.mTabsContainer.setOrientation(0);
            this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTabsContainer.setClipChildren(false);
            addView(this.mTabsContainer);
            Paint paint = new Paint();
            this.mRectPaint = paint;
            paint.setAntiAlias(true);
            this.mRectPaint.setStyle(Paint.Style.FILL);
            this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, getResources().getDisplayMetrics());
            this.mTextSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbfontsize44);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65555, this, i, i2) == null) || this.mTabItemView.isEmpty()) {
            return;
        }
        int left = this.mTabItemView.get(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.mScrollOffset;
        }
        if (left != this.mLastScrollX) {
            this.mLastScrollX = left;
            scrollTo(left, 0);
        }
    }

    private void setTabStatus(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65556, this, textView, z) == null) || textView == null) {
            return;
        }
        if (z) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
        }
    }

    private void setupTabItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            int size = this.mTabDataList.size();
            int size2 = this.mTabItemView.size();
            getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
            getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
            if (size > size2) {
                while (size2 < size) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d073f, (ViewGroup) null, false);
                    inflate.setOnClickListener(this.mOnItemClickListener);
                    TextView textView = new ViewHolder(this, inflate).title;
                    if (textView != null) {
                        textView.setTextSize(0, this.mTextSize);
                    }
                    this.mTabItemView.add(inflate);
                    size2++;
                }
            } else if (size < size2) {
                for (int i = size2 - 1; i >= size; i--) {
                    this.mTabItemView.remove(i);
                }
            }
            this.mTabsContainer.removeAllViews();
            int size3 = this.mTabItemView.size();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            for (int i2 = 0; i2 < size3; i2++) {
                this.mTabsContainer.addView(this.mTabItemView.get(i2), layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            int size = this.mTabItemView.size();
            for (int i = 0; i < size; i++) {
                TextView textView = new ViewHolder(this, this.mTabItemView.get(i)).title;
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        setTabStatus(textView, true);
                    } else {
                        setTabStatus(textView, false);
                    }
                }
            }
        }
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrentTabIndex : invokeV.intValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
            updateTabStyles();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.mTabItemView.isEmpty()) {
                return;
            }
            int height = getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            View childAt = this.mTabsContainer.getChildAt(this.mCurrentTabIndex);
            int width = (childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight();
            int left = this.mTabsContainer.getLeft() + childAt.getLeft() + childAt.getPaddingLeft();
            int i = this.mIndicatorWidth;
            float f = left + ((width - i) / 2);
            float f2 = i + f;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
                View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
                int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
                int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.mTabsContainer.getLeft();
                int i2 = this.mIndicatorWidth;
                float f3 = left2 + ((width2 - i2) / 2);
                float f4 = this.mCurrentPositionOffset;
                f = (f3 * f4) + ((1.0f - f4) * f);
                f2 = ((i2 + f3) * f4) + ((1.0f - f4) * f2);
            }
            canvas.drawRoundRect(new RectF(f, height - this.mIndicatorHeight, f2, height), 10.0f, 10.0f, this.mRectPaint);
        }
    }

    public void setCurrentIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            setCurrentIndex(i, true);
        }
    }

    public void setData(List<TabData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mTabDataList.clear();
            if (!ListUtils.isEmpty(list)) {
                this.mTabDataList.addAll(list);
            }
            setupTabItems();
            fillTabData();
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ScrollHorizontalTabView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                        scrollHorizontalTabView.mCurrentTabIndex = scrollHorizontalTabView.mPager.getCurrentItem();
                        ScrollHorizontalTabView scrollHorizontalTabView2 = this.this$0;
                        scrollHorizontalTabView2.scrollToChild(scrollHorizontalTabView2.mCurrentTabIndex, 0);
                    }
                }
            });
        }
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onTabClickListener) == null) {
            this.onTabClickListener = onTabClickListener;
        }
    }

    public void setScrollTabPageListener(ScrollTabPageListener scrollTabPageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scrollTabPageListener) == null) {
            this.mScrollTabPageListener = scrollTabPageListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewPager) == null) {
            this.mPager = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.mPageListener);
        }
    }

    public void setCurrentIndex(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                int[] iArr = new int[2];
                ((View) ListUtils.getItem(this.mTabItemView, i)).getLocationOnScreen(iArr);
                int k = oi.k(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256);
                if (iArr[0] < 0) {
                    post(new Runnable(this, dimensionPixelSize) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ScrollHorizontalTabView this$0;
                        public final /* synthetic */ int val$itemWidth;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(dimensionPixelSize)};
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
                            this.val$itemWidth = dimensionPixelSize;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.scrollBy(0 - this.val$itemWidth, 0);
                            }
                        }
                    });
                } else if (k < dimensionPixelSize) {
                    post(new Runnable(this) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ScrollHorizontalTabView this$0;

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

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                                scrollHorizontalTabView.scrollBy(scrollHorizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256), 0);
                            }
                        }
                    });
                }
            }
            ViewPager viewPager = this.mPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(i);
            }
            updateTabStyles();
        }
    }

    public void setData(List<TabData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, list, i) == null) {
            if (i > 0) {
                this.mTextSize = getContext().getResources().getDimensionPixelSize(i);
            }
            setData(list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d4);
        this.mIndicatorWidth = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener(this) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollHorizontalTabView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (view2 == this.this$0.mTabItemView.get(i4)) {
                            i3 = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i3);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i3);
                    }
                }
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i) {
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
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d4);
        this.mIndicatorWidth = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener(this) { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollHorizontalTabView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i32 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (view2 == this.this$0.mTabItemView.get(i4)) {
                            i32 = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i32);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i32);
                    }
                }
            }
        };
        init();
    }
}

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
import b.a.e.e.p.l;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollHorizontalTabView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.this$0.mTabsContainer.getChildCount() == 0 || this.this$0.mPager == null || i2 != 0) {
                return;
            }
            this.this$0.mCurrentPositionOffset = 0.0f;
            this.this$0.mIsClicked = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                if (this.this$0.mScrollTabPageListener != null) {
                    this.this$0.mScrollTabPageListener.onPageScrolled(i2, f2, i3);
                }
                if (this.this$0.mTabsContainer.getChildCount() == 0 || this.this$0.mIsClicked) {
                    return;
                }
                if (this.this$0.mCurrentTabIndex != i2) {
                    this.mLastPosition = this.this$0.mCurrentTabIndex;
                }
                this.this$0.mCurrentTabIndex = i2;
                this.this$0.mCurrentPositionOffset = f2;
                ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                scrollHorizontalTabView.scrollToChild(i2, (int) (f2 * scrollHorizontalTabView.mTabsContainer.getChildAt(i2).getWidth()));
                this.this$0.updateTabStyles();
                this.this$0.invalidate();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                TabData tabData = (TabData) ListUtils.getItem(this.this$0.mTabDataList, i2);
                if (this.this$0.mScrollTabPageListener == null || this.this$0.mScrollTabPageListener.onPrePageSelect(i2, tabData)) {
                    if (this.this$0.mScrollTabPageListener != null) {
                        this.this$0.mScrollTabPageListener.onPageSelected(i2, tabData);
                    }
                    if (this.this$0.mIsClicked) {
                        if (this.this$0.mCurrentTabIndex != i2) {
                            this.mLastPosition = this.this$0.mCurrentTabIndex;
                        }
                        this.this$0.mCurrentTabIndex = i2;
                        ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                        scrollHorizontalTabView.scrollToChild(i2, (int) (scrollHorizontalTabView.mCurrentPositionOffset * this.this$0.mTabsContainer.getChildAt(i2).getWidth()));
                        this.this$0.updateTabStyles();
                        this.this$0.invalidate();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface OnTabClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes6.dex */
    public interface ScrollTabPageListener {
        void onPageScrolled(int i2, float f2, int i3);

        void onPageSelected(int i2, TabData tabData);

        boolean onPrePageSelect(int i2, TabData tabData);
    }

    /* loaded from: classes6.dex */
    public class ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView icon;
        public final /* synthetic */ ScrollHorizontalTabView this$0;
        public TextView title;

        public ViewHolder(ScrollHorizontalTabView scrollHorizontalTabView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollHorizontalTabView;
            this.title = (TextView) view.findViewById(R.id.tv_item);
            this.icon = (TextView) view.findViewById(R.id.tv_icon);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        } else if (view == this.this$0.mTabItemView.get(i5)) {
                            i4 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i4);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i4);
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
            for (int i2 = 0; i2 < size && i2 < size2; i2++) {
                TabData tabData = this.mTabDataList.get(i2);
                if (tabData == null) {
                    return;
                }
                ViewHolder viewHolder = new ViewHolder(this, this.mTabItemView.get(i2));
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
    public void scrollToChild(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65555, this, i2, i3) == null) || this.mTabItemView.isEmpty()) {
            return;
        }
        int left = this.mTabItemView.get(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
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
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        }
    }

    private void setupTabItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            int size = this.mTabDataList.size();
            int size2 = this.mTabItemView.size();
            getContext().getResources().getDimensionPixelSize(R.dimen.ds4);
            getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            if (size > size2) {
                while (size2 < size) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.scroll_horizatal_item, (ViewGroup) null, false);
                    inflate.setOnClickListener(this.mOnItemClickListener);
                    TextView textView = new ViewHolder(this, inflate).title;
                    if (textView != null) {
                        textView.setTextSize(0, this.mTextSize);
                    }
                    this.mTabItemView.add(inflate);
                    size2++;
                }
            } else if (size < size2) {
                for (int i2 = size2 - 1; i2 >= size; i2--) {
                    this.mTabItemView.remove(i2);
                }
            }
            this.mTabsContainer.removeAllViews();
            int size3 = this.mTabItemView.size();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            for (int i3 = 0; i3 < size3; i3++) {
                this.mTabsContainer.addView(this.mTabItemView.get(i3), layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            int size = this.mTabItemView.size();
            for (int i2 = 0; i2 < size; i2++) {
                TextView textView = new ViewHolder(this, this.mTabItemView.get(i2)).title;
                if (textView != null) {
                    if (i2 == this.mCurrentTabIndex) {
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

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
            int i2 = this.mIndicatorWidth;
            float f2 = left + ((width - i2) / 2);
            float f3 = i2 + f2;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
                View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
                int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
                int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.mTabsContainer.getLeft();
                int i3 = this.mIndicatorWidth;
                float f4 = left2 + ((width2 - i3) / 2);
                float f5 = this.mCurrentPositionOffset;
                f2 = (f4 * f5) + ((1.0f - f5) * f2);
                f3 = ((i3 + f4) * f5) + ((1.0f - f5) * f3);
            }
            canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f3, height), 10.0f, 10.0f, this.mRectPaint);
        }
    }

    public void setCurrentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            setCurrentIndex(i2, true);
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

    public void setCurrentIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                int[] iArr = new int[2];
                ((View) ListUtils.getItem(this.mTabItemView, i2)).getLocationOnScreen(iArr);
                int k = l.k(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
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
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
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

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ScrollHorizontalTabView scrollHorizontalTabView = this.this$0;
                                scrollHorizontalTabView.scrollBy(scrollHorizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                            }
                        }
                    });
                }
            }
            ViewPager viewPager = this.mPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(i2);
            }
            updateTabStyles();
        }
    }

    public void setData(List<TabData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, list, i2) == null) {
            if (i2 > 0) {
                this.mTextSize = getContext().getResources().getDimensionPixelSize(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        } else if (view == this.this$0.mTabItemView.get(i5)) {
                            i4 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i4);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i4);
                    }
                }
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int size = this.this$0.mTabItemView.size();
                    int i42 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        } else if (view == this.this$0.mTabItemView.get(i5)) {
                            i42 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    this.this$0.mIsClicked = true;
                    if (this.this$0.mPager != null) {
                        this.this$0.mPager.setCurrentItem(i42);
                    }
                    if (this.this$0.onTabClickListener != null) {
                        this.this$0.onTabClickListener.onClick(i42);
                    }
                }
            }
        };
        init();
    }
}

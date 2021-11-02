package com.baidu.searchbox.ui.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.ui.viewpager.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class BdPagerTabBar extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NEW_COUNT_TEXT_SIZE = 9;
    public static final int[] SHADOWS_COLORS;
    public static final int SHADOWS_WIDTH = 45;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter mAdapter;
    public AdapterLinearLayout mAdapterLayout;
    public ColorStateList mColorStateList;
    public boolean mLayoutInActionBar;
    public Drawable mLeftShadow;
    public int mMinTabWidth;
    public boolean mNeedBold;
    public OnTabSelectedListener mOnTabSelectedListener;
    public Drawable mRightShadow;
    public boolean mShadowsEnable;
    public int mTabBackgroundId;
    public int mTabSelTextColor;
    public int mTabTextColor;
    public int mTabTextSize;
    public boolean mUseStandardStyle;

    /* loaded from: classes7.dex */
    public static class LayoutParams extends AdapterLinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class NewTipsTabAdapter extends TabAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewTipsTabAdapter(Context context) {
            super(context, true, true);
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
                    super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.TabAdapter
        public void onConfigConvertView(Context context, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, context, i2, view) == null) {
                BdPagerTab bdPagerTab = this.mTabs.get(i2);
                PagerNewTipsTabBarItem pagerNewTipsTabBarItem = (PagerNewTipsTabBarItem) view;
                if (!this.mUseStandardStyle) {
                    pagerNewTipsTabBarItem.setTextViewMinAndMaxWidth(this.mMinTabWidth, this.mMaxTabWidth);
                }
                pagerNewTipsTabBarItem.setBdPagerTab(bdPagerTab);
            }
        }

        @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.TabAdapter
        public View onCreateView(Context context, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup)) == null) ? new PagerNewTipsTabBarItem(context, this.mUseStandardStyle, this.mLayoutInActionBar) : (View) invokeLL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewTipsTabAdapter(Context context, boolean z, boolean z2) {
            super(context, z, z2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnTabSelectedListener {
        void onTabSelected(BdPagerTabBar bdPagerTabBar, int i2);
    }

    /* loaded from: classes7.dex */
    public static class TabAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public boolean mLayoutInActionBar;
        public int mMaxTabWidth;
        public int mMinTabWidth;
        public int mTabWidth;
        public ArrayList<BdPagerTab> mTabs;
        public boolean mUseStandardStyle;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TabAdapter(Context context) {
            this(context, true, false);
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
                    this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void addTab(BdPagerTab bdPagerTab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdPagerTab) == null) {
                this.mTabs.add(bdPagerTab);
            }
        }

        public void addTabs(List<BdPagerTab> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            this.mTabs.addAll(list);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTabs.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.mTabs.get(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
                BdPagerTab bdPagerTab = this.mTabs.get(i2);
                if (view == null) {
                    LayoutParams layoutParams = new LayoutParams(this.mTabWidth, -1);
                    if (this.mTabWidth == 0) {
                        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                    }
                    View onCreateView = onCreateView(this.mContext, viewGroup);
                    onCreateView.setLayoutParams(layoutParams);
                    int tabBackgroundResId = bdPagerTab.getTabBackgroundResId();
                    if (tabBackgroundResId != 0) {
                        onCreateView.setBackgroundResource(tabBackgroundResId);
                    }
                    view = onCreateView;
                } else {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 != null) {
                        int i3 = this.mTabWidth;
                        layoutParams2.width = i3;
                        if (i3 == 0 && (layoutParams2 instanceof LayoutParams)) {
                            ((LinearLayout.LayoutParams) ((LayoutParams) layoutParams2)).weight = 1.0f;
                        }
                    }
                    int tabBackgroundResId2 = bdPagerTab.getTabBackgroundResId();
                    if (tabBackgroundResId2 != 0) {
                        view.setBackgroundResource(tabBackgroundResId2);
                    }
                }
                onConfigConvertView(this.mContext, i2, view);
                return view;
            }
            return (View) invokeILL.objValue;
        }

        public void onConfigConvertView(Context context, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048582, this, context, i2, view) == null) {
                PagerTabBarItem pagerTabBarItem = (PagerTabBarItem) view;
                pagerTabBarItem.setMinWidth(this.mMinTabWidth);
                pagerTabBarItem.setMaxWidth(this.mMaxTabWidth);
                pagerTabBarItem.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
                pagerTabBarItem.setBdPagerTab(this.mTabs.get(i2));
            }
        }

        public View onCreateView(Context context, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, viewGroup)) == null) ? new PagerTabBarItem(context, this.mMinTabWidth, this.mMaxTabWidth) : (View) invokeLL.objValue;
        }

        public void removeAllTabs() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.mTabs.clear();
            }
        }

        public void setUIStandard(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.mUseStandardStyle = z;
                this.mLayoutInActionBar = z2;
            }
        }

        public void setWidthParams(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
                this.mMinTabWidth = i2;
                if (i3 == 0) {
                    this.mTabWidth = 0;
                    return;
                }
                int count = getCount();
                if (count != 0) {
                    int i4 = i3 / count;
                    if (i4 < i2) {
                        this.mTabWidth = i2;
                        this.mMaxTabWidth = i2;
                        return;
                    }
                    this.mTabWidth = 0;
                    this.mMaxTabWidth = i4;
                }
            }
        }

        public TabAdapter(Context context, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTabs = new ArrayList<>();
            this.mContext = context;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1977146930, "Lcom/baidu/searchbox/ui/viewpager/BdPagerTabBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1977146930, "Lcom/baidu/searchbox/ui/viewpager/BdPagerTabBar;");
                return;
            }
        }
        SHADOWS_COLORS = new int[]{-1717986919, 11184810, 11184810};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPagerTabBar(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void drawShadows(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, canvas) == null) || getChildCount() == 0) {
            return;
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int measuredWidth = this.mAdapterLayout.getMeasuredWidth();
        boolean z = true;
        boolean z2 = scrollX > 0;
        z = (measuredWidth <= width || width + scrollX >= measuredWidth) ? false : false;
        if (z2 || z) {
            canvas.save();
            canvas.translate(scrollX, 0.0f);
            if (z2) {
                this.mLeftShadow.draw(canvas);
            }
            if (z) {
                this.mRightShadow.draw(canvas);
            }
            canvas.restore();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.tab);
                this.mUseStandardStyle = obtainStyledAttributes.getBoolean(R.styleable.tab_useStandardStyle, true);
                this.mLayoutInActionBar = obtainStyledAttributes.getBoolean(R.styleable.tab_layoutInActionBar, true);
                obtainStyledAttributes.recycle();
            }
            AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(context);
            this.mAdapterLayout = adapterLinearLayout;
            adapterLinearLayout.setGravity(17);
            this.mAdapterLayout.setOrientation(0);
            setAdapter(new TabAdapter(getContext(), this.mUseStandardStyle, this.mLayoutInActionBar));
            addView(this.mAdapterLayout, new FrameLayout.LayoutParams(-1, -1));
            this.mLeftShadow = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, SHADOWS_COLORS);
            this.mRightShadow = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, SHADOWS_COLORS);
            setFillViewport(true);
            setTabTextSize((int) getResources().getDimension(R.dimen.pager_tab_item_textsize));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performUpdateTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Adapter adapter = getAdapter();
            if (adapter instanceof TabAdapter) {
                TabAdapter tabAdapter = (TabAdapter) adapter;
                ArrayList<BdPagerTab> arrayList = tabAdapter.mTabs;
                if (arrayList != null) {
                    Iterator<BdPagerTab> it = arrayList.iterator();
                    while (it.hasNext()) {
                        BdPagerTab next = it.next();
                        next.setColorStateList(this.mColorStateList);
                        next.setTextColor(this.mTabTextColor);
                        next.setSelTextColor(this.mTabSelTextColor);
                        next.setTextSize(this.mTabTextSize);
                        next.setBoldWhenSelect(this.mNeedBold);
                        next.setTabBackgroundResId(this.mTabBackgroundId);
                    }
                }
                tabAdapter.setWidthParams(this.mMinTabWidth, getWidth());
                tabAdapter.notifyDataSetChanged();
            }
        }
    }

    public void addTab(BdPagerTab bdPagerTab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdPagerTab) == null) || bdPagerTab == null) {
            return;
        }
        bdPagerTab.setTextSize((int) getResources().getDimension(R.dimen.pager_tab_item_textsize));
        Adapter adapter = getAdapter();
        if (adapter instanceof TabAdapter) {
            ((TabAdapter) adapter).addTab(bdPagerTab);
        }
    }

    public void addTabs(List<BdPagerTab> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        Adapter adapter = getAdapter();
        if (adapter instanceof TabAdapter) {
            ((TabAdapter) adapter).addTabs(list);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.mShadowsEnable) {
                drawShadows(canvas);
            }
        }
    }

    public Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdapterLayout.getAdapter() : (Adapter) invokeV.objValue;
    }

    public int getSelectedIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAdapterLayout.getSelectedPosition() : invokeV.intValue;
    }

    public BdPagerTab getTabAt(int i2) {
        InterceptResult invokeI;
        Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int tabCount = getTabCount();
            if (i2 < 0 || i2 >= tabCount || (adapter = this.mAdapter) == null) {
                return null;
            }
            return (BdPagerTab) adapter.getItem(i2);
        }
        return (BdPagerTab) invokeI.objValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                return adapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            int i6 = (int) (getResources().getDisplayMetrics().density * 45.0f);
            this.mLeftShadow.setBounds(0, 0, i6, i3);
            this.mRightShadow.setBounds(i2 - i6, 0, i2, i3);
        }
    }

    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Adapter adapter = getAdapter();
            if (adapter instanceof TabAdapter) {
                ((TabAdapter) adapter).removeAllTabs();
            }
        }
    }

    public void selectTab(int i2) {
        AdapterLinearLayout adapterLinearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (adapterLinearLayout = this.mAdapterLayout) == null) {
            return;
        }
        adapterLinearLayout.selectChild(i2);
    }

    public void setAdapter(Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adapter) == null) {
            this.mAdapter = adapter;
            this.mAdapterLayout.setAdapter(adapter);
        }
    }

    public void setAdapterLayoutPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
            this.mAdapterLayout.setPadding(i2, i3, i4, i5);
        }
    }

    public void setBoldWhenSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mNeedBold = z;
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public void setDividerDrawable(Drawable drawable) {
        AdapterLinearLayout adapterLinearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) || (adapterLinearLayout = this.mAdapterLayout) == null) {
            return;
        }
        adapterLinearLayout.setDividerDrawable(drawable);
    }

    public void setDividerWidth(int i2) {
        AdapterLinearLayout adapterLinearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (adapterLinearLayout = this.mAdapterLayout) == null) {
            return;
        }
        adapterLinearLayout.setDividerSize(i2);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onTabSelectedListener) == null) {
            this.mOnTabSelectedListener = onTabSelectedListener;
            this.mAdapterLayout.setOnItemClickListener(new AdapterLinearLayout.OnItemClickListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdPagerTabBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdPagerTabBar this$0;

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

                @Override // com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.OnItemClickListener
                public void onItemClick(AdapterLinearLayout adapterLinearLayout, View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLI(1048576, this, adapterLinearLayout, view, i2) == null) || this.this$0.mOnTabSelectedListener == null || this.this$0.mAdapterLayout.getSelectedPosition() == i2) {
                        return;
                    }
                    this.this$0.mOnTabSelectedListener.onTabSelected(this.this$0, i2);
                }
            });
        }
    }

    public void setShadowsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mShadowsEnable = z;
        }
    }

    public void setTabBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mTabBackgroundId = i2;
        }
    }

    public void setTabMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mMinTabWidth = i2;
        }
    }

    public void setTabSpace(int i2) {
        AdapterLinearLayout adapterLinearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (adapterLinearLayout = this.mAdapterLayout) == null) {
            return;
        }
        adapterLinearLayout.setSpace(i2);
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, colorStateList) == null) {
            this.mColorStateList = colorStateList;
        }
    }

    public void setTabTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mTabTextSize = i2;
        }
    }

    public void setUIStandard(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
            Adapter adapter = this.mAdapter;
            if (adapter instanceof TabAdapter) {
                ((TabAdapter) adapter).setUIStandard(z, z2);
            }
        }
    }

    public void updateTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            updateTabs(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPagerTabBar(Context context, boolean z, boolean z2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mShadowsEnable = false;
        this.mAdapterLayout = null;
        this.mLeftShadow = null;
        this.mRightShadow = null;
        this.mOnTabSelectedListener = null;
        this.mAdapter = null;
        this.mTabTextColor = -1;
        this.mTabSelTextColor = -1;
        this.mColorStateList = null;
        this.mTabTextSize = -1;
        this.mTabBackgroundId = 0;
        this.mMinTabWidth = 50;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mUseStandardStyle = z;
        this.mLayoutInActionBar = z2;
        init(context, null);
    }

    public void setTabTextColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            this.mTabTextColor = i2;
            this.mTabSelTextColor = i3;
        }
    }

    public void updateTabs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                post(new Runnable(this) { // from class: com.baidu.searchbox.ui.viewpager.BdPagerTabBar.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdPagerTabBar this$0;

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
                            this.this$0.performUpdateTabs();
                        }
                    }
                });
            } else {
                performUpdateTabs();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PagerNewTipsTabBarItem extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BadgeView mBadgeView;
        public boolean mLayoutInActionBar;
        public PagerTabBarItem mPagerTabBarItem;
        public boolean mUseStandardStyle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerNewTipsTabBarItem(Context context) {
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
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            init(context);
        }

        private void init(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
                PagerTabBarItem pagerTabBarItem = new PagerTabBarItem(context);
                this.mPagerTabBarItem = pagerTabBarItem;
                pagerTabBarItem.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
                this.mPagerTabBarItem.setId(R.id.msg_center_tab_title_id);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                addView(this.mPagerTabBarItem, layoutParams);
                this.mBadgeView = new BadgeView(context);
            }
        }

        public PagerTabBarItem getPagerTabBarItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPagerTabBarItem : (PagerTabBarItem) invokeV.objValue;
        }

        public void setBdPagerTab(BdPagerTab bdPagerTab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdPagerTab) == null) {
                this.mPagerTabBarItem.setBdPagerTab(bdPagerTab);
                if (!TextUtils.isEmpty(bdPagerTab.getNewCount())) {
                    this.mBadgeView.setType(BadgeView.Type.SMALL_TEXT);
                    this.mBadgeView.setBadgeText(bdPagerTab.getNewCount());
                    this.mBadgeView.bindViewInRelativeLayout(this.mPagerTabBarItem, this, BadgeView.DefaultPosition.TXT_SMALL_TXT);
                } else if (bdPagerTab.isNew()) {
                    this.mBadgeView.setType(BadgeView.Type.DOT);
                    this.mBadgeView.bindViewInRelativeLayout(this.mPagerTabBarItem, this, BadgeView.DefaultPosition.TXT_DOT);
                } else {
                    removeView(this.mBadgeView);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.mPagerTabBarItem.setSelected(z);
            }
        }

        public void setTextViewMinAndMaxWidth(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                this.mPagerTabBarItem.setMinWidth(i2);
                this.mPagerTabBarItem.setMaxWidth(i3);
            }
        }

        public void setUIStandard(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.mUseStandardStyle = z;
                this.mLayoutInActionBar = z2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerNewTipsTabBarItem(Context context, int i2, int i3) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            init(context);
            this.mPagerTabBarItem.setMinWidth(i2);
            this.mPagerTabBarItem.setMaxWidth(i3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerNewTipsTabBarItem(Context context, boolean z, boolean z2) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
            init(context);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerNewTipsTabBarItem(Context context, int i2, int i3, boolean z, boolean z2) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mUseStandardStyle = false;
            this.mLayoutInActionBar = false;
            this.mUseStandardStyle = z;
            this.mLayoutInActionBar = z2;
            init(context);
            this.mPagerTabBarItem.setMinWidth(i2);
            this.mPagerTabBarItem.setMaxWidth(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static class PagerTabBarItem extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mLayoutInActionBar;
        public boolean mNeedBold;
        public int mSelTextColor;
        public int mTextColor;
        public boolean mUseStandardStyle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerTabBarItem(Context context) {
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
            this.mTextColor = -1;
            this.mSelTextColor = -1;
            this.mUseStandardStyle = true;
            this.mLayoutInActionBar = true;
            init(context);
        }

        private void init(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
                setGravity(17);
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
            }
        }

        private void setTextColor(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
                this.mTextColor = i2;
                this.mSelTextColor = i3;
            }
        }

        public void setBdPagerTab(BdPagerTab bdPagerTab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdPagerTab) == null) {
                setText(bdPagerTab.getTitle());
                if (this.mUseStandardStyle) {
                    Resources resources = getResources();
                    if (this.mLayoutInActionBar) {
                        setTextSize(0, resources.getDimensionPixelSize(R.dimen.bdpager_tab_bar_textsize_layoutinactionbar));
                    } else {
                        setTextSize(0, resources.getDimensionPixelSize(R.dimen.bdpager_tab_bar_textsize_not_layoutinactionbar));
                    }
                    setBoldWhenSelect(true);
                    setTextColor(resources.getColor(R.color.UC67), resources.getColor(R.color.UC66));
                    return;
                }
                setTextSize(0, bdPagerTab.getTextSize());
                setBoldWhenSelect(bdPagerTab.isBoldWhenSelect());
                ColorStateList colorStateList = bdPagerTab.getColorStateList();
                if (colorStateList != null) {
                    setTextColor(colorStateList);
                    setTextColor(-1, -1);
                    return;
                }
                setTextColor(bdPagerTab.getTextColor(), bdPagerTab.getSelTextColor());
            }
        }

        public void setBoldWhenSelect(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.mNeedBold = z;
            }
        }

        @Override // android.widget.TextView, android.view.View
        public void setSelected(boolean z) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.setSelected(z);
                int i3 = this.mSelTextColor;
                if (-1 != i3 && -1 != (i2 = this.mTextColor)) {
                    if (!z) {
                        i3 = i2;
                    }
                    setTextColor(i3);
                }
                if (this.mNeedBold) {
                    if (z) {
                        setTypeface(Typeface.defaultFromStyle(1));
                    } else {
                        setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                invalidate();
            }
        }

        public void setUIStandard(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.mUseStandardStyle = z;
                this.mLayoutInActionBar = z2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerTabBarItem(Context context, int i2, int i3) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTextColor = -1;
            this.mSelTextColor = -1;
            this.mUseStandardStyle = true;
            this.mLayoutInActionBar = true;
            init(context);
            setMinWidth(i2);
            setMaxWidth(i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPagerTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPagerTabBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mShadowsEnable = false;
        this.mAdapterLayout = null;
        this.mLeftShadow = null;
        this.mRightShadow = null;
        this.mOnTabSelectedListener = null;
        this.mAdapter = null;
        this.mTabTextColor = -1;
        this.mTabSelTextColor = -1;
        this.mColorStateList = null;
        this.mTabTextSize = -1;
        this.mTabBackgroundId = 0;
        this.mMinTabWidth = 50;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mMinTabWidth = DeviceUtil.ScreenInfo.dp2px(context, 50);
        init(context, attributeSet);
    }
}

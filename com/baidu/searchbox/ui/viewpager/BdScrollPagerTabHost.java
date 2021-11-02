package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.searchbox.ui.viewpager.DrawablePageIndicator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BdScrollPagerTabHost extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanViewPagerScroll;
    public Context mContext;
    public View mDivider;
    public boolean mIsEditableMode;
    public boolean mLayoutInActionBar;
    public OnTabHostChangeListener mListener;
    public DrawablePageIndicator mPageIndicator;
    public BdPagerTabBar mPagerTabBar;
    public OnTabClickListener mTabClickListener;
    public boolean mUseStandardStyle;
    public ViewPager mViewPager;
    public boolean notDispatchMove;
    public FrameLayout pagerTabBarContainer;
    public ImageView settingImage;
    public RelativeLayout settingLayout;

    /* loaded from: classes7.dex */
    public interface OnSettingLayoutClickListener {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface OnTabClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes7.dex */
    public interface OnTabHostChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageSelected(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdScrollPagerTabHost(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mCanViewPagerScroll = z;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.tab);
                this.mUseStandardStyle = obtainStyledAttributes.getBoolean(R.styleable.tab_useStandardStyle, true);
                this.mLayoutInActionBar = obtainStyledAttributes.getBoolean(R.styleable.tab_layoutInActionBar, true);
                obtainStyledAttributes.recycle();
            }
            this.mContext = context;
            if (this.mCanViewPagerScroll) {
                inflate = LayoutInflater.from(context).inflate(R.layout.pager_tab_root_scroll, this);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.pager_tab_root_no_scroll, this);
            }
            BdPagerTabBar bdPagerTabBar = (BdPagerTabBar) inflate.findViewById(R.id.pager_tab_bar);
            this.mPagerTabBar = bdPagerTabBar;
            bdPagerTabBar.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
            if (!isInEditMode()) {
                this.mPagerTabBar.setOnTabSelectedListener(new BdPagerTabBar.OnTabSelectedListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdScrollPagerTabHost this$0;

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

                    @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.OnTabSelectedListener
                    public void onTabSelected(BdPagerTabBar bdPagerTabBar2, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, bdPagerTabBar2, i2) == null) || this.this$0.mViewPager == null) {
                            return;
                        }
                        this.this$0.mViewPager.setCurrentItem(i2);
                    }
                });
            }
            this.mViewPager = (ViewPager) inflate.findViewById(R.id.viewpager);
            this.mDivider = inflate.findViewById(R.id.tabhost_divider);
            this.mViewPager.setOffscreenPageLimit(3);
            DrawablePageIndicator drawablePageIndicator = (DrawablePageIndicator) inflate.findViewById(R.id.indicator);
            this.mPageIndicator = drawablePageIndicator;
            drawablePageIndicator.setUseStandardStyle(this.mUseStandardStyle);
            this.mPageIndicator.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdScrollPagerTabHost this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.this$0.mIsEditableMode) {
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            this.this$0.mPageIndicator.setTabClickListener(new DrawablePageIndicator.OnTabClickListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // com.baidu.searchbox.ui.viewpager.DrawablePageIndicator.OnTabClickListener
                                public void onClick(int i2) {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) || this.this$1.this$0.mTabClickListener == null) {
                                        return;
                                    }
                                    this.this$1.this$0.mTabClickListener.onClick(i2);
                                }
                            });
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.mPageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdScrollPagerTabHost this$0;

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

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.this$0.mIsEditableMode || this.this$0.mListener == null) {
                        return;
                    }
                    this.this$0.mListener.onPageScrollStateChanged(i2);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) != null) || this.this$0.mIsEditableMode) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.this$0.mIsEditableMode) {
                        return;
                    }
                    this.this$0.selectTab(i2);
                    if (this.this$0.mListener != null) {
                        this.this$0.mListener.onPageSelected(i2);
                    }
                }
            });
            this.pagerTabBarContainer = (FrameLayout) inflate.findViewById(R.id.pager_tab_bar_container);
            this.settingLayout = (RelativeLayout) inflate.findViewById(R.id.setting_layout);
            this.settingImage = (ImageView) inflate.findViewById(R.id.setting_image);
            setTabTextColor(getResources().getColorStateList(R.color.tab_item_color));
            setTabTextSize((int) getResources().getDimension(R.dimen.pager_tab_item_textsize));
            setPageResources();
        }
    }

    public void addSettingLayout(int i2, Drawable drawable, OnSettingLayoutClickListener onSettingLayoutClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, drawable, onSettingLayoutClickListener) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPagerTabBar.getLayoutParams();
            int dp2px = DeviceUtil.ScreenInfo.dp2px(null, 41.0f);
            if (i2 <= dp2px) {
                i2 = dp2px;
            }
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPageIndicator.getLayoutParams();
            layoutParams2.leftMargin = i2;
            layoutParams2.rightMargin = i2;
            RelativeLayout relativeLayout = this.settingLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.settingLayout.setOnClickListener(new View.OnClickListener(this, onSettingLayoutClickListener) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdScrollPagerTabHost this$0;
                    public final /* synthetic */ OnSettingLayoutClickListener val$clickListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onSettingLayoutClickListener};
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
                        this.val$clickListener = onSettingLayoutClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.val$clickListener.onClick();
                        }
                    }
                });
                ImageView imageView = this.settingImage;
                if (imageView == null || drawable == null) {
                    return;
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public BdScrollPagerTabHost addTab(BdPagerTab bdPagerTab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdPagerTab)) == null) {
            this.mPagerTabBar.addTab(bdPagerTab);
            return this;
        }
        return (BdScrollPagerTabHost) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? (this.notDispatchMove && 2 == motionEvent.getAction()) || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mViewPager.getCurrentItem() : invokeV.intValue;
    }

    public BdPagerTabBar getPagerTabBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPagerTabBar : (BdPagerTabBar) invokeV.objValue;
    }

    public FrameLayout getPagerTabBarContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrameLayout frameLayout = this.pagerTabBarContainer;
            if (frameLayout != null) {
                return frameLayout;
            }
            return null;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public ImageView getSettingImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.settingImage : (ImageView) invokeV.objValue;
    }

    public RelativeLayout getSettingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RelativeLayout relativeLayout = this.settingLayout;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPagerTabBar.getTabCount() : invokeV.intValue;
    }

    public ViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mViewPager : (ViewPager) invokeV.objValue;
    }

    public void invalidatePageIndicator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mPageIndicator.setTabTextWidthArrayNull();
            this.mPageIndicator.invalidate();
        }
    }

    public void layoutTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mPagerTabBar.updateTabs();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener(this) { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdScrollPagerTabHost this$0;

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

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.this$0.setPageResources();
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    public void onNightModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            setPageResources();
        }
    }

    public void resetPagerTabBarContainerColor() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frameLayout = this.pagerTabBarContainer) == null) {
            return;
        }
        frameLayout.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void selectTab(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.selectTab(i2);
    }

    public void selectTabAndScroll(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.selectTab(i2);
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
        }
    }

    public void setBoldWhenSelect(boolean z) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setBoldWhenSelect(z);
    }

    public void setDividerBackground(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (view = this.mDivider) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setDividerHeight(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (view = this.mDivider) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        this.mDivider.setLayoutParams(layoutParams);
    }

    public void setIndicatorColor(int i2, float f2, float f3) {
        DrawablePageIndicator drawablePageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) || (drawablePageIndicator = this.mPageIndicator) == null) {
            return;
        }
        drawablePageIndicator.setIndicatorColor(i2, f2, f3);
    }

    public void setNoScroll(boolean z) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (viewPager = this.mViewPager) != null && (viewPager instanceof NoScrollViewPager)) {
            ((NoScrollViewPager) viewPager).setNoScroll(z);
        }
    }

    public void setOffscreenPageLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mViewPager.setOffscreenPageLimit(i2);
        }
    }

    public void setPageIndicatorDrawable(int i2) {
        DrawablePageIndicator drawablePageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (drawablePageIndicator = this.mPageIndicator) == null) {
            return;
        }
        drawablePageIndicator.setIndicatorDrawable(getResources().getDrawable(i2));
    }

    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null) {
                viewPager.setBackgroundColor(getResources().getColor(R.color.white));
            }
            View view = this.mDivider;
            if (view != null) {
                view.setBackgroundColor(getResources().getColor(R.color.GC35));
            }
            setTabTextColor(getResources().getColor(R.color.GC4), getResources().getColor(R.color.GC1));
            this.mPageIndicator.updateStandardDrawable();
            setTabBarBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, pagerAdapter, i2) == null) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null) {
                viewPager.setAdapter(pagerAdapter);
                this.mPageIndicator.setViewPager(this.mViewPager, i2);
                this.mPageIndicator.setPagerTabBar(this.mPagerTabBar);
            }
            selectTab(i2);
        }
    }

    public void setSettingImage(Drawable drawable) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, drawable) == null) || (imageView = this.settingImage) == null || drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public void setTabAdapter(Adapter adapter) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, adapter) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setAdapter(adapter);
    }

    public void setTabBarBackground(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setBackground(getResources().getDrawable(i2));
    }

    public void setTabBarBackgroundColor(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setBackgroundColor(i2);
    }

    public void setTabBarBackgroundDrawable(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setBackground(getResources().getDrawable(i2));
    }

    public void setTabBarHeight(int i2) {
        View findViewById;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (findViewById = findViewById(R.id.pager_tab_bar_container)) == null || (layoutParams = findViewById.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i2;
        findViewById.setLayoutParams(layoutParams);
        requestLayout();
    }

    public void setTabChangeListener(OnTabHostChangeListener onTabHostChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onTabHostChangeListener) == null) {
            this.mListener = onTabHostChangeListener;
        }
    }

    public void setTabClickListener(OnTabClickListener onTabClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onTabClickListener) == null) {
            this.mTabClickListener = onTabClickListener;
        }
    }

    public void setTabHostIsEditable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mIsEditableMode = z;
        }
    }

    public void setTabNightModeRes(int i2, int i3, int i4, int i5, int i6) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || (context = this.mContext) == null) {
            return;
        }
        setBackground(context.getResources().getDrawable(i2));
        setPageIndicatorDrawable(i3);
        setTabTextColor(i4, i5);
        setTabBarBackgroundDrawable(i6);
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, colorStateList) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setTabTextColor(colorStateList);
    }

    public void setTabTextSize(int i2) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setTabTextSize(i2);
    }

    public void showOrHideDivider(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || (view = this.mDivider) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void layoutTabs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mPagerTabBar.updateTabs(z);
        }
    }

    public void setIndicatorColor(int i2, float f2) {
        DrawablePageIndicator drawablePageIndicator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (drawablePageIndicator = this.mPageIndicator) == null) {
            return;
        }
        drawablePageIndicator.setIndicatorColor(i2, f2);
    }

    public void setTabTextColor(int i2, int i3) {
        BdPagerTabBar bdPagerTabBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) || (bdPagerTabBar = this.mPagerTabBar) == null) {
            return;
        }
        bdPagerTabBar.setTabTextColor(i2, i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdScrollPagerTabHost(Context context, boolean z, boolean z2, boolean z3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
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
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mCanViewPagerScroll = z;
        this.mUseStandardStyle = z2;
        this.mLayoutInActionBar = z3;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdScrollPagerTabHost(Context context) {
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
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdScrollPagerTabHost(Context context, AttributeSet attributeSet) {
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
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdScrollPagerTabHost(Context context, AttributeSet attributeSet, int i2) {
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
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, attributeSet);
    }
}

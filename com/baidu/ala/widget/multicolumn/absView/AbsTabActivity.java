package com.baidu.ala.widget.multicolumn.absView;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes.dex */
public abstract class AbsTabActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSupportNight;
    public NavigationBar mNavigationBar;
    public CustomOnPageChangeListener mPageChangeListener;
    public FragmentTabHost mTabHost;
    public FragmentTabHost.a onTabSelectionListener;

    /* loaded from: classes.dex */
    public static class CustomOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CustomOnPageChangeListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        public void onPageScrolled(int i2, float f2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        public void onPageSelected(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }
    }

    public AbsTabActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isSupportNight = true;
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{fragment, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        bVar.f12365c = fragment;
        bVar.f12363a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.setTextColorResId(R.color.ala_sub_list_game_live_tab_txt_color);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setIsSupportNight(this.isSupportNight);
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f12364b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initTabSpec() {
        AbsTabPagerAdapter adapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (adapter = getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            Fragment item = adapter.getItem(i2);
            int pageType = adapter.getPageType(i2);
            String tabTitle = adapter.getTabTitle(i2);
            if (item != null) {
                createAndAddTabSpec(item, pageType, tabTitle, false);
            }
        }
        this.mTabHost.l();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.nav_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (!this.isSupportNight) {
                this.mNavigationBar.setAutoNight(false);
                this.mNavigationBar.onBackBtnOnChangeSkin(0);
                this.mNavigationBar.onCenterTextOnChangeSkin(0);
            }
            setNavigationBar(this.mNavigationBar);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setVisibility(0);
            this.mTabHost.setup(getSupportFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbsTabActivity this$0;

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
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.this$0.mPageChangeListener == null) {
                        return;
                    }
                    this.this$0.mPageChangeListener.onPageScrollStateChanged(i2);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.this$0.mPageChangeListener == null) {
                        return;
                    }
                    this.this$0.mPageChangeListener.onPageScrolled(i2, f2, i3, this.this$0.getAdapter().getPageType(i2));
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.this$0.mPageChangeListener == null) {
                        return;
                    }
                    this.this$0.mPageChangeListener.onPageSelected(i2, this.this$0.getAdapter().getPageType(i2));
                }
            });
            this.mTabHost.setOnTabSelectionListener(new FragmentTabHost.a(this) { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbsTabActivity this$0;

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

                @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                public boolean onPreTabSelectionChange(int i2, boolean z) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                        if (this.this$0.onTabSelectionListener != null) {
                            return this.this$0.onTabSelectionListener.onPreTabSelectionChange(i2, z);
                        }
                        return true;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
                public void onTabSelectionChanged(int i2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.this$0.onTabSelectionListener == null) {
                        return;
                    }
                    this.this$0.onTabSelectionListener.onTabSelectionChanged(i2, z);
                }
            });
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
            this.mTabHost.q();
            this.mTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.CAM_X0105));
            this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.ds64));
            this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            initTabSpec();
            this.mTabHost.setCurrentTab(getCurrentIndex());
        }
    }

    public abstract AbsTabPagerAdapter getAdapter();

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            FragmentTabHost fragmentTabHost = this.mTabHost;
            if (fragmentTabHost != null) {
                fragmentTabHost.setNeedShowThemeStyle(false);
                FragmentTabWidget fragmentTabWidget = this.mTabHost.getFragmentTabWidget();
                if (i2 == 1) {
                    resources = getResources();
                    i3 = R.color.CAM_X0105_1;
                } else {
                    resources = getResources();
                    i3 = R.color.CAM_X0105;
                }
                fragmentTabWidget.setDiverColor(resources.getColor(i3));
                this.mTabHost.p(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.abs_act_tabs_layout);
            onPreInit();
            setSwipeBackIsSupportNight(this.isSupportNight);
            initView();
        }
    }

    public void onPreInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void setNavigationBar(NavigationBar navigationBar);

    public void setOnPagerChangeListener(CustomOnPageChangeListener customOnPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, customOnPageChangeListener) == null) {
            this.mPageChangeListener = customOnPageChangeListener;
        }
    }

    public void setOnTabSelectionListener(FragmentTabHost.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.onTabSelectionListener = aVar;
        }
    }
}

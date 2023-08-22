package com.baidu.ala.widget.multicolumn.absView;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class AbsTabActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSupportNight;
    public NavigationBar mNavigationBar;
    public CustomOnPageChangeListener mPageChangeListener;
    public FragmentTabHost mTabHost;

    public abstract AbsTabPagerAdapter getAdapter();

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void onPreInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void setNavigationBar(NavigationBar navigationBar);

    /* loaded from: classes.dex */
    public static class CustomOnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public void onPageScrolled(int i, float f, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            }
        }

        public void onPageSelected(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        public CustomOnPageChangeListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public AbsTabActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isSupportNight = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d001d);
            onPreInit();
            setSwipeBackIsSupportNight(this.isSupportNight);
            initView();
        }
    }

    public void setOnPagerChangeListener(CustomOnPageChangeListener customOnPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, customOnPageChangeListener) == null) {
            this.mPageChangeListener = customOnPageChangeListener;
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{fragment, Integer.valueOf(i), str, Boolean.valueOf(z)}) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        cVar.c = fragment;
        cVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.setTextColorResId(R.color.ala_sub_list_game_live_tab_txt_color);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setIsSupportNight(this.isSupportNight);
        fragmentTabIndicator.setContentWidthWrapContent();
        cVar.b = fragmentTabIndicator;
        this.mTabHost.b(cVar);
    }

    private void initTabSpec() {
        AbsTabPagerAdapter adapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, this) != null) || (adapter = getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            Fragment item = adapter.getItem(i);
            int pageType = adapter.getPageType(i);
            String tabTitle = adapter.getTabTitle(i);
            if (item != null) {
                createAndAddTabSpec(item, pageType, tabTitle, false);
            }
        }
        this.mTabHost.k();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0918c2);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (!this.isSupportNight) {
                this.mNavigationBar.setAutoNight(false);
                this.mNavigationBar.onBackBtnOnChangeSkin(0);
                this.mNavigationBar.onCenterTextOnChangeSkin(0);
            }
            setNavigationBar(this.mNavigationBar);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f09237b);
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

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) && this.this$0.mPageChangeListener != null) {
                        this.this$0.mPageChangeListener.onPageScrollStateChanged(i);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.this$0.mPageChangeListener != null) {
                        this.this$0.mPageChangeListener.onPageSelected(i, this.this$0.getAdapter().getPageType(i));
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.this$0.mPageChangeListener != null) {
                        this.this$0.mPageChangeListener.onPageScrolled(i, f, i2, this.this$0.getAdapter().getPageType(i));
                    }
                }
            });
            this.mTabHost.setOnTabSelectionListener(new FragmentTabHost.b(this) { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbsTabActivity this$0;

                @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                public boolean onPreTabSelectionChange(int i, boolean z) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                        return true;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                public void onTabSelectionChanged(int i, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                    }
                }

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
            });
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.mTabHost.s();
            this.mTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.CAM_X0105));
            this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070363));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.mTabHost.getFragmentTabWidget().setDviderRectHeight(BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f070224));
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            initTabSpec();
            this.mTabHost.setCurrentTab(getCurrentIndex());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            FragmentTabHost fragmentTabHost = this.mTabHost;
            if (fragmentTabHost != null) {
                fragmentTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.CAM_X0105));
                this.mTabHost.r(i);
            }
        }
    }
}

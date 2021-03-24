package com.baidu.ala.widget.multicolumn.absView;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes2.dex */
public abstract class AbsTabActivity extends BaseFragmentActivity {
    public boolean isSupportNight = true;
    public NavigationBar mNavigationBar;
    public CustomOnPageChangeListener mPageChangeListener;
    public FragmentTabHost mTabHost;
    public FragmentTabHost.a onTabSelectionListener;

    /* loaded from: classes2.dex */
    public static class CustomOnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f2, int i2, int i3) {
        }

        public void onPageSelected(int i, int i2) {
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str, boolean z) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        bVar.f13312c = fragment;
        bVar.f13310a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.setTextColorResId(R.color.ala_sub_list_game_live_tab_txt_color);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setIsSupportNight(this.isSupportNight);
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f13311b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private void initTabSpec() {
        AbsTabPagerAdapter adapter = getAdapter();
        if (adapter == null) {
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
        this.mTabHost.l();
    }

    private void initView() {
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
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f2, int i2) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageScrolled(i, f2, i2, AbsTabActivity.this.getAdapter().getPageType(i));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageSelected(i, AbsTabActivity.this.getAdapter().getPageType(i));
                }
            }
        });
        this.mTabHost.setOnTabSelectionListener(new FragmentTabHost.a() { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                if (AbsTabActivity.this.onTabSelectionListener != null) {
                    return AbsTabActivity.this.onTabSelectionListener.onPreTabSelectionChange(i, z);
                }
                return true;
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                if (AbsTabActivity.this.onTabSelectionListener != null) {
                    AbsTabActivity.this.onTabSelectionListener.onTabSelectionChanged(i, z);
                }
            }
        });
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mTabHost.p();
        this.mTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.CAM_X0105));
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.ds64));
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        initTabSpec();
        this.mTabHost.setCurrentTab(getCurrentIndex());
    }

    public abstract AbsTabPagerAdapter getAdapter();

    public int getCurrentIndex() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Resources resources;
        int i2;
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        FragmentTabHost fragmentTabHost = this.mTabHost;
        if (fragmentTabHost != null) {
            fragmentTabHost.setNeedShowThemeStyle(false);
            FragmentTabWidget fragmentTabWidget = this.mTabHost.getFragmentTabWidget();
            if (i == 1) {
                resources = getResources();
                i2 = R.color.CAM_X0105_1;
            } else {
                resources = getResources();
                i2 = R.color.CAM_X0105;
            }
            fragmentTabWidget.setDiverColor(resources.getColor(i2));
            this.mTabHost.o(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.abs_act_tabs_layout);
        onPreInit();
        setSwipeBackIsSupportNight(this.isSupportNight);
        initView();
    }

    public void onPreInit() {
    }

    public abstract void setNavigationBar(NavigationBar navigationBar);

    public void setOnPagerChangeListener(CustomOnPageChangeListener customOnPageChangeListener) {
        this.mPageChangeListener = customOnPageChangeListener;
    }

    public void setOnTabSelectionListener(FragmentTabHost.a aVar) {
        this.onTabSelectionListener = aVar;
    }
}

package com.baidu.ala.widget.multicolumn.absView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public abstract class AbsTabActivity extends BaseFragmentActivity {
    protected boolean isSupportNight = true;
    private NavigationBar mNavigationBar;
    private CustomOnPageChangeListener mPageChangeListener;
    private FragmentTabHost mTabHost;
    private FragmentTabHost.a onTabSelectionListener;

    protected abstract AbsTabPagerAdapter getAdapter();

    protected abstract void setNavigationBar(NavigationBar navigationBar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.abs_act_tabs_layout);
        onPreInit();
        setSwipeBackIsSupportNight(this.isSupportNight);
        initView();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.nav_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!this.isSupportNight) {
            this.mNavigationBar.setAutoNight(false);
            this.mNavigationBar.onBackBtnOnChangeSkin(0);
            this.mNavigationBar.onCenterTextOnChangeSkin(0);
        }
        setNavigationBar(this.mNavigationBar);
        this.mTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        this.mTabHost.setVisibility(0);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageScrolled(i, f, i2, AbsTabActivity.this.getAdapter().getPageType(i));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageSelected(i, AbsTabActivity.this.getAdapter().getPageType(i));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AbsTabActivity.this.mPageChangeListener != null) {
                    AbsTabActivity.this.mPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        });
        this.mTabHost.setOnTabSelectionListener(new FragmentTabHost.a() { // from class: com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                if (AbsTabActivity.this.onTabSelectionListener != null) {
                    AbsTabActivity.this.onTabSelectionListener.onTabSelectionChanged(i, z);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                if (AbsTabActivity.this.onTabSelectionListener != null) {
                    return AbsTabActivity.this.onTabSelectionListener.onPreTabSelectionChange(i, z);
                }
                return true;
            }
        });
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mTabHost.reset();
        this.mTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.cp_cont_b));
        this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.mTabHost.getFragmentTabWidget().setDviderRectWidth(l.getDimens(getActivity(), R.dimen.ds64));
        this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.getDimens(getActivity(), R.dimen.ds4));
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
        initTabSpec();
        this.mTabHost.setCurrentTab(getCurrentIndex());
    }

    private void initTabSpec() {
        AbsTabPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = adapter.getItem(i);
                int pageType = adapter.getPageType(i);
                String tabTitle = adapter.getTabTitle(i);
                if (item != null) {
                    createAndAddTabSpec(item, pageType, tabTitle, false);
                }
            }
            this.mTabHost.initViewPagerWithNoType();
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str, boolean z) {
        if (fragment != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.mContentFragment = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setTextColorResId(R.color.ala_sub_list_game_live_tab_txt_color);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            fragmentTabIndicator.setIsSupportNight(this.isSupportNight);
            fragmentTabIndicator.setContentWidthWrapContent();
            bVar.cim = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    protected int getCurrentIndex() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreInit() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnPagerChangeListener(CustomOnPageChangeListener customOnPageChangeListener) {
        this.mPageChangeListener = customOnPageChangeListener;
    }

    protected void setOnTabSelectionListener(FragmentTabHost.a aVar) {
        this.onTabSelectionListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mTabHost != null) {
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setDiverColor(i == 1 ? getResources().getColor(R.color.cp_cont_b_1) : getResources().getColor(R.color.cp_cont_b));
            this.mTabHost.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class CustomOnPageChangeListener {
        public void onPageScrolled(int i, float f, int i2, int i3) {
        }

        public void onPageSelected(int i, int i2) {
        }

        public void onPageScrollStateChanged(int i) {
        }
    }
}

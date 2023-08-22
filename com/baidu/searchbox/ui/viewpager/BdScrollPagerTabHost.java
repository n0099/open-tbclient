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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.searchbox.ui.viewpager.DrawablePageIndicator;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BdScrollPagerTabHost extends FrameLayout {
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

    /* loaded from: classes4.dex */
    public interface OnSettingLayoutClickListener {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface OnTabClickListener {
        void onClick(int i);
    }

    /* loaded from: classes4.dex */
    public interface OnTabHostChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageSelected(int i);
    }

    public BdScrollPagerTabHost(Context context) {
        super(context);
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, null);
    }

    public BdScrollPagerTabHost addTab(BdPagerTab bdPagerTab) {
        this.mPagerTabBar.addTab(bdPagerTab);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if ((this.notDispatchMove && 2 == motionEvent.getAction()) || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void layoutTabs(boolean z) {
        this.mPagerTabBar.updateTabs(z);
    }

    public void onNightModeChanged(boolean z) {
        setPageResources();
    }

    public void selectTab(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.selectTab(i);
        }
    }

    public void selectTabAndScroll(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.selectTab(i);
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(i);
            }
        }
    }

    public void setBoldWhenSelect(boolean z) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBoldWhenSelect(z);
        }
    }

    public void setDividerBackground(int i) {
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setDividerHeight(int i) {
        View view2 = this.mDivider;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = i;
            this.mDivider.setLayoutParams(layoutParams);
        }
    }

    public void setNoScroll(boolean z) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && (viewPager instanceof NoScrollViewPager)) {
            ((NoScrollViewPager) viewPager).setNoScroll(z);
        }
    }

    public void setOffscreenPageLimit(int i) {
        this.mViewPager.setOffscreenPageLimit(i);
    }

    public void setPageIndicatorDrawable(int i) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorDrawable(getResources().getDrawable(i));
        }
    }

    public void setSettingImage(Drawable drawable) {
        ImageView imageView = this.settingImage;
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setTabAdapter(Adapter adapter) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setAdapter(adapter);
        }
    }

    public void setTabBarBackground(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackground(getResources().getDrawable(i));
        }
    }

    public void setTabBarBackgroundColor(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackgroundColor(i);
        }
    }

    public void setTabBarBackgroundDrawable(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setBackground(getResources().getDrawable(i));
        }
    }

    public void setTabBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091a51);
        if (findViewById != null && (layoutParams = findViewById.getLayoutParams()) != null) {
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void setTabChangeListener(OnTabHostChangeListener onTabHostChangeListener) {
        this.mListener = onTabHostChangeListener;
    }

    public void setTabClickListener(OnTabClickListener onTabClickListener) {
        this.mTabClickListener = onTabClickListener;
    }

    public void setTabHostIsEditable(boolean z) {
        this.mIsEditableMode = z;
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextColor(colorStateList);
        }
    }

    public void setTabTextSize(int i) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextSize(i);
        }
    }

    public void showOrHideDivider(boolean z) {
        int i;
        View view2 = this.mDivider;
        if (view2 != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public BdScrollPagerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, attributeSet);
    }

    public void setIndicatorColor(int i, float f) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorColor(i, f);
        }
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter, int i) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(pagerAdapter);
            this.mPageIndicator.setViewPager(this.mViewPager, i);
            this.mPageIndicator.setPagerTabBar(this.mPagerTabBar);
        }
        selectTab(i);
    }

    public void setTabTextColor(int i, int i2) {
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null) {
            bdPagerTabBar.setTabTextColor(i, i2);
        }
    }

    public BdScrollPagerTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        init(context, attributeSet);
    }

    public void setIndicatorColor(int i, float f, float f2) {
        DrawablePageIndicator drawablePageIndicator = this.mPageIndicator;
        if (drawablePageIndicator != null) {
            drawablePageIndicator.setIndicatorColor(i, f, f2);
        }
    }

    public BdScrollPagerTabHost(Context context, boolean z) {
        super(context);
        this.mCanViewPagerScroll = true;
        this.mIsEditableMode = false;
        this.notDispatchMove = false;
        this.mUseStandardStyle = true;
        this.mLayoutInActionBar = true;
        this.mCanViewPagerScroll = z;
        init(context, null);
    }

    public BdScrollPagerTabHost(Context context, boolean z, boolean z2, boolean z3) {
        super(context);
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

    private void init(Context context, AttributeSet attributeSet) {
        View inflate;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.tab);
            this.mUseStandardStyle = obtainStyledAttributes.getBoolean(1, true);
            this.mLayoutInActionBar = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        this.mContext = context;
        if (this.mCanViewPagerScroll) {
            inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0767, this);
        } else {
            inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0766, this);
        }
        BdPagerTabBar bdPagerTabBar = (BdPagerTabBar) inflate.findViewById(R.id.obfuscated_res_0x7f091a50);
        this.mPagerTabBar = bdPagerTabBar;
        bdPagerTabBar.setUIStandard(this.mUseStandardStyle, this.mLayoutInActionBar);
        if (!isInEditMode()) {
            this.mPagerTabBar.setOnTabSelectedListener(new BdPagerTabBar.OnTabSelectedListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.1
                @Override // com.baidu.searchbox.ui.viewpager.BdPagerTabBar.OnTabSelectedListener
                public void onTabSelected(BdPagerTabBar bdPagerTabBar2, int i) {
                    if (BdScrollPagerTabHost.this.mViewPager != null) {
                        BdScrollPagerTabHost.this.mViewPager.setCurrentItem(i);
                    }
                }
            });
        }
        this.mViewPager = (ViewPager) inflate.findViewById(R.id.obfuscated_res_0x7f092998);
        this.mDivider = inflate.findViewById(R.id.obfuscated_res_0x7f092396);
        this.mViewPager.setOffscreenPageLimit(3);
        DrawablePageIndicator drawablePageIndicator = (DrawablePageIndicator) inflate.findViewById(R.id.obfuscated_res_0x7f091130);
        this.mPageIndicator = drawablePageIndicator;
        drawablePageIndicator.setUseStandardStyle(this.mUseStandardStyle);
        this.mPageIndicator.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (BdScrollPagerTabHost.this.mIsEditableMode) {
                    return true;
                }
                if (motionEvent.getAction() == 0) {
                    BdScrollPagerTabHost.this.mPageIndicator.setTabClickListener(new DrawablePageIndicator.OnTabClickListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.2.1
                        @Override // com.baidu.searchbox.ui.viewpager.DrawablePageIndicator.OnTabClickListener
                        public void onClick(int i) {
                            if (BdScrollPagerTabHost.this.mTabClickListener != null) {
                                BdScrollPagerTabHost.this.mTabClickListener.onClick(i);
                            }
                        }
                    });
                    return false;
                }
                return false;
            }
        });
        this.mPageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (!BdScrollPagerTabHost.this.mIsEditableMode && BdScrollPagerTabHost.this.mListener != null) {
                    BdScrollPagerTabHost.this.mListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BdScrollPagerTabHost.this.mIsEditableMode) {
                    return;
                }
                BdScrollPagerTabHost.this.selectTab(i);
                if (BdScrollPagerTabHost.this.mListener != null) {
                    BdScrollPagerTabHost.this.mListener.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (BdScrollPagerTabHost.this.mIsEditableMode) {
                }
            }
        });
        this.pagerTabBarContainer = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091a51);
        this.settingLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0921a4);
        this.settingImage = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0921a3);
        setTabTextColor(getResources().getColorStateList(R.color.obfuscated_res_0x7f060b41));
        setTabTextSize((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070756));
        setPageResources();
    }

    public void addSettingLayout(int i, Drawable drawable, final OnSettingLayoutClickListener onSettingLayoutClickListener) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPagerTabBar.getLayoutParams();
        int dp2px = DeviceUtil.ScreenInfo.dp2px(null, 41.0f);
        if (i <= dp2px) {
            i = dp2px;
        }
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPageIndicator.getLayoutParams();
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = i;
        RelativeLayout relativeLayout = this.settingLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.settingLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    onSettingLayoutClickListener.onClick();
                }
            });
            ImageView imageView = this.settingImage;
            if (imageView != null && drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public int getCurrentItem() {
        return this.mViewPager.getCurrentItem();
    }

    public BdPagerTabBar getPagerTabBar() {
        return this.mPagerTabBar;
    }

    public FrameLayout getPagerTabBarContainer() {
        FrameLayout frameLayout = this.pagerTabBarContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Nullable
    public ImageView getSettingImage() {
        return this.settingImage;
    }

    public RelativeLayout getSettingLayout() {
        RelativeLayout relativeLayout = this.settingLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return null;
    }

    public int getTabCount() {
        return this.mPagerTabBar.getTabCount();
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public void invalidatePageIndicator() {
        this.mPageIndicator.setTabTextWidthArrayNull();
        this.mPageIndicator.invalidate();
    }

    public void layoutTabs() {
        this.mPagerTabBar.updateTabs();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.viewpager.BdScrollPagerTabHost.4
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BdScrollPagerTabHost.this.setPageResources();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void resetPagerTabBarContainerColor() {
        FrameLayout frameLayout = this.pagerTabBarContainer;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b98));
        }
    }

    public void setPageResources() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b98));
        }
        View view2 = this.mDivider;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0601c6));
        }
        setTabTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0601cb), getResources().getColor(R.color.obfuscated_res_0x7f060191));
        this.mPageIndicator.updateStandardDrawable();
        setTabBarBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b98));
    }

    public void setTabNightModeRes(int i, int i2, int i3, int i4, int i5) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        setBackground(context.getResources().getDrawable(i));
        setPageIndicatorDrawable(i2);
        setTabTextColor(i3, i4);
        setTabBarBackgroundDrawable(i5);
    }
}

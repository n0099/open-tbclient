package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.adlanding.AiAppsAdLandingFragment;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsParam;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsColorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.searchbox.ng.ai.apps.view.Immersion.AiAppsImmersionHelper;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenu;
import com.baidu.searchbox.support.v4.app.Fragment;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class AiAppsBaseFragment extends Fragment implements SlideInterceptor {
    private static final int ACTIONBAR_BACK_BUTTON_WIDTH = 38;
    private static final String ALPHA = "alpha";
    public static final float ALPHA_NORMAL = 1.0f;
    public static final float ALPHA_TRANSPARENT = 0.0f;
    private static final boolean DEBUG = false;
    private static final String EASE_IN = "easeIn";
    private static final String EASE_IN_OUT = "easeInOut";
    private static final String EASE_OUT = "easeOut";
    protected static final String IMMERSION_LAYOUT_TAG = "IMMERSION_LAYOUT_TAG";
    private static final String LINEAR = "linear";
    private static final int OVERLAY_FRAGMENT_MIN_COUNT = 2;
    private static final String TAG = "AiAppsBaseFragment";
    protected Activity mActivity;
    protected AiAppsBdActionBar mAiAppsActionBar;
    protected View mAiAppsActionBarRoot;
    protected String mFrontColor;
    @Nullable
    protected AiAppsImmersionHelper mImmersionHelper;
    protected AiAppsParam mParam;
    protected SlideHelper mSlideHelper;
    protected View mTitleShadowView;
    protected AiAppMenu mToolMenu;
    private boolean mImmersionEnabled = AiAppsImmersionHelper.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    public abstract boolean handleBackPressed();

    protected abstract void initToolMenu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isTabFragment();

    protected abstract void onActionBarSettingPressed();

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = getActivity();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initActionBar(View view) {
        WindowConfig pageWindowConfig;
        this.mAiAppsActionBar = (AiAppsBdActionBar) view.findViewById(R.id.ai_apps_title_bar);
        this.mAiAppsActionBarRoot = view.findViewById(R.id.ai_apps_title_bar_root);
        this.mTitleShadowView = view.findViewById(R.id.title_shadow);
        AiAppsConfigData configData = AiAppsController.getInstance().getConfigData();
        if (configData != null) {
            if (this.mParam == null) {
                pageWindowConfig = configData.mWindowConfig;
            } else {
                pageWindowConfig = AiAppsController.getInstance().getPageWindowConfig(this.mParam.getPage());
            }
            setActionBarBackgroundColor(pageWindowConfig.mNavigationBarBgColor);
            this.mAiAppsActionBar.setTitle(pageWindowConfig.mNavigationBarTitle);
            if (!(this instanceof AiAppsAdLandingFragment)) {
                setNavigationBarFrontColor(pageWindowConfig.mNavigationBarTextStyle);
            }
            this.mFrontColor = pageWindowConfig.mNavigationBarTextStyle;
            this.mAiAppsActionBar.setLeftZoneImageSrcMinWidth(AiAppsUIUtils.dip2px(this.mActivity, 38.0f));
            this.mAiAppsActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AiAppsBaseFragment.this.onActionBarBackPressed();
                }
            });
            this.mAiAppsActionBar.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AiAppsBaseFragment.this.onActionBarSettingPressed();
                    AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                    aiAppsUBCEvent.mValue = "menu";
                    AiAppsBaseFragment.this.doUBCEventStatistic(aiAppsUBCEvent);
                }
            });
            this.mAiAppsActionBar.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (AiAppsBaseFragment.this.mActivity != null) {
                        AiAppsBaseFragment.this.mActivity.moveTaskToBack(true);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, "onClose");
                    hashMap.put(AiAppsLifecycleMessage.APP_ID_KEY, AiApp.getAiAppId());
                    AiAppsController.getInstance().sendJSMessage(new AiAppsLifecycleMessage(hashMap));
                    AiAppsLog.d(AiAppsBaseFragment.TAG, "onClose");
                    AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                    aiAppsUBCEvent.mValue = "close";
                    AiAppsBaseFragment.this.doUBCEventStatistic(aiAppsUBCEvent);
                }
            });
        }
    }

    public boolean setActionBarBackgroundColor(int i) {
        if (this.mAiAppsActionBar == null || this.mTitleShadowView == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.mAiAppsActionBar.setBackgroundColor(i);
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (isShowActionBarShadow()) {
            this.mTitleShadowView.setVisibility(0);
        } else {
            this.mTitleShadowView.setVisibility(8);
        }
        return true;
    }

    public boolean isShowActionBarShadow() {
        return this.mStatusBarColor == -1;
    }

    public void setActionBarTextColor(int i) {
        this.mAiAppsActionBar.setTitleColor(i);
    }

    public void setRightExitViewVisibility(boolean z) {
        this.mAiAppsActionBar.setRightExitViewVisibility(z);
    }

    public void setRightMenuVisibility(boolean z) {
        this.mAiAppsActionBar.setRightMenuVisibility(z);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            resetWithCurImmersion();
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.mImmersionHelper != null && configuration.orientation == 1) {
            getActivity().getWindow().clearFlags(1024);
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    AiAppsBaseFragment.this.resetWithCurImmersion();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            resetWithCurImmersion();
        }
    }

    public void setActionBarAnimator(int i, String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAiAppsActionBar, ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(i);
        char c = 65535;
        switch (str.hashCode()) {
            case -1965087616:
                if (str.equals(EASE_OUT)) {
                    c = 2;
                    break;
                }
                break;
            case -1310316109:
                if (str.equals(EASE_IN)) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 0;
                    break;
                }
                break;
            case 1330629787:
                if (str.equals(EASE_IN_OUT)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ofFloat.setInterpolator(new LinearInterpolator());
                break;
            case 1:
                ofFloat.setInterpolator(new AccelerateInterpolator());
                break;
            case 2:
                ofFloat.setInterpolator(new DecelerateInterpolator());
                break;
            case 3:
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
        }
        ofFloat.start();
    }

    @Nullable
    public boolean setActionbarTitle(String str) {
        if (this.mAiAppsActionBar == null) {
            return false;
        }
        this.mAiAppsActionBar.setTitle(str);
        return true;
    }

    public void setLeftZoneImageSrc(int i) {
        this.mAiAppsActionBar.setLeftZoneImageSrc(i);
    }

    public void setLeftExitImageSrc(int i) {
        this.mAiAppsActionBar.setLeftSecondViewImageSrc(i);
    }

    protected void onActionBarHomePressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackViewVisible(boolean z) {
        this.mAiAppsActionBar.setLeftFirstViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadHaveHomeActionBar() {
        this.mAiAppsActionBar.setLeftSecondViewVisibility(0);
        this.mAiAppsActionBar.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiAppsBaseFragment.this.onActionBarHomePressed();
            }
        });
    }

    public boolean isSlidable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AiAppsFragmentManager getAiAppsFragmentManager() {
        if (this.mActivity == null) {
            return null;
        }
        return ((AiAppsActivity) this.mActivity).getAiAppsFragmentManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isLandingFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            return false;
        }
        return aiAppsFragmentManager.getFragmentCount() > 1;
    }

    public void finishAfterSlide() {
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null || aiAppsFragmentManager.getFragmentCount() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_BACK).setCustomAnimations(0, 0).popFragment().commit();
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_BACK;
        doUBCEventStatistic(aiAppsUBCEvent);
    }

    public void onPanelSlide(float f) {
        showOverlayFragment(true);
    }

    public void onPanelClosed() {
        showOverlayFragment(false);
    }

    private void showOverlayFragment(boolean z) {
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null && aiAppsFragmentManager.getFragmentCount() >= 2) {
            AiAppsBaseFragment fragment = aiAppsFragmentManager.getFragment(aiAppsFragmentManager.getFragmentCount() - 2);
            if (z) {
                aiAppsFragmentManager.createTransaction().showFragment(fragment);
            } else {
                aiAppsFragmentManager.createTransaction().hideFragment(fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doUBCEventStatistic(AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent) {
        if (this.mActivity != null && (this.mActivity instanceof AiAppsActivity)) {
            ((AiAppsActivity) this.mActivity).doUBCEventStatistic(aiAppsUBCEvent);
        }
    }

    public boolean setNavigationBarFrontColor(String str) {
        return setNavigationBarFrontColor(AiAppsConfigData.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setNavigationBarFrontColor(@ColorInt int i) {
        if (this.mAiAppsActionBar == null) {
            return false;
        }
        boolean z = this instanceof AiAppsAboutFragment;
        setRightExitViewVisibility(z ? false : true);
        return this.mAiAppsActionBar.setNavigationBarFrontColor(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected void setEnableImmerison(boolean z) {
        this.mImmersionEnabled = AiAppsImmersionHelper.SUPPORT_IMMERSION && z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View initImmersion(View view) {
        if (view == null) {
            return null;
        }
        if (!IMMERSION_LAYOUT_TAG.equals(view.getTag())) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return initImmersion(frameLayout, view);
        }
        return view;
    }

    protected View initImmersion(FrameLayout frameLayout, View view) {
        frameLayout.setTag(IMMERSION_LAYOUT_TAG);
        frameLayout.addView(view);
        this.mImmersionHelper = new AiAppsImmersionHelper(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    protected void applyImmersion() {
        if (this.mImmersionHelper != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.mImmersionHelper != null) {
            applyImmersion(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i, boolean z) {
        if (this.mImmersionHelper != null) {
            this.mStatusBarColor = i;
            this.mImmersionHelper.setImmersion(i, AiAppsColorUtils.isLightColor(i), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.mImmersionHelper != null) {
            this.mImmersionHelper.resetWithCurImmersion();
        }
    }

    protected View enableSliding(View view) {
        SlideInterceptor slideInterceptor = null;
        if (view instanceof SlideInterceptor) {
            slideInterceptor = (SlideInterceptor) view;
        }
        return enableSliding(view, slideInterceptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View enableSliding(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2;
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        this.mSlideHelper.setCanSlide(z);
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment.6
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = AiAppsBaseFragment.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                AiAppsBaseFragment.this.onPanelSlide(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                AiAppsBaseFragment.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                AiAppsBaseFragment.this.onPanelClosed();
            }
        });
        return wrapSlideView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processNightMode(Context context) {
        boolean nightModeSwitcherState = AiAppNightModeHelper.getNightModeSwitcherState();
        AiAppNightModeHelper.setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.mActivity != null && (this.mActivity instanceof AiAppsActivity)) {
            ((AiAppsActivity) this.mActivity).onNightModeCoverChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        }
        if (nightModeSwitcherState) {
            UniversalToast.makeText(context, R.string.aiapps_browser_menu_toast_day_mode).setHighlightDrawable(R.drawable.aiapps_day_mode_toast_icon).setDuration(2).showHighlightToast();
        } else {
            UniversalToast.makeText(context, R.string.aiapps_browser_menu_toast_night_mode).setHighlightDrawable(R.drawable.aiapps_night_mode_toast_icon).setDuration(2).showHighlightToast();
        }
    }
}

package com.baidu.searchbox.ng.ai.apps.tabbar.controller;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.prepose.util.AiAppsDebugUtil;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.tabbar.view.AiAppsBottomTabIconView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class AiAppsBottomBarViewController {
    private static final boolean DEBUG = false;
    private static final int MIN_TAB_ID = 0;
    private static final int TABBAR_ANIM_DURATION = 240;
    private static final String TAB_ITEM_INDEX = "index";
    private static final String TAB_ITEM_PAGEPATH = "pagePath";
    private static final String TAB_ITEM_TAP_EVENT_NAME = "onTabItemTap";
    private static final String TAB_ITEM_TEXT = "text";
    private static final String TAB_WEBVIEW_ID = "wvID";
    public static final String TAG = "bottomBarViewController";
    private static final String TRANSLATIONY = "translationY";
    private ArrayList<AiAppsBottomTabIconView> mAiAppsBottomTabIconViewList;
    private AiAppsFragment mAiAppsFragment;
    private View mBottomBarShadow;
    private ArrayList<AiAppsConfigData.TabItem> mBottomTabItems;
    private LinearLayout mBottomTabLayout;
    private int mIsSelectedBottomTabId = 0;
    private String mNormalColor;
    private String mSelectedColor;
    private AiAppsConfigData.TabBarConfig mTabBarConfig;

    public AiAppsBottomBarViewController(AiAppsFragment aiAppsFragment) {
        this.mAiAppsFragment = aiAppsFragment;
    }

    public void addBottomBar(View view, Context context, String str) {
        AiAppsConfigData configData;
        if (this.mAiAppsFragment.isTabFragment() && (configData = AiAppsController.getInstance().getConfigData()) != null) {
            this.mTabBarConfig = configData.mTabBarConfig;
            this.mBottomTabItems = this.mTabBarConfig.mTabItems;
            int size = this.mBottomTabItems.size();
            this.mAiAppsBottomTabIconViewList = new ArrayList<>(size);
            this.mBottomBarShadow = view.findViewById(R.id.bottom_bar_shadow);
            setBottomBarShadowBackgroundColor(this.mTabBarConfig.mBorderStyle);
            this.mBottomTabLayout = (LinearLayout) view.findViewById(R.id.ai_apps_bottom_tab);
            this.mBottomTabLayout.setVisibility(0);
            this.mBottomTabLayout.setBackgroundColor(this.mTabBarConfig.mBackgroundColor);
            int displayWidth = AiAppsUIUtils.getDisplayWidth(AppRuntime.getAppContext());
            for (final int i = 0; i < size; i++) {
                AiAppsBottomTabIconView aiAppsBottomTabIconView = new AiAppsBottomTabIconView(context);
                AiAppsConfigData.TabItem tabItem = this.mBottomTabItems.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayWidth / size, -1);
                layoutParams.gravity = 1;
                if (tabItem.mPagePath.equals(!TextUtils.isEmpty(str) ? str : AiAppsController.getInstance().getFirstPageUrl())) {
                    setSelectBottomItemView(aiAppsBottomTabIconView, tabItem);
                    this.mIsSelectedBottomTabId = i;
                } else {
                    setNormalBottomItemView(aiAppsBottomTabIconView, tabItem);
                }
                aiAppsBottomTabIconView.setTextView(tabItem.mText);
                aiAppsBottomTabIconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.tabbar.controller.AiAppsBottomBarViewController.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AiAppsBottomBarViewController.this.bottomBarItemClick(i);
                    }
                });
                this.mAiAppsBottomTabIconViewList.add(aiAppsBottomTabIconView);
                this.mBottomTabLayout.addView(aiAppsBottomTabIconView, layoutParams);
            }
        }
    }

    private void setBottomBarShadowBackgroundColor(int i) {
        if (-1 == i) {
            this.mBottomBarShadow.setVisibility(0);
            this.mBottomBarShadow.setBackgroundColor(this.mAiAppsFragment.getResources().getColor(R.color.aiapps_white));
        } else if (-16777216 == i) {
            this.mBottomBarShadow.setVisibility(0);
            this.mBottomBarShadow.setBackgroundColor(this.mAiAppsFragment.getResources().getColor(R.color.aiapps_setting_aiapps_item_divider_color));
        } else {
            this.mBottomBarShadow.setVisibility(0);
            this.mBottomBarShadow.setBackgroundColor(this.mAiAppsFragment.getResources().getColor(R.color.aiapps_white));
        }
    }

    private void setBottomTabLayoutBackgroundColor(String str) {
        this.mBottomTabLayout.setBackgroundColor(AiAppsConfigData.parseColor(str));
    }

    private boolean setNormalBottomItemView(AiAppsBottomTabIconView aiAppsBottomTabIconView, AiAppsConfigData.TabItem tabItem) {
        AiAppsLaunchInfo launchInfo = getLaunchInfo();
        if (launchInfo == null) {
            return false;
        }
        String debugUnzipOutputFolder = AiAppsDebugUtil.getDebugUnzipOutputFolder(launchInfo);
        if (TextUtils.isEmpty(debugUnzipOutputFolder)) {
            debugUnzipOutputFolder = AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(launchInfo.mAppId, launchInfo.mVersion).getPath();
        }
        String str = debugUnzipOutputFolder + File.separator + tabItem.mIconPath;
        if (AiAppsFileUtils.isExistFile(str)) {
            aiAppsBottomTabIconView.setmIsSelect(false);
            aiAppsBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.mNormalColor == null) {
                aiAppsBottomTabIconView.setTextColor(this.mTabBarConfig.mColor);
            } else {
                aiAppsBottomTabIconView.setTextColor(AiAppsConfigData.parseColor(this.mNormalColor));
            }
            return true;
        }
        return false;
    }

    private boolean setSelectBottomItemView(AiAppsBottomTabIconView aiAppsBottomTabIconView, AiAppsConfigData.TabItem tabItem) {
        AiAppsLaunchInfo launchInfo = getLaunchInfo();
        if (launchInfo == null) {
            return false;
        }
        String debugUnzipOutputFolder = AiAppsDebugUtil.getDebugUnzipOutputFolder(launchInfo);
        if (TextUtils.isEmpty(debugUnzipOutputFolder)) {
            debugUnzipOutputFolder = AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(launchInfo.mAppId, launchInfo.mVersion).getPath();
        }
        String str = debugUnzipOutputFolder + File.separator + tabItem.mSelectedIconPath;
        if (AiAppsFileUtils.isExistFile(str)) {
            aiAppsBottomTabIconView.setmIsSelect(true);
            aiAppsBottomTabIconView.setIconView(BitmapFactory.decodeFile(str));
            if (this.mSelectedColor == null) {
                aiAppsBottomTabIconView.setTextColor(this.mTabBarConfig.mSelectedColor);
            } else {
                aiAppsBottomTabIconView.setTextColor(AiAppsConfigData.parseColor(this.mSelectedColor));
            }
            return true;
        }
        return false;
    }

    private AiAppsLaunchInfo getLaunchInfo() {
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            return aiApp.getLaunchInfo();
        }
        return null;
    }

    public boolean closeBottomBar(boolean z) {
        if (this.mBottomBarShadow == null || this.mBottomTabLayout == null) {
            return false;
        }
        this.mBottomBarShadow.setVisibility(8);
        if (z) {
            closeBottomBarWithAnimation();
        } else {
            this.mBottomTabLayout.setVisibility(8);
        }
        return true;
    }

    public boolean openBottomBar(boolean z) {
        if (this.mBottomBarShadow == null || this.mBottomTabLayout == null) {
            return false;
        }
        this.mBottomBarShadow.setVisibility(0);
        this.mBottomTabLayout.setVisibility(0);
        openBottomBarWithAnimation(z);
        return true;
    }

    private void closeBottomBarWithAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBottomTabLayout, TRANSLATIONY, 0.0f, AiAppsRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.aiapps_bottom_tab_height));
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ng.ai.apps.tabbar.controller.AiAppsBottomBarViewController.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AiAppsBottomBarViewController.this.mBottomTabLayout.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    private void openBottomBarWithAnimation(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBottomTabLayout, TRANSLATIONY, AiAppsRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.aiapps_bottom_tab_height), 0.0f);
        ofFloat.setDuration(z ? 240L : 0L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomBarItemClick(int i) {
        refreshBottomBarUISelectStatus(i);
        this.mAiAppsFragment.pause();
        this.mAiAppsFragment.doSwitchTab(AiAppsPageParam.createObject(this.mBottomTabItems.get(i).mPagePath, AiAppsController.getInstance().getBaseUrl()));
        sendTabItemTapMessage(i);
        AiAppsFragment aiAppsFragment = this.mAiAppsFragment;
        AiAppsFragment.setRouteType(AiAppsRouteMessage.TYPE_SWITCH_TAB);
        this.mAiAppsFragment.resume();
    }

    private void sendTabItemTapMessage(int i) {
        HashMap hashMap = new HashMap();
        AiAppsConfigData.TabItem tabItem = this.mBottomTabItems.get(i);
        String tabWebViewId = this.mAiAppsFragment.getTabWebViewId(AiAppsPageParam.createObject(tabItem.mPagePath, AiAppsController.getInstance().getBaseUrl()).mPage);
        hashMap.put("index", String.valueOf(i));
        hashMap.put(TAB_ITEM_PAGEPATH, tabItem.mPagePath);
        hashMap.put("text", tabItem.mText);
        hashMap.put("wvID", tabWebViewId);
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage(TAB_ITEM_TAP_EVENT_NAME, hashMap));
    }

    private void refreshBottomBarUISelectStatus(int i) {
        setNormalBottomItemView(this.mAiAppsBottomTabIconViewList.get(this.mIsSelectedBottomTabId), this.mBottomTabItems.get(this.mIsSelectedBottomTabId));
        setSelectBottomItemView(this.mAiAppsBottomTabIconViewList.get(i), this.mBottomTabItems.get(i));
        this.mIsSelectedBottomTabId = i;
    }

    public void updateTabUI(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mBottomTabItems.size()) {
                if (this.mBottomTabItems.get(i2).mPagePath.equals(str)) {
                    refreshBottomBarUISelectStatus(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean changeBottomBarStyle(String str, String str2, String str3, String str4) {
        if (this.mBottomBarShadow == null || this.mBottomTabLayout == null) {
            return false;
        }
        setBottomBarShadowBackgroundColor(AiAppsConfigData.parseColor(str4));
        setBottomTabLayoutBackgroundColor(str3);
        setNormalColor(str);
        setSelectedColor(str2);
        Iterator<AiAppsBottomTabIconView> it = this.mAiAppsBottomTabIconViewList.iterator();
        while (it.hasNext()) {
            AiAppsBottomTabIconView next = it.next();
            if (next.ismIsSelect()) {
                next.setTextColor(AiAppsConfigData.parseColor(str2));
            } else {
                next.setTextColor(AiAppsConfigData.parseColor(str));
            }
        }
        return true;
    }

    private void setNormalColor(String str) {
        this.mNormalColor = str;
    }

    private void setSelectedColor(String str) {
        this.mSelectedColor = str;
    }

    public boolean setBottomBarItem(int i, String str, String str2, String str3) {
        if (!isCorrectIndex(i)) {
            return false;
        }
        AiAppsBottomTabIconView aiAppsBottomTabIconView = this.mAiAppsBottomTabIconViewList.get(i);
        aiAppsBottomTabIconView.setTextView(str);
        this.mBottomTabItems.get(i).mIconPath = str2;
        this.mBottomTabItems.get(i).mSelectedIconPath = str3;
        if (aiAppsBottomTabIconView.ismIsSelect()) {
            return setSelectBottomItemView(aiAppsBottomTabIconView, this.mBottomTabItems.get(i));
        }
        return setNormalBottomItemView(aiAppsBottomTabIconView, this.mBottomTabItems.get(i));
    }

    public boolean openBottomBarRedDot(int i) {
        if (!isCorrectIndex(i)) {
            return false;
        }
        this.mAiAppsBottomTabIconViewList.get(i).setRedDotVisibleState(true);
        return true;
    }

    public boolean closeBottomBarRedDot(int i) {
        if (isCorrectIndex(i)) {
            this.mAiAppsBottomTabIconViewList.get(i).setRedDotVisibleState(false);
            return true;
        }
        return false;
    }

    public boolean setBottomBadge(int i, String str) {
        if (!isCorrectIndex(i)) {
            return false;
        }
        AiAppsBottomTabIconView aiAppsBottomTabIconView = this.mAiAppsBottomTabIconViewList.get(i);
        aiAppsBottomTabIconView.setBadgeVisibleState(true);
        aiAppsBottomTabIconView.setBadgeText(str);
        return true;
    }

    public boolean closeBottomBadge(int i) {
        if (isCorrectIndex(i)) {
            this.mAiAppsBottomTabIconViewList.get(i).setBadgeVisibleState(false);
            return true;
        }
        return false;
    }

    private boolean isCorrectIndex(int i) {
        return this.mAiAppsBottomTabIconViewList != null && i < this.mAiAppsBottomTabIconViewList.size() && i >= 0;
    }
}

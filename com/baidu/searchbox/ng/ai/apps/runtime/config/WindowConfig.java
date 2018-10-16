package com.baidu.searchbox.ng.ai.apps.runtime.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WindowConfig {
    private static final boolean DEBUG = false;
    private static final String JSON_BACKGROUND_COLOR = "backgroundColor";
    private static final String JSON_BACKGROUND_TEXT_STYLE = "backgroundTextStyle";
    private static final String JSON_ENABLE_OPACITY_NAVIGATION_BAR = "enableOpacityNavigationBar";
    private static final String JSON_ENABLE_OPACITY_NAVIGATION_BAR_TEXT = "enableOpacityNavigationBarText";
    private static final String JSON_ENABLE_PULL_REFRESH = "enablePullDownRefresh";
    private static final String JSON_NAVIGATION_BAR_BG_COLOR = "navigationBarBackgroundColor";
    private static final String JSON_NAVIGATION_BAR_TEXT_STYLE = "navigationBarTextStyle";
    private static final String JSON_NAVIGATION_BAR_TITLE_TEXT = "navigationBarTitleText";
    private static final String JSON_ON_REACH_BOTTOM_DISTANCE = "onReachBottomDistance";
    public static final String JSON_WINDOW_KEY = "window";
    private static final String TAG = "WindowConfig";
    public int mBackgroundColor;
    public String mBackgroundTextStyle;
    public boolean mEnableOpacityNavigationBar;
    public boolean mEnableOpacityNavigationBarText;
    public boolean mEnablePullRefresh;
    public int mNavigationBarBgColor;
    public String mNavigationBarTextStyle;
    public String mNavigationBarTitle;
    public String mOnReachBottomDistance;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowConfig buildWindowConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return createNullObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(JSON_WINDOW_KEY);
        if (optJSONObject == null) {
            return createNullObject();
        }
        return createWindowConfig(optJSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowConfig buildWindowConfig(String str, @NonNull WindowConfig windowConfig) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return createWindowConfig(new JSONObject(str), windowConfig);
            } catch (JSONException e) {
                return windowConfig;
            }
        }
        return windowConfig;
    }

    private static WindowConfig createWindowConfig(JSONObject jSONObject) {
        WindowConfig windowConfig = new WindowConfig();
        windowConfig.mNavigationBarBgColor = AiAppsConfigData.parseColor(jSONObject.optString(JSON_NAVIGATION_BAR_BG_COLOR));
        windowConfig.mNavigationBarTitle = jSONObject.optString(JSON_NAVIGATION_BAR_TITLE_TEXT);
        windowConfig.mNavigationBarTextStyle = jSONObject.optString(JSON_NAVIGATION_BAR_TEXT_STYLE, AiAppsConfigData.BLACK_TEXT_STYLE);
        windowConfig.mBackgroundTextStyle = jSONObject.optString(JSON_BACKGROUND_TEXT_STYLE, AiAppsConfigData.BLACK_TEXT_STYLE);
        windowConfig.mBackgroundColor = AiAppsConfigData.parseColor(jSONObject.optString(JSON_BACKGROUND_COLOR));
        windowConfig.mEnablePullRefresh = jSONObject.optBoolean(JSON_ENABLE_PULL_REFRESH);
        windowConfig.mOnReachBottomDistance = jSONObject.optString(JSON_ON_REACH_BOTTOM_DISTANCE);
        windowConfig.mEnableOpacityNavigationBar = jSONObject.optBoolean(JSON_ENABLE_OPACITY_NAVIGATION_BAR);
        windowConfig.mEnableOpacityNavigationBarText = jSONObject.optBoolean(JSON_ENABLE_OPACITY_NAVIGATION_BAR_TEXT);
        return windowConfig;
    }

    private static WindowConfig createWindowConfig(JSONObject jSONObject, @NonNull WindowConfig windowConfig) {
        WindowConfig windowConfig2 = new WindowConfig();
        windowConfig2.mNavigationBarBgColor = jSONObject.has(JSON_NAVIGATION_BAR_BG_COLOR) ? AiAppsConfigData.parseColor(jSONObject.optString(JSON_NAVIGATION_BAR_BG_COLOR)) : windowConfig.mNavigationBarBgColor;
        windowConfig2.mNavigationBarTitle = jSONObject.optString(JSON_NAVIGATION_BAR_TITLE_TEXT, windowConfig.mNavigationBarTitle);
        windowConfig2.mNavigationBarTextStyle = jSONObject.optString(JSON_NAVIGATION_BAR_TEXT_STYLE, windowConfig.mNavigationBarTextStyle);
        windowConfig2.mBackgroundTextStyle = jSONObject.optString(JSON_BACKGROUND_TEXT_STYLE, windowConfig.mBackgroundTextStyle);
        windowConfig2.mBackgroundColor = jSONObject.has(JSON_BACKGROUND_COLOR) ? AiAppsConfigData.parseColor(jSONObject.optString(JSON_BACKGROUND_COLOR)) : windowConfig.mBackgroundColor;
        windowConfig2.mEnablePullRefresh = jSONObject.optBoolean(JSON_ENABLE_PULL_REFRESH, windowConfig.mEnablePullRefresh);
        windowConfig2.mOnReachBottomDistance = jSONObject.optString(JSON_ON_REACH_BOTTOM_DISTANCE, windowConfig.mOnReachBottomDistance);
        windowConfig2.mEnableOpacityNavigationBar = jSONObject.optBoolean(JSON_ENABLE_OPACITY_NAVIGATION_BAR, windowConfig.mEnableOpacityNavigationBar);
        windowConfig2.mEnableOpacityNavigationBarText = jSONObject.optBoolean(JSON_ENABLE_OPACITY_NAVIGATION_BAR_TEXT, windowConfig.mEnableOpacityNavigationBarText);
        return windowConfig2;
    }

    public static WindowConfig createNullObject() {
        return new WindowConfig();
    }
}

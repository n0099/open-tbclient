package com.baidu.searchbox.ng.ai.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsCommonConfigData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsConfigData {
    public static final String BLACK_TEXT_STYLE = "black";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_COLOR_BLACK = -16777216;
    private static final int DEFAULT_COLOR_WHITE = -1;
    public static final String GRAY_TEXT_STYLE = "#999999";
    private static final String JSON_DEBUG_KEY = "debug";
    private static final String JSON_PAGES_KEY = "pages";
    private static final String JSON_TABBAR_KEY = "tabBar";
    private static final String TAG = "AiAppsConfigData";
    public static final String WHITE_TEXT_STYLE = "white";
    public boolean mIsDebug;
    public AiAppsCommonConfigData.NetworkConfig mNetworkConfig;
    public String mOriginAppData;
    public PageConfig mPageConfig;
    public SubPackageList mSubPackageList;
    public SubPackagesPath mSubPackagesPath;
    public TabBarConfig mTabBarConfig;
    public WindowConfig mWindowConfig;

    public static AiAppsConfigData buildConfigData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AiAppsConfigData aiAppsConfigData = new AiAppsConfigData();
        aiAppsConfigData.mOriginAppData = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aiAppsConfigData.mIsDebug = jSONObject.optBoolean("debug");
            aiAppsConfigData.mPageConfig = PageConfig.buildPageConfig(jSONObject);
            aiAppsConfigData.mSubPackageList = SubPackageList.buildSubPackageConfig(jSONObject);
            aiAppsConfigData.mSubPackagesPath = SubPackagesPath.buildSubPackagesPathMap(jSONObject, aiAppsConfigData.mSubPackageList);
            aiAppsConfigData.mWindowConfig = WindowConfig.buildWindowConfig(jSONObject);
            aiAppsConfigData.mTabBarConfig = TabBarConfig.buildTabBarConfig(jSONObject);
            aiAppsConfigData.mNetworkConfig = AiAppsCommonConfigData.NetworkConfig.buildNetworkConfig(jSONObject);
            return aiAppsConfigData;
        } catch (JSONException e) {
            return null;
        }
    }

    public static int parseColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Color.parseColor(convertSimpleColorToFull(str));
        } catch (Exception e) {
            return -1;
        }
    }

    public static String convertSimpleColorToFull(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i = 1; i < 4; i++) {
                char charAt = str.charAt(i);
                sb.append(charAt).append(charAt);
            }
            return sb.toString();
        }
        return str;
    }

    public String getFirstPageUrl() {
        if (hasTabItemInfo()) {
            return this.mTabBarConfig.mTabItems.get(0).mPagePath;
        }
        if (hasPageInfo()) {
            return this.mPageConfig.mPages.get(0);
        }
        return "";
    }

    public boolean hasPageInfo() {
        return (this.mPageConfig == null || this.mPageConfig.mPages == null || this.mPageConfig.mPages.isEmpty()) ? false : true;
    }

    public boolean hasSubPackageInfo() {
        return (this.mSubPackageList == null || this.mSubPackageList.mPackageList == null || this.mSubPackageList.mSubPackagesPagesMap == null) ? false : true;
    }

    public boolean hasTabItemInfo() {
        return this.mTabBarConfig != null && this.mTabBarConfig.isTabItemsValid();
    }

    public boolean isInPageUrl(String str) {
        return (hasPageInfo() && this.mPageConfig.containsPage(str)) || (hasSubPackageInfo() && this.mSubPackageList.mSubPackagesPagesMap.containsKey(str));
    }

    public boolean isInTabUrl(String str) {
        return this.mTabBarConfig != null && this.mTabBarConfig.isInTabItemPath(str);
    }

    /* loaded from: classes2.dex */
    public static class PageConfig {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static PageConfig buildPageConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return createNullObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(AiAppsConfigData.JSON_PAGES_KEY);
            if (optJSONArray == null) {
                return createNullObject();
            }
            PageConfig pageConfig = new PageConfig();
            pageConfig.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                pageConfig.mPages.add(optJSONArray.optString(i));
            }
            return pageConfig;
        }

        public boolean containsPage(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static PageConfig createNullObject() {
            PageConfig pageConfig = new PageConfig();
            pageConfig.mPages = new ArrayList<>();
            return pageConfig;
        }
    }

    /* loaded from: classes2.dex */
    public static class TabBarConfig {
        private static final String JSON_BACKGROUND_COLOR_KEY = "backgroundColor";
        private static final String JSON_BORDER_STYLE_KEY = "borderStyle";
        private static final String JSON_COLOR_KEY = "color";
        private static final String JSON_SELECTED_COLOR_KEY = "selectedColor";
        private static final String JSON_TAB_ITEMS_KEY = "list";
        private static final int MAX_ITEMS_NUM = 5;
        private static final int MIN_ITEMS_NUM = 2;
        public int mBackgroundColor;
        public int mBorderStyle;
        public int mColor;
        public int mSelectedColor;
        public ArrayList<TabItem> mTabItems;

        /* JADX INFO: Access modifiers changed from: private */
        public static TabBarConfig buildTabBarConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return createNullObject();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(AiAppsConfigData.JSON_TABBAR_KEY);
            if (optJSONObject == null) {
                return createNullObject();
            }
            TabBarConfig tabBarConfig = new TabBarConfig();
            tabBarConfig.mColor = AiAppsConfigData.parseColor(optJSONObject.optString(JSON_COLOR_KEY, AiAppsConfigData.GRAY_TEXT_STYLE));
            tabBarConfig.mSelectedColor = AiAppsConfigData.parseColor(optJSONObject.optString(JSON_SELECTED_COLOR_KEY, AiAppsConfigData.BLACK_TEXT_STYLE));
            tabBarConfig.mBorderStyle = AiAppsConfigData.parseColor(optJSONObject.optString(JSON_BORDER_STYLE_KEY, AiAppsConfigData.BLACK_TEXT_STYLE));
            tabBarConfig.mBackgroundColor = AiAppsConfigData.parseColor(optJSONObject.optString(JSON_BACKGROUND_COLOR_KEY, AiAppsConfigData.WHITE_TEXT_STYLE));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                tabBarConfig.mTabItems = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    tabBarConfig.mTabItems.add(TabItem.buildTabItem(optJSONArray.optJSONObject(i)));
                }
                return tabBarConfig;
            }
            return tabBarConfig;
        }

        public boolean isTabItemsValid() {
            return this.mTabItems != null && this.mTabItems.size() >= 2;
        }

        public boolean isInTabItemPath(String str) {
            if (this.mTabItems == null) {
                return false;
            }
            for (int i = 0; i < this.mTabItems.size(); i++) {
                if (TextUtils.equals(this.mTabItems.get(i).mPagePath, str)) {
                    return true;
                }
            }
            return false;
        }

        private static TabBarConfig createNullObject() {
            TabBarConfig tabBarConfig = new TabBarConfig();
            tabBarConfig.mTabItems = new ArrayList<>();
            return tabBarConfig;
        }
    }

    /* loaded from: classes2.dex */
    public static class TabItem {
        private static final String JSON_ICON_PATH_KEY = "iconPath";
        private static final String JSON_PAGE_PATH_KEY = "pagePath";
        private static final String JSON_SELECTED_ICON_KEY = "selectedIconPath";
        private static final String JSON_TEXT_KEY = "text";
        public String mIconPath;
        public String mPagePath;
        public String mSelectedIconPath;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static TabItem buildTabItem(JSONObject jSONObject) {
            if (jSONObject == null) {
                return createNullObject();
            }
            TabItem tabItem = new TabItem();
            tabItem.mPagePath = jSONObject.optString(JSON_PAGE_PATH_KEY);
            tabItem.mIconPath = jSONObject.optString(JSON_ICON_PATH_KEY);
            tabItem.mSelectedIconPath = jSONObject.optString(JSON_SELECTED_ICON_KEY);
            tabItem.mText = jSONObject.optString("text");
            return tabItem;
        }

        private static TabItem createNullObject() {
            return new TabItem();
        }
    }

    /* loaded from: classes2.dex */
    public static class SubPackageList {
        private static final String JSON_SUB_PACKAGES_KEY = "subPackages";
        public List<SubPackage> mPackageList;
        public HashMap<String, Boolean> mSubPackagesExistMap;
        public HashMap<String, String> mSubPackagesPagesMap;

        /* JADX INFO: Access modifiers changed from: private */
        public static SubPackageList buildSubPackageConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return createNullObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(JSON_SUB_PACKAGES_KEY);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return createNullObject();
            }
            SubPackageList subPackageList = new SubPackageList();
            subPackageList.mPackageList = new ArrayList();
            subPackageList.mSubPackagesPagesMap = new HashMap<>();
            subPackageList.mSubPackagesExistMap = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    subPackageList.mPackageList.add(SubPackage.buildSubPackage(optJSONObject, subPackageList.mSubPackagesPagesMap));
                }
            }
            return subPackageList;
        }

        private static SubPackageList createNullObject() {
            SubPackageList subPackageList = new SubPackageList();
            subPackageList.mPackageList = new ArrayList();
            subPackageList.mSubPackagesPagesMap = new HashMap<>();
            subPackageList.mSubPackagesExistMap = new HashMap<>();
            return subPackageList;
        }
    }

    /* loaded from: classes2.dex */
    public static class SubPackage {
        private static final String JSON_SUB_PACKAGES_PAGES = "pages";
        private static final String JSON_SUB_PACKAGES_ROOT = "root";
        private static final String PATH_SEPARATOR = File.separator;
        public List<String> mPages;
        public String mRoot;

        /* JADX INFO: Access modifiers changed from: private */
        public static SubPackage buildSubPackage(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return createNullObject();
            }
            SubPackage subPackage = new SubPackage();
            subPackage.mRoot = jSONObject.optString(JSON_SUB_PACKAGES_ROOT);
            JSONArray optJSONArray = jSONObject.optJSONArray(JSON_SUB_PACKAGES_PAGES);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                subPackage.mPages = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    subPackage.mPages.add(optString);
                    if (!TextUtils.isEmpty(subPackage.mRoot) && !TextUtils.isEmpty(optString)) {
                        if (subPackage.mRoot.endsWith(PATH_SEPARATOR) || optString.startsWith(PATH_SEPARATOR)) {
                            str = subPackage.mRoot + optString;
                        } else {
                            str = subPackage.mRoot + PATH_SEPARATOR + optString;
                        }
                        hashMap.put(str, subPackage.mRoot);
                    }
                }
            }
            return subPackage;
        }

        private static SubPackage createNullObject() {
            SubPackage subPackage = new SubPackage();
            subPackage.mPages = new ArrayList();
            return subPackage;
        }
    }

    /* loaded from: classes2.dex */
    public static class SubPackagesPath {
        private static final String JSON_SUB_PACKAGES_PATH = "_sub_swan";
        public HashMap<String, String> mSubPackagesPathMap;

        /* JADX INFO: Access modifiers changed from: private */
        public static SubPackagesPath buildSubPackagesPathMap(JSONObject jSONObject, SubPackageList subPackageList) {
            if (jSONObject == null || subPackageList == null || subPackageList.mPackageList == null || subPackageList.mPackageList.size() <= 0) {
                return createNullObject();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_SUB_PACKAGES_PATH);
            if (optJSONObject == null) {
                return createNullObject();
            }
            SubPackagesPath subPackagesPath = new SubPackagesPath();
            subPackagesPath.mSubPackagesPathMap = new HashMap<>();
            for (SubPackage subPackage : subPackageList.mPackageList) {
                if (subPackage != null && !TextUtils.isEmpty(subPackage.mRoot)) {
                    subPackagesPath.mSubPackagesPathMap.put(subPackage.mRoot, optJSONObject.optString(subPackage.mRoot));
                }
            }
            return subPackagesPath;
        }

        private static SubPackagesPath createNullObject() {
            SubPackagesPath subPackagesPath = new SubPackagesPath();
            subPackagesPath.mSubPackagesPathMap = new HashMap<>();
            return subPackagesPath;
        }
    }
}

package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PagesRoute {
    public static final int RESULT_CODE_APS_KEY_EMPTY = 2112;
    public static final int RESULT_CODE_CLIENT_MESSAGER_NULL = 2113;
    public static final int RESULT_CODE_PACKAGE_NAME_EMPTY = 2111;
    public static final int RESULT_CODE_PAGE_NAME_EMPTY = 2110;
    private static PagesRoute sInstance;
    private HashMap<String, CheckPagesCallback> mCheckPagesResultHashMap = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface CheckPagesCallback {
        void failed(int i);

        void success(String str);
    }

    private PagesRoute() {
    }

    public static PagesRoute getInstance() {
        if (sInstance == null) {
            synchronized (PagesRoute.class) {
                if (sInstance == null) {
                    sInstance = new PagesRoute();
                }
            }
        }
        return sInstance;
    }

    public void checkPages(AiApp aiApp, String str, String str2, CheckPagesCallback checkPagesCallback) {
        if (checkPagesCallback != null) {
            if (aiApp == null || TextUtils.isEmpty(str)) {
                checkPagesCallback.failed(RESULT_CODE_PAGE_NAME_EMPTY);
            } else if (aiApp.isPagesInMainPackage(str)) {
                checkPagesCallback.success(str2);
            } else {
                String packageName = aiApp.getPackageName(str);
                if (TextUtils.isEmpty(packageName)) {
                    checkPagesCallback.failed(RESULT_CODE_PACKAGE_NAME_EMPTY);
                } else if (aiApp.isSubPackageExist(packageName)) {
                    checkPagesCallback.success(str2);
                } else {
                    String aPSDownloadKey = aiApp.getAPSDownloadKey(packageName);
                    if (TextUtils.isEmpty(aPSDownloadKey)) {
                        checkPagesCallback.failed(RESULT_CODE_APS_KEY_EMPTY);
                        return;
                    }
                    AiAppsMessengerClient msgClient = aiApp.getMsgClient();
                    if (msgClient != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String callbackMapKey = getCallbackMapKey(checkPagesCallback);
                        subPackageAPSInfo.mAppId = aiApp.id;
                        subPackageAPSInfo.mAppVersion = aiApp.getVersion();
                        subPackageAPSInfo.mKey = aPSDownloadKey;
                        subPackageAPSInfo.mAppRootPath = AiAppsController.getInstance().getBaseUrl();
                        subPackageAPSInfo.mSubPackageName = packageName;
                        subPackageAPSInfo.mWebViewId = str2;
                        subPackageAPSInfo.mCallbackKey = callbackMapKey;
                        msgClient.sendMessage(6, subPackageAPSInfo);
                        this.mCheckPagesResultHashMap.put(callbackMapKey, checkPagesCallback);
                        return;
                    }
                    checkPagesCallback.failed(RESULT_CODE_CLIENT_MESSAGER_NULL);
                }
            }
        }
    }

    public void downloadSubPackage(AiAppsMessengerClient aiAppsMessengerClient, String str, String str2, String str3, String str4, String str5, String str6, CheckPagesCallback checkPagesCallback) {
        if (checkPagesCallback != null) {
            if (aiAppsMessengerClient != null) {
                SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                String callbackMapKey = getCallbackMapKey(checkPagesCallback);
                subPackageAPSInfo.mAppId = str;
                subPackageAPSInfo.mAppVersion = str2;
                subPackageAPSInfo.mKey = str4;
                subPackageAPSInfo.mAppRootPath = str5;
                subPackageAPSInfo.mSubPackageName = str3;
                subPackageAPSInfo.mWebViewId = str6;
                subPackageAPSInfo.mCallbackKey = callbackMapKey;
                aiAppsMessengerClient.sendMessage(6, subPackageAPSInfo);
                this.mCheckPagesResultHashMap.put(callbackMapKey, checkPagesCallback);
                return;
            }
            checkPagesCallback.failed(RESULT_CODE_CLIENT_MESSAGER_NULL);
        }
    }

    public void onSubPackageDownloadSuccess(Bundle bundle) {
        CheckPagesCallback checkPagesCallback;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY);
            if (subPackageAPSInfo != null && (checkPagesCallback = this.mCheckPagesResultHashMap.get(subPackageAPSInfo.mCallbackKey)) != null) {
                AiApp aiApp = AiApp.get();
                if (aiApp != null) {
                    aiApp.updateSubPackageMemaryCache(subPackageAPSInfo.mSubPackageName, true);
                }
                checkPagesCallback.success(subPackageAPSInfo.mWebViewId);
                this.mCheckPagesResultHashMap.remove(subPackageAPSInfo.mCallbackKey);
            }
        }
    }

    public void onSubPackageDownLoadFailed(Bundle bundle) {
        CheckPagesCallback checkPagesCallback;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY);
            if (subPackageAPSInfo != null && (checkPagesCallback = this.mCheckPagesResultHashMap.get(subPackageAPSInfo.mCallbackKey)) != null) {
                checkPagesCallback.failed(subPackageAPSInfo.mResultCode);
                this.mCheckPagesResultHashMap.remove(subPackageAPSInfo.mCallbackKey);
            }
        }
    }

    public static boolean needPreLoadSubPackage(AiAppsLaunchInfo aiAppsLaunchInfo, AiAppsBundleHelper.AiAppsLoadInfo aiAppsLoadInfo) {
        if (aiAppsLoadInfo == null || aiAppsLaunchInfo == null || TextUtils.isEmpty(aiAppsLaunchInfo.mPage)) {
            return false;
        }
        String delAllParamsFromUrl = AiAppsUrlUtils.delAllParamsFromUrl(aiAppsLaunchInfo.mPage);
        AiAppsConfigData aiAppsConfigData = aiAppsLoadInfo.mConfigData;
        if (aiAppsConfigData.mPageConfig.containsPage(delAllParamsFromUrl)) {
            return false;
        }
        String str = aiAppsConfigData.mSubPackageList.mSubPackagesPagesMap.get(delAllParamsFromUrl);
        return (TextUtils.isEmpty(str) || SubPackageInfoHelper.getInstance().isSubPackageExist(aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mVersion, str)) ? false : true;
    }

    private String getCallbackMapKey(CheckPagesCallback checkPagesCallback) {
        return checkPagesCallback != null ? checkPagesCallback.toString() : "";
    }
}

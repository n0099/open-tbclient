package com.baidu.searchbox.ng.ai.apps.prepose.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchType;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.util.data.ErrorCodePicker;
/* loaded from: classes2.dex */
public final class AiAppsDebugUtil {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsDebugUtil";
    public static final String WEB_SAFE_DEBUG_KEY = "aiapps_websafe_debug_key";
    public static final String WEB_SAFE_TEST_KEY = "aiapps_websafe_test_key";

    public static boolean getWebSafeDebug() {
        return getBoolean(WEB_SAFE_DEBUG_KEY, true);
    }

    public static void setWebSafeDebug(boolean z) {
        setBoolean(WEB_SAFE_DEBUG_KEY, z);
    }

    public static boolean getWebSafeTestDebug() {
        return getBoolean(WEB_SAFE_TEST_KEY, false);
    }

    public static void setWebSafeTestDebug(boolean z) {
        setBoolean(WEB_SAFE_TEST_KEY, z);
    }

    private static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    private static boolean getBoolean(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(str, z);
    }

    private static boolean isDebug(AiAppsLaunchParams aiAppsLaunchParams) {
        return isRemoteDebug(aiAppsLaunchParams.mRemoteDebug);
    }

    public static boolean isDebug(AiAppsLaunchInfo aiAppsLaunchInfo) {
        return isRemoteDebug(aiAppsLaunchInfo.mRemoteDebug);
    }

    public static boolean isRemoteDebug(String str) {
        return !TextUtils.isEmpty(str) || RemoteDebugger.isRemoteDebug();
    }

    public static AiAppsBundleHelper.AiAppsLoadInfo debugForLoadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo, ErrorCodePicker errorCodePicker) {
        if (isRemoteDebug(aiAppsLaunchInfo.mRemoteDebug)) {
            return AiAppsBundleHelper.RemoteDebugBundleHelper.debugForLoadAndRunAiApps(aiAppsLaunchInfo);
        }
        return null;
    }

    public static boolean launchAiAppIfDebug(Context context, AiAppsLaunchParams aiAppsLaunchParams) {
        if (isDebug(aiAppsLaunchParams)) {
            AiAppsLaunchInfo buildMockObject = buildMockObject();
            aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_START_TIMESTAMP, System.currentTimeMillis());
            buildMockObject.mAppId = aiAppsLaunchParams.mAppId;
            buildMockObject.mLaunchFrom = aiAppsLaunchParams.mFrom;
            buildMockObject.mPage = aiAppsLaunchParams.mPage;
            buildMockObject.mIsDebug = aiAppsLaunchParams.mIsDebug;
            buildMockObject.mClickId = aiAppsLaunchParams.mClickId;
            buildMockObject.mExtraData = aiAppsLaunchParams.mExtraData;
            buildMockObject.mLaunchScheme = aiAppsLaunchParams.mLaunchScheme;
            buildMockObject.mNotInHistory = aiAppsLaunchParams.mNotInHistory;
            buildMockObject.mSwanCoreVersion = aiAppsLaunchParams.mSwanCoreVersion;
            buildMockObject.mTargetSwanVersion = aiAppsLaunchParams.mTargetSwanVersion;
            buildMockObject.mRemoteDebug = aiAppsLaunchParams.mRemoteDebug;
            buildMockObject.mVersion = "0";
            AiAppsLauncherActivity.startAiApps(context, buildMockObject);
            return true;
        }
        return false;
    }

    public static String getDebugUnzipOutputFolder(AiAppsLaunchInfo aiAppsLaunchInfo) {
        return isRemoteDebug(aiAppsLaunchInfo.mRemoteDebug) ? AiAppsBundleHelper.RemoteDebugBundleHelper.getDebugUnzipFolder().getPath() : "";
    }

    public static AiAppsLaunchInfo buildMockObject() {
        AiAppsLaunchInfo aiAppsLaunchInfo = new AiAppsLaunchInfo();
        aiAppsLaunchInfo.mAppTitle = "小程序测试";
        aiAppsLaunchInfo.mAppId = "10985873";
        aiAppsLaunchInfo.mNavigateBarColor = Color.parseColor("#FF308EF0");
        aiAppsLaunchInfo.mAppIcon = BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.icon);
        aiAppsLaunchInfo.mLaunchFrom = AiAppsLaunchType.LAUNCH_FROM_SHORTCUT;
        aiAppsLaunchInfo.mDescription = "小程序简介";
        aiAppsLaunchInfo.mServiceCategory = "测试服务类目";
        aiAppsLaunchInfo.mSubjectInfo = "测试主体信息";
        aiAppsLaunchInfo.mAppKey = "FLGQGZKwhQpXuUeRNGoVBuLXTeCrOmpC";
        aiAppsLaunchInfo.mVersion = "1.0";
        aiAppsLaunchInfo.mAppIconUrl = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return aiAppsLaunchInfo;
    }
}

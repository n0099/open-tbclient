package com.baidu.searchbox.ng.ai.apps.launch.model;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.update.data.AiAppsCloudConfigData;
import com.baidu.searchbox.ng.ai.apps.util.AiAppIntentUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes2.dex */
public class AiAppsLaunchParams {
    public static final String AIAPPS_CROSS_DOMAIN_SPKEY = "aiapps_cross_domain";
    public static final String CROSS_DOMAIN_ACTION = "crossdomain_exception_stack";
    private static final boolean DEBUG = false;
    private static final String PARAMS_KEY_APP_ID = "mAppId";
    private static final String PARAMS_KEY_EXTRA_DATA = "mExtraData";
    private static final String PARAMS_KEY_FROM = "mFrom";
    private static final String PARAMS_KEY_IS_DEBUG = "mIsDebug";
    private static final String PARAMS_KEY_LAUNCH_SCHEME = "launchScheme";
    private static final String PARAMS_KEY_NOT_IN_HISTORY = "notInHistory";
    private static final String PARAMS_KEY_PAGE = "mPage";
    private static final String PARAMS_KEY_SWAN_CORE_VERSION = "swanCoreVersion";
    private static final String PARAMS_KEY_TARGET_SWAN_VERSION = "targetSwanVersion";
    private static final String TAG = "AiAppsLaunchParams";
    public static final String VALUE_ZERO = "0";
    public String mAppId;
    public String mClickId;
    public Bundle mExtraData;
    public String mFrom;
    public boolean mIsDebug;
    public String mLaunchScheme;
    public String mNotInHistory;
    public String mPage;
    public String mRemoteDebug;
    public SwanCoreVersion mSwanCoreVersion;
    public String mTargetSwanVersion;

    public AiAppsLaunchParams() {
    }

    public AiAppsLaunchParams(String str, String str2, String str3, String str4) {
        this.mAppId = str;
        this.mFrom = str2;
        this.mPage = str3;
        this.mClickId = str4;
    }

    public void putExtraData(String str, String str2) {
        requireExtraData().putString(str, str2);
    }

    public Bundle requireExtraData() {
        if (this.mExtraData == null) {
            this.mExtraData = new Bundle();
        }
        return this.mExtraData;
    }

    public static Intent createLaunchParamsIntent(Context context, AiAppsLaunchParams aiAppsLaunchParams) {
        if (context == null || aiAppsLaunchParams == null) {
            return null;
        }
        addCloudConfigDataToExtra(aiAppsLaunchParams);
        Intent intent = new Intent();
        intent.setAction(AiAppsLauncherActivity.AIAPPS_LAUNCH_ACTION);
        intent.setComponent(new ComponentName(context, AiAppsLauncherActivity.class));
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        intent.putExtra(PARAMS_KEY_APP_ID, aiAppsLaunchParams.mAppId);
        intent.putExtra(PARAMS_KEY_FROM, aiAppsLaunchParams.mFrom);
        intent.putExtra(PARAMS_KEY_PAGE, aiAppsLaunchParams.mPage);
        intent.putExtra(PARAMS_KEY_IS_DEBUG, aiAppsLaunchParams.mIsDebug);
        intent.putExtra(PARAMS_KEY_EXTRA_DATA, aiAppsLaunchParams.mExtraData);
        intent.putExtra(PARAMS_KEY_NOT_IN_HISTORY, aiAppsLaunchParams.mNotInHistory);
        if (!TextUtils.isEmpty(aiAppsLaunchParams.mLaunchScheme)) {
            intent.putExtra(PARAMS_KEY_LAUNCH_SCHEME, aiAppsLaunchParams.mLaunchScheme);
        }
        if (aiAppsLaunchParams.mSwanCoreVersion != null) {
            intent.putExtra(PARAMS_KEY_SWAN_CORE_VERSION, aiAppsLaunchParams.mSwanCoreVersion);
        }
        if (!TextUtils.isEmpty(aiAppsLaunchParams.mTargetSwanVersion)) {
            intent.putExtra(PARAMS_KEY_TARGET_SWAN_VERSION, aiAppsLaunchParams.mTargetSwanVersion);
            return intent;
        }
        return intent;
    }

    public static AiAppsLaunchParams createFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        AiAppsLaunchParams aiAppsLaunchParams = new AiAppsLaunchParams();
        aiAppsLaunchParams.mAppId = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_APP_ID);
        aiAppsLaunchParams.mFrom = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_FROM);
        aiAppsLaunchParams.mPage = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_PAGE);
        aiAppsLaunchParams.mIsDebug = AiAppIntentUtils.safeGetBooleanExtra(intent, PARAMS_KEY_IS_DEBUG, false);
        aiAppsLaunchParams.mExtraData = AiAppIntentUtils.safeGetBundleExtra(intent, PARAMS_KEY_EXTRA_DATA);
        aiAppsLaunchParams.mLaunchScheme = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_LAUNCH_SCHEME);
        aiAppsLaunchParams.mNotInHistory = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_NOT_IN_HISTORY);
        aiAppsLaunchParams.mSwanCoreVersion = (SwanCoreVersion) AiAppIntentUtils.safeGetParcelableExtra(intent, PARAMS_KEY_SWAN_CORE_VERSION);
        aiAppsLaunchParams.mTargetSwanVersion = AiAppIntentUtils.safeGetStringExtra(intent, PARAMS_KEY_TARGET_SWAN_VERSION);
        aiAppsLaunchParams.mRemoteDebug = AiAppIntentUtils.safeGetStringExtra(intent, RemoteDebugger.EXTRA_REMOTE_DEBUG_URL);
        return aiAppsLaunchParams;
    }

    public String toString() {
        return "AiAppsLaunchParams{mAppId='" + this.mAppId + "', mFrom='" + this.mFrom + "', mPage='" + this.mPage + "', mIsDebug=" + this.mIsDebug + ", mExtraData=" + this.mExtraData + ", mClickId='" + this.mClickId + "', mLaunchScheme='" + this.mLaunchScheme + "', mNotInHistory='" + this.mNotInHistory + "'}";
    }

    public static String getDefaultScheme(String str, String str2) {
        return String.format(UnitedSchemeConstants.DEFAULT_SCHEME, str, str2);
    }

    private static void addCloudConfigDataToExtra(AiAppsLaunchParams aiAppsLaunchParams) {
        aiAppsLaunchParams.requireExtraData().putString(AiAppsCloudConfigData.INTENT_KEY_CROSS_DOMAIN, AiAppsSpHelper.getsInstance().getString("aiapps_cross_domain", "0"));
    }
}

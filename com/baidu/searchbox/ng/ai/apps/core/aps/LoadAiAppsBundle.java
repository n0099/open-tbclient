package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbInfo;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoadAiAppsBundle {
    private static final boolean DEBUG = false;
    private static final String TAG = "loadAiAppsBundle";

    public static void loadAiAppsBundle(Context context, AiAppsLaunchParams aiAppsLaunchParams) {
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mAppId = aiAppsLaunchParams.mAppId;
        aiAppsUBCEvent.mSource = aiAppsLaunchParams.mFrom;
        aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_LAUNCH;
        String str = aiAppsLaunchParams.mLaunchScheme;
        if (str != null) {
            String queryParameter = Uri.parse(str).getQueryParameter(AiAppsLaunchInfo.SCHEMA_BAIDUBOXAPP_KEY);
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString("token"), AiAppsUBCStatistic.EXT_TOKEN_VALUE)) {
                        aiAppsUBCEvent.mergeExtInfo(optJSONObject);
                    }
                } catch (JSONException e) {
                }
            }
        }
        AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
        aiAppsLaunchParams.requireExtraData().putLong(AiAppsUBCStatistic.EXT_KEY_LAUNCH_FLAG, System.currentTimeMillis());
        aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_START_TIMESTAMP, System.currentTimeMillis());
        AiAppsDbInfo queryAiAppsItem = AiAppsDbControl.getInstance(context).queryAiAppsItem(aiAppsLaunchParams.mAppId);
        aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_QUERY_DB_TIMESTAMP, System.currentTimeMillis());
        if (shouldCompleteAps(queryAiAppsItem)) {
            LaunchAiApps.launchAiAppsByAps(context, aiAppsLaunchParams, APSFlowControlFlag.getCompleteFlowFlag());
            return;
        }
        LaunchAiApps.launchAiAppsByLocal(context, aiAppsLaunchParams, queryAiAppsItem, true);
        LaunchAiApps.launchAiAppsByAps(context, aiAppsLaunchParams, APSFlowControlFlag.getAsynDownloadFlowFlag());
    }

    private static boolean shouldCompleteAps(@Nullable AiAppsDbInfo aiAppsDbInfo) {
        return (hasLocalAiAppInfo(aiAppsDbInfo) && aiAppsDbInfo.errorCode == 0 && !AiAppsDbInfo.hashApsPendingErrcode(aiAppsDbInfo)) ? false : true;
    }

    private static boolean hasLocalAiAppInfo(@NonNull Context context, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return hasLocalAiAppInfo(AiAppsDbControl.getInstance(context).queryAiAppsItem(str));
    }

    private static boolean hasLocalAiAppInfo(@Nullable AiAppsDbInfo aiAppsDbInfo) {
        if (aiAppsDbInfo == null || TextUtils.isEmpty(aiAppsDbInfo.appId) || TextUtils.isEmpty(aiAppsDbInfo.version)) {
            return false;
        }
        File unzipFolder = AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(aiAppsDbInfo.appId, aiAppsDbInfo.version);
        if (unzipFolder == null || !unzipFolder.exists()) {
            File bundleFile = AiAppsBundleHelper.ReleaseBundleHelper.getBundleFile(aiAppsDbInfo.appId, false);
            return bundleFile != null && bundleFile.exists();
        }
        return true;
    }
}

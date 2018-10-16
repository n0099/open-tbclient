package com.baidu.searchbox.ng.ai.apps.preload;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsProcessInfo;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.swancore.callback.OnSwanCoreUpdateCallback;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreUpdater;
import com.baidu.searchbox.ng.ai.apps.update.data.AiAppsCloudConfigData;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
/* loaded from: classes2.dex */
public final class AiAppsPreloadManager {
    public static final String AIAPPS_CROSS_DOMAIN_SPKEY = "aiapps_cross_domain";
    private static final boolean DEBUG = false;
    public static final String EXTRA_KEY_PRELOAD_SWITCH = "bundle_key_preload_switch";
    public static final String EXTRA_KEY_SWAN_CORE = "bundle_key_swan_core";
    private static final String PRELOAD_ACTION_NAME = "com.baidu.searchbox.action.aiapps.preload";
    private static final String TAG = "AiAppsPreloadManager";
    public static final String USED_AIAPPS = "used_aiapps";
    public static final String VALUE_ZERO = "0";

    public static void preloadAiAppsZygoteProcess(final Context context) {
        final int preloadABSwitch = AiAppsRuntime.getBlinkAbTestRuntime().getPreloadABSwitch();
        if (!AiAppsRuntime.getBlinkAbTestRuntime().isDisablePreload(preloadABSwitch)) {
            if (AiAppsRuntime.getBlinkAbTestRuntime().isEnableDelayPreload(preloadABSwitch)) {
                AiAppsUtils.postOnUi(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiAppsPreloadManager.sendPreloadBroadcast(context, 0);
                    }
                }, 15000L);
            } else {
                sendPreloadBroadcast(context, 0);
            }
        }
    }

    public static void sendPreloadBroadcast(final Context context, final int i) {
        if (AiAppsProcessInfo.checkProcessId(i)) {
            PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync(new OnSwanCoreUpdateCallback() { // from class: com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager.2
                @Override // com.baidu.searchbox.ng.ai.apps.swancore.callback.OnSwanCoreUpdateCallback
                public void onUpdateFinished() {
                    Intent intent = new Intent(context, AiAppsUtils.getAiAppsComponentClazz(AiAppsPreloadReceiver.class, i));
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.putExtra(AiAppsPreloadManager.EXTRA_KEY_SWAN_CORE, AiAppsSwanCoreManager.getSwanCoreVersion());
                    intent.putExtra(AiAppsCloudConfigData.INTENT_KEY_CROSS_DOMAIN, AiAppsSpHelper.getsInstance().getString("aiapps_cross_domain", "0"));
                    intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                    context.sendBroadcast(intent);
                }
            });
        }
    }
}

package com.baidu.searchbox.ng.ai.apps.preload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
/* loaded from: classes2.dex */
public class AiAppsPreloadReceiver extends BroadcastReceiver {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsPreloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AiAppsController.getInstance().setCloudConfigData(intent);
        AiAppsController.getInstance().preloadAiAppsRuntime(intent);
    }
}

package com.baidu.searchbox.ng.ai.apps.impl.map.aps;

import android.content.Context;
import com.baidu.b.a.b;
import com.baidu.b.a.e.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfo;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfoWrapper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AiAppsPreloadMapLibHelper {
    private static final String MODULE_TAG = "APS_MAP_PRE_DOWNLOAD";

    public static void preloadAiAppsMapLib() {
        BdMapLibApsInfo bdMapLibApsInfo = new BdMapLibApsInfo();
        bdMapLibApsInfo.mIsMainProcess = ProcessUtils.isMainProcess();
        processLoadMapLibMessage(BdMapLibApsInfoWrapper.wrapBdMapLibApsInfo(bdMapLibApsInfo, null));
    }

    public static void processLoadMapLibMessage(BdMapLibApsInfoWrapper bdMapLibApsInfoWrapper) {
        if (bdMapLibApsInfoWrapper != null && bdMapLibApsInfoWrapper.validateSuccess()) {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AiAppsPreloadMapLibAPSCallback(appContext, bdMapLibApsInfoWrapper));
            b.init(appContext, ProcessUtils.isMainProcess());
            a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
            a.c(arrayList, true);
            AiAppsLog.d(MODULE_TAG, "processLoadMapLibMessage " + bdMapLibApsInfoWrapper);
        }
    }

    public static void onDownloadSuccess(BdMapLibApsInfoWrapper bdMapLibApsInfoWrapper) {
        if (bdMapLibApsInfoWrapper != null && bdMapLibApsInfoWrapper.validateSuccess()) {
            bdMapLibApsInfoWrapper.mMapInfo.mResultCode = 2001;
            if (bdMapLibApsInfoWrapper.mMapCallback != null) {
                bdMapLibApsInfoWrapper.mMapCallback.onSuccess();
            }
            AiAppsLog.d(MODULE_TAG, "onDownloadSuccess " + bdMapLibApsInfoWrapper);
        }
    }

    public static void onDownloadFailed(BdMapLibApsInfoWrapper bdMapLibApsInfoWrapper, int i) {
        if (bdMapLibApsInfoWrapper != null && bdMapLibApsInfoWrapper.validateSuccess()) {
            bdMapLibApsInfoWrapper.mMapInfo.mResultCode = i;
            if (bdMapLibApsInfoWrapper.mMapCallback != null) {
                bdMapLibApsInfoWrapper.mMapCallback.onFailure();
            }
            AiAppsLog.d(MODULE_TAG, "onDownloadFailed " + bdMapLibApsInfoWrapper.mMapInfo);
        }
    }
}

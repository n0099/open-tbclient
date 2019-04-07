package com.baidu.swan.games.subpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo, int i) {
        if (swanGameSubPackageAPSInfo != null) {
            if (b(swanGameSubPackageAPSInfo)) {
                swanGameSubPackageAPSInfo.bfv = i;
                a(swanGameSubPackageAPSInfo);
                return;
            }
            swanGameSubPackageAPSInfo.resultCode = 2101;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", swanGameSubPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(swanGameSubPackageAPSInfo.bfv, 111, bundle);
        }
    }

    private static void a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        Context appContext = AppRuntime.getAppContext();
        com.baidu.b.a.d.a.a.putParams(swanGameSubPackageAPSInfo.key, swanGameSubPackageAPSInfo.appVersion);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.games.subpackage.aps.a(appContext, swanGameSubPackageAPSInfo));
        com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CT().Dr());
        com.baidu.b.a.c.a.c(arrayList, true);
    }

    private static boolean b(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        if (DEBUG && swanGameSubPackageAPSInfo != null) {
            Log.e("GetGamesSubHelper", swanGameSubPackageAPSInfo.toString());
        }
        return (swanGameSubPackageAPSInfo == null || TextUtils.isEmpty(swanGameSubPackageAPSInfo.appVersion) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.key) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.bfw) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.bfx) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.bfz)) ? false : true;
    }
}

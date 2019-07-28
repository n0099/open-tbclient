package com.baidu.swan.games.subpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.games.i.a;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo, int i) {
        if (swanGameSubPackageAPSInfo != null) {
            if (f(swanGameSubPackageAPSInfo)) {
                swanGameSubPackageAPSInfo.blu = i;
                c(swanGameSubPackageAPSInfo);
                return;
            }
            swanGameSubPackageAPSInfo.resultCode = 2101;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", swanGameSubPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(swanGameSubPackageAPSInfo.blu, 111, bundle);
        }
    }

    private static void c(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        if (com.baidu.swan.apps.core.pms.a.co(1)) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.b.d.d(swanGameSubPackageAPSInfo.appId, Integer.valueOf(swanGameSubPackageAPSInfo.appVersion).intValue(), swanGameSubPackageAPSInfo.key, 1), new com.baidu.swan.games.subpackage.b.a(swanGameSubPackageAPSInfo));
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        com.baidu.b.a.d.a.a.putParams(swanGameSubPackageAPSInfo.key, swanGameSubPackageAPSInfo.appVersion);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.games.subpackage.aps.a(appContext, swanGameSubPackageAPSInfo));
        com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.EH().Ff());
        com.baidu.b.a.c.a.b(arrayList, true);
    }

    public static void b(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo, int i) {
        if (swanGameSubPackageAPSInfo != null) {
            swanGameSubPackageAPSInfo.resultCode = i;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", swanGameSubPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(swanGameSubPackageAPSInfo.blu, 111, bundle);
        }
    }

    public static void d(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        if (swanGameSubPackageAPSInfo != null) {
            swanGameSubPackageAPSInfo.resultCode = PushConstants.BROADCAST_MESSAGE_ARRIVE;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", swanGameSubPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(swanGameSubPackageAPSInfo.blu, 112, bundle);
        }
    }

    public static void a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo, long j, long j2) {
        if (swanGameSubPackageAPSInfo != null && !TextUtils.isEmpty(swanGameSubPackageAPSInfo.bly)) {
            Bundle bundle = new Bundle();
            bundle.putLong("aigames_sub_package_bytes_read_key", j);
            bundle.putLong("aigames_sub_package_content_length_key", j2);
            bundle.putString("aigames_sub_package_callback_key", swanGameSubPackageAPSInfo.bly);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(swanGameSubPackageAPSInfo.blu, 113, bundle);
        }
    }

    public static String e(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        if (swanGameSubPackageAPSInfo == null) {
            return null;
        }
        String str = swanGameSubPackageAPSInfo.blv;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        File dF = dF(str);
        if (dF != null) {
            return dF.getPath();
        }
        return null;
    }

    public static boolean a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        return a.C0204a.a(swanGameSubPackageAPSInfo);
    }

    public static boolean a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo, String str) {
        if (swanGameSubPackageAPSInfo == null) {
            return false;
        }
        String dE = dE(swanGameSubPackageAPSInfo.key);
        String e = e(swanGameSubPackageAPSInfo);
        if (e == null || TextUtils.isEmpty(dE)) {
            if (DEBUG) {
                Log.e("GetGamesSubHelper", "ZIP文件夹或名称为空");
                return false;
            }
            return false;
        }
        if (DEBUG) {
            Log.e("GetGamesSubHelper", "准备重命名小游戏子包");
            Log.e("GetGamesSubHelper", "zipFolder:" + e);
            Log.e("GetGamesSubHelper", "zipName:" + dE);
        }
        File file = new File(e, dE);
        File file2 = new File(str);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("GetGamesSubHelper", "重命名成功");
            }
            swanGameSubPackageAPSInfo.blx = file.getAbsolutePath();
            return true;
        }
        if (DEBUG) {
            Log.i("GetGamesSubHelper", "重命名失败");
        }
        com.baidu.swan.c.a.deleteFile(file2);
        return false;
    }

    private static String dE(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encodeToString(str.getBytes(), 2) + ".aigames" : "";
    }

    private static File dF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, "aigames_sub_package_zip");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    private static boolean f(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        if (DEBUG && swanGameSubPackageAPSInfo != null) {
            Log.e("GetGamesSubHelper", swanGameSubPackageAPSInfo.toString());
        }
        return (swanGameSubPackageAPSInfo == null || TextUtils.isEmpty(swanGameSubPackageAPSInfo.appVersion) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.key) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.blv) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.blw) || TextUtils.isEmpty(swanGameSubPackageAPSInfo.bly)) ? false : true;
    }
}

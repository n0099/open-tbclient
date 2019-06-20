package com.baidu.swan.apps.core.a.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.pms.b.d.d;
import com.baidu.swan.pms.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(SubPackageAPSInfo subPackageAPSInfo, int i) {
        if (subPackageAPSInfo != null) {
            if (g(subPackageAPSInfo)) {
                subPackageAPSInfo.ayd = i;
                c(subPackageAPSInfo);
                return;
            }
            subPackageAPSInfo.mResultCode = 2101;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", subPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.ayd, 104, bundle);
        }
    }

    private static void c(SubPackageAPSInfo subPackageAPSInfo) {
        if (com.baidu.swan.apps.core.pms.a.co(0)) {
            c.a(new d(subPackageAPSInfo.mAppId, Integer.valueOf(subPackageAPSInfo.mAppVersion).intValue(), subPackageAPSInfo.mKey, 0), new com.baidu.swan.apps.core.pms.b.a(subPackageAPSInfo));
            return;
        }
        if (subPackageAPSInfo.ayi) {
            if (DEBUG) {
                Log.i("GetSubPackageHelper", "命中分包强制下载策略");
            }
            com.baidu.b.a.c.a.N(Constants.VIA_REPORT_TYPE_QQFAVORITES, subPackageAPSInfo.mKey);
        }
        Context appContext = AppRuntime.getAppContext();
        com.baidu.b.a.d.a.a.putParams(subPackageAPSInfo.mKey, subPackageAPSInfo.mAppVersion);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(appContext, subPackageAPSInfo));
        com.baidu.b.a.a.init(appContext, ProcessUtils.isMainProcess());
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.DY().Ew());
        com.baidu.b.a.c.a.b(arrayList, true);
    }

    public static void b(SubPackageAPSInfo subPackageAPSInfo, int i) {
        if (subPackageAPSInfo != null) {
            subPackageAPSInfo.mResultCode = i;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", subPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.ayd, 104, bundle);
        }
    }

    public static void d(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo != null) {
            subPackageAPSInfo.mResultCode = PushConstants.BROADCAST_MESSAGE_ARRIVE;
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", subPackageAPSInfo);
            SwanAppMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.ayd, 105, bundle);
        }
    }

    public static void a(SubPackageAPSInfo subPackageAPSInfo, String str, String str2, boolean z) {
        if (subPackageAPSInfo != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!w.b(new File(str2), str)) {
                if (DEBUG) {
                    Log.e("GetSubPackageHelper", "子包签名校验失败");
                }
                if (z) {
                    b(subPackageAPSInfo, 2104);
                }
            } else if (a(subPackageAPSInfo, str2) && f(subPackageAPSInfo)) {
                if (DEBUG) {
                    Log.e("GetSubPackageHelper", "解压成功");
                }
                com.baidu.swan.apps.database.subpackage.a.Cb().j(subPackageAPSInfo.mAppId, subPackageAPSInfo.mAppVersion, subPackageAPSInfo.ayf, subPackageAPSInfo.mKey);
                if (z) {
                    d(subPackageAPSInfo);
                }
                com.baidu.swan.apps.core.a.d.yv().a(subPackageAPSInfo);
            } else {
                if (DEBUG) {
                    Log.e("GetSubPackageHelper", "解压失败");
                }
                if (z) {
                    b(subPackageAPSInfo, 2105);
                }
            }
        }
    }

    public static String e(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return null;
        }
        String str = subPackageAPSInfo.aye;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        File dA = dA(str);
        if (dA != null) {
            return dA.getPath();
        }
        return null;
    }

    public static boolean f(SubPackageAPSInfo subPackageAPSInfo) {
        return e.f.f(subPackageAPSInfo);
    }

    public static boolean a(SubPackageAPSInfo subPackageAPSInfo, String str) {
        if (subPackageAPSInfo == null) {
            return false;
        }
        String dz = dz(subPackageAPSInfo.mKey);
        String e = e(subPackageAPSInfo);
        if (e == null || TextUtils.isEmpty(dz)) {
            if (DEBUG) {
                Log.e("GetSubPackageHelper", "ZIP文件夹或名称为空");
                return false;
            }
            return false;
        }
        if (DEBUG) {
            Log.e("GetSubPackageHelper", "准备重命名小程序子包");
            Log.e("GetSubPackageHelper", "zipFolder:" + e);
            Log.e("GetSubPackageHelper", "zipName:" + dz);
        }
        File file = new File(e, dz);
        File file2 = new File(str);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("GetSubPackageHelper", "重命名成功");
            }
            subPackageAPSInfo.ayg = file.getAbsolutePath();
            return true;
        }
        if (DEBUG) {
            Log.i("GetSubPackageHelper", "重命名失败");
        }
        com.baidu.swan.c.a.deleteFile(file2);
        return false;
    }

    private static String dz(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encodeToString(str.getBytes(), 2) + ".aiapps" : "";
    }

    private static File dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, "aiapps_sub_package_zip");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    private static boolean g(SubPackageAPSInfo subPackageAPSInfo) {
        if (DEBUG && subPackageAPSInfo != null) {
            Log.e("GetSubPackageHelper", subPackageAPSInfo.toString());
        }
        return (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.mAppVersion) || TextUtils.isEmpty(subPackageAPSInfo.mKey) || TextUtils.isEmpty(subPackageAPSInfo.aye) || TextUtils.isEmpty(subPackageAPSInfo.ayf) || TextUtils.isEmpty(subPackageAPSInfo.ayh)) ? false : true;
    }
}

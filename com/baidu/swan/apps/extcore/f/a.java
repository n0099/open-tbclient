package com.baidu.swan.apps.extcore.f;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean iX(int i) {
        return h.aNr().getBoolean(iY(i), false);
    }

    public static void z(int i, boolean z) {
        h.aNr().putBoolean(iY(i), z);
    }

    @NonNull
    private static String iY(int i) {
        return i == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset";
    }

    private static ArrayList<Long> awQ() {
        ExtensionCore auE;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (c cVar : e.aIs().aIu()) {
            SwanAppCores aIe = cVar.aIe();
            if (aIe != null && cVar.aIf() && (auE = aIe.auE()) != null && !arrayList.contains(Long.valueOf(auE.extensionCoreVersionCode))) {
                arrayList.add(Long.valueOf(auE.extensionCoreVersionCode));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void x(Bundle bundle) {
        if (bundle != null) {
            if (!ProcessUtils.isMainProcess()) {
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(18, bundle).gy(true));
                return;
            }
            String string = bundle.getString("arg_dst_folder");
            if (!TextUtils.isEmpty(string)) {
                a(new File(string), bundle.getLongArray("arg_ignore_vers"));
            }
        }
    }

    public static void a(File file, long... jArr) {
        File[] listFiles;
        if (!ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("arg_dst_folder", file.getPath());
            if (jArr != null && jArr.length > 0) {
                bundle.putLongArray("arg_ignore_vers", jArr);
            }
            x(bundle);
        } else if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            if (jArr != null) {
                for (long j : jArr) {
                    if (j > 0) {
                        arrayList.add(Long.valueOf(j));
                    }
                }
            }
            arrayList.addAll(awQ());
            if (DEBUG) {
                Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray()));
            }
            for (File file2 : file.listFiles()) {
                if (!a(file2, arrayList)) {
                    if (DEBUG) {
                        Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                    }
                    d.deleteFile(file2);
                }
            }
        }
    }

    private static boolean a(File file, List<Long> list) {
        if (list == null) {
            return false;
        }
        String name = file.getName();
        for (Long l : list) {
            if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                return true;
            }
        }
        return false;
    }

    public static long oT(@Nullable String str) {
        String[] oU = oU(str);
        if (oU == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < oU.length ? Integer.valueOf(oU[i]).intValue() : 0L);
                i++;
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    throw e;
                }
                return 0L;
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "getVersionCode versionName: " + str + " ,versionCode: " + j);
        }
        return j;
    }

    public static String ce(long j) {
        return com.baidu.swan.apps.swancore.b.cR(j);
    }

    public static boolean iZ(int i) {
        return i == 1 ? com.baidu.swan.apps.ad.a.a.aHi() : com.baidu.swan.apps.ad.a.a.aHh();
    }

    private static String[] oU(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length == 0 || split.length != 3) {
            return null;
        }
        return split;
    }
}

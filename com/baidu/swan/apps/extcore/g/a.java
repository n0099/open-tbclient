package com.baidu.swan.apps.extcore.g;

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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean eD(int i) {
        return h.adb().getBoolean(eE(i), false);
    }

    public static void q(int i, boolean z) {
        h.adb().putBoolean(eE(i), z);
    }

    @NonNull
    private static String eE(int i) {
        return i == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset";
    }

    private static ArrayList<Long> PO() {
        ExtensionCore OB;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (c cVar : e.Ze().Zg()) {
            SwanAppCores YU = cVar.YU();
            if (YU != null && cVar.YV() && (OB = YU.OB()) != null && !arrayList.contains(Long.valueOf(OB.extensionCoreVersionCode))) {
                arrayList.add(Long.valueOf(OB.extensionCoreVersionCode));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void w(Bundle bundle) {
        if (bundle != null) {
            if (!ProcessUtils.isMainProcess()) {
                com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(18, bundle).dl(true));
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
            w(bundle);
        } else if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            if (jArr != null) {
                for (long j : jArr) {
                    if (j > 0) {
                        arrayList.add(Long.valueOf(j));
                    }
                }
            }
            arrayList.addAll(PO());
            if (DEBUG) {
                Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray()));
            }
            for (File file2 : file.listFiles()) {
                if (!a(file2, arrayList)) {
                    if (DEBUG) {
                        Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                    }
                    com.baidu.swan.d.c.deleteFile(file2);
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

    public static long hB(@Nullable String str) {
        String[] hC = hC(str);
        if (hC == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < hC.length ? Integer.valueOf(hC[i]).intValue() : 0L);
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

    public static String ad(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == hB(sb.toString())));
        }
        return sb.toString();
    }

    public static boolean eF(int i) {
        return i == 1 ? com.baidu.swan.apps.ah.a.a.Ye() : com.baidu.swan.apps.ah.a.a.Yd();
    }

    private static String[] hC(@Nullable String str) {
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

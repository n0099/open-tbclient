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
import com.baidu.swan.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean fF(int i) {
        return h.auW().getBoolean(fG(i), false);
    }

    public static void v(int i, boolean z) {
        h.auW().putBoolean(fG(i), z);
    }

    @NonNull
    private static String fG(int i) {
        return i == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset";
    }

    private static ArrayList<Long> afs() {
        ExtensionCore adR;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (c cVar : e.aqf().aqh()) {
            SwanAppCores apV = cVar.apV();
            if (apV != null && cVar.apW() && (adR = apV.adR()) != null && !arrayList.contains(Long.valueOf(adR.extensionCoreVersionCode))) {
                arrayList.add(Long.valueOf(adR.extensionCoreVersionCode));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static void z(Bundle bundle) {
        if (bundle != null) {
            if (!ProcessUtils.isMainProcess()) {
                com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(18, bundle).eW(true));
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
            z(bundle);
        } else if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            if (jArr != null) {
                for (long j : jArr) {
                    if (j > 0) {
                        arrayList.add(Long.valueOf(j));
                    }
                }
            }
            arrayList.addAll(afs());
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

    public static long kO(@Nullable String str) {
        String[] kP = kP(str);
        if (kP == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < kP.length ? Integer.valueOf(kP[i]).intValue() : 0L);
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

    public static String aV(long j) {
        return com.baidu.swan.apps.performance.b.b.aoo() ? com.baidu.swan.apps.swancore.b.bG(j) : aW(j);
    }

    public static String aW(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (DEBUG) {
            Log.d("ExtCore-Utils", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == kO(sb2)));
        }
        return sb2;
    }

    public static boolean fH(int i) {
        return i == 1 ? com.baidu.swan.apps.ae.a.a.aoX() : com.baidu.swan.apps.ae.a.a.aoW();
    }

    private static String[] kP(@Nullable String str) {
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

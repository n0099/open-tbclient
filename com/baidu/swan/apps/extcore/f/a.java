package com.baidu.swan.apps.extcore.f;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean Ik() {
        return f.ST().getBoolean("key_is_need_update_preset", false);
    }

    public static void bA(boolean z) {
        f.ST().putBoolean("key_is_need_update_preset", z);
    }

    public static void a(File file, List<Long> list) {
        File[] listFiles;
        if (file != null) {
            if (DEBUG) {
                Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
            }
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (!b(file2, list)) {
                        if (DEBUG) {
                            Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                        }
                        com.baidu.swan.c.a.deleteFile(file2);
                    }
                }
            }
        }
    }

    private static boolean b(File file, List<Long> list) {
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

    public static long fk(@Nullable String str) {
        String[] fl = fl(str);
        if (fl == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < fl.length ? Integer.valueOf(fl[i]).intValue() : 0L);
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

    public static String W(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format(Locale.US, "%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(DefaultConfig.TOKEN_SEPARATOR);
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-Utils", "version code: " + j + " ,version name: " + ((Object) sb) + " equals: " + (j == fk(sb.toString())));
        }
        return sb.toString();
    }

    public static boolean Il() {
        return DEBUG && com.baidu.swan.apps.ac.a.a.NY();
    }

    private static String[] fl(@Nullable String str) {
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

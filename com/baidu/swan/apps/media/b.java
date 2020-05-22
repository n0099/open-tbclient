package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static ArrayList<a> cjz = new ArrayList<>();

    public static void eg(boolean z) {
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null) {
                aVar.ee(z);
            }
        }
    }

    public static void ef(boolean z) {
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null) {
                aVar.ef(z);
            }
        }
    }

    public static a lt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.aey())) {
                return aVar;
            }
        }
        return null;
    }

    public static a E(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aih())) || TextUtils.equals(str3, aVar.aey())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cjz.contains(aVar)) {
            cjz.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cjz.remove(aVar);
        }
    }

    public static void aij() {
        cjz.clear();
    }

    public static boolean lu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cjz.size() - 1; size >= 0; size--) {
                a aVar = cjz.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cjz.size() - 1; size >= 0; size--) {
            a aVar = cjz.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

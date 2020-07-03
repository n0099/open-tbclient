package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static ArrayList<a> coo = new ArrayList<>();

    public static void el(boolean z) {
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null) {
                aVar.ej(z);
            }
        }
    }

    public static void ek(boolean z) {
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null) {
                aVar.ek(z);
            }
        }
    }

    public static a lB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.afE())) {
                return aVar;
            }
        }
        return null;
    }

    public static a F(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.ajn())) || TextUtils.equals(str3, aVar.afE())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !coo.contains(aVar)) {
            coo.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            coo.remove(aVar);
        }
    }

    public static void ajp() {
        coo.clear();
    }

    public static boolean lC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = coo.size() - 1; size >= 0; size--) {
                a aVar = coo.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = coo.size() - 1; size >= 0; size--) {
            a aVar = coo.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

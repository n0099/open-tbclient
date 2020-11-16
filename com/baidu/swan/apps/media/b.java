package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class b {
    private static ArrayList<a> cYZ = new ArrayList<>();

    public static void fD(boolean z) {
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null) {
                aVar.fB(z);
            }
        }
    }

    public static void fC(boolean z) {
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null) {
                aVar.fC(z);
            }
        }
    }

    public static a pI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.avy())) {
                return aVar;
            }
        }
        return null;
    }

    public static a O(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.azz())) || TextUtils.equals(str3, aVar.avy())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cYZ.contains(aVar)) {
            cYZ.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cYZ.remove(aVar);
        }
    }

    public static void azB() {
        cYZ.clear();
    }

    public static boolean pJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hE(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cYZ.size() - 1; size >= 0; size--) {
                a aVar = cYZ.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cYZ.size() - 1; size >= 0; size--) {
            a aVar = cYZ.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

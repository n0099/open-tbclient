package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class b {
    private static ArrayList<a> bvB = new ArrayList<>();

    public static void cG(boolean z) {
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null) {
                aVar.cE(z);
            }
        }
    }

    public static void cF(boolean z) {
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null) {
                aVar.cF(z);
            }
        }
    }

    public static a iC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.Un())) {
                return aVar;
            }
        }
        return null;
    }

    public static a A(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.Uo())) || TextUtils.equals(str3, aVar.Un())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !bvB.contains(aVar)) {
            bvB.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            bvB.remove(aVar);
        }
    }

    public static void Uq() {
        bvB.clear();
    }

    public static boolean iD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = bvB.size() - 1; size >= 0; size--) {
                a aVar = bvB.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = bvB.size() - 1; size >= 0; size--) {
            a aVar = bvB.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

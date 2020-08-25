package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    private static ArrayList<a> cyj = new ArrayList<>();

    public static void eJ(boolean z) {
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null) {
                aVar.eH(z);
            }
        }
    }

    public static void eI(boolean z) {
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null) {
                aVar.eI(z);
            }
        }
    }

    public static a nZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.aop())) {
                return aVar;
            }
        }
        return null;
    }

    public static a G(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.ass())) || TextUtils.equals(str3, aVar.aop())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cyj.contains(aVar)) {
            cyj.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cyj.remove(aVar);
        }
    }

    public static void asu() {
        cyj.clear();
    }

    public static boolean oa(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cyj.size() - 1; size >= 0; size--) {
                a aVar = cyj.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cyj.size() - 1; size >= 0; size--) {
            a aVar = cyj.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

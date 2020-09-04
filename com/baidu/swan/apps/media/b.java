package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    private static ArrayList<a> cyn = new ArrayList<>();

    public static void eK(boolean z) {
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
            if (aVar != null) {
                aVar.eI(z);
            }
        }
    }

    public static void eJ(boolean z) {
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
            if (aVar != null) {
                aVar.eJ(z);
            }
        }
    }

    public static a oa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
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
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.ass())) || TextUtils.equals(str3, aVar.aop())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cyn.contains(aVar)) {
            cyn.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cyn.remove(aVar);
        }
    }

    public static void asu() {
        cyn.clear();
    }

    public static boolean ob(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cyn.size() - 1; size >= 0; size--) {
                a aVar = cyn.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cyn.size() - 1; size >= 0; size--) {
            a aVar = cyn.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

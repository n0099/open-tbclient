package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static ArrayList<a> aUN = new ArrayList<>();

    public static void u(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aUN.size() - 1; size >= 0; size--) {
                a aVar = aUN.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.bO(z);
                }
            }
        }
    }

    public static void bQ(boolean z) {
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null) {
                aVar.bO(z);
            }
        }
    }

    public static void bP(boolean z) {
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null) {
                aVar.bP(z);
            }
        }
    }

    public static a fP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.LK())) {
                return aVar;
            }
        }
        return null;
    }

    public static a t(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.LL())) || TextUtils.equals(str3, aVar.LK())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !aUN.contains(aVar)) {
            aUN.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            aUN.remove(aVar);
        }
    }

    public static void LN() {
        aUN.clear();
    }

    public static boolean fQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void cI(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aUN.size() - 1; size >= 0; size--) {
                a aVar = aUN.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = aUN.size() - 1; size >= 0; size--) {
            a aVar = aUN.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static ArrayList<a> LO() {
        return aUN;
    }
}

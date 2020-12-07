package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public final class b {
    private static ArrayList<a> dfZ = new ArrayList<>();

    public static void fS(boolean z) {
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null) {
                aVar.fQ(z);
            }
        }
    }

    public static void fR(boolean z) {
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null) {
                aVar.fR(z);
            }
        }
    }

    public static a qp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.ayG())) {
                return aVar;
            }
        }
        return null;
    }

    public static a R(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aCI())) || TextUtils.equals(str3, aVar.ayG())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !dfZ.contains(aVar)) {
            dfZ.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            dfZ.remove(aVar);
        }
    }

    public static void aCK() {
        dfZ.clear();
    }

    public static boolean qq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void ie(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = dfZ.size() - 1; size >= 0; size--) {
                a aVar = dfZ.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = dfZ.size() - 1; size >= 0; size--) {
            a aVar = dfZ.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

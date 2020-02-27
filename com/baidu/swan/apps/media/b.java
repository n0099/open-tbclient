package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static ArrayList<a> bAx = new ArrayList<>();

    public static void cS(boolean z) {
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null) {
                aVar.cQ(z);
            }
        }
    }

    public static void cR(boolean z) {
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null) {
                aVar.cR(z);
            }
        }
    }

    public static a iU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.WY())) {
                return aVar;
            }
        }
        return null;
    }

    public static a B(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.WZ())) || TextUtils.equals(str3, aVar.WY())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !bAx.contains(aVar)) {
            bAx.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            bAx.remove(aVar);
        }
    }

    public static void Xb() {
        bAx.clear();
    }

    public static boolean iV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = bAx.size() - 1; size >= 0; size--) {
                a aVar = bAx.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = bAx.size() - 1; size >= 0; size--) {
            a aVar = bAx.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

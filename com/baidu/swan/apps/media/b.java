package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static ArrayList<a> bAK = new ArrayList<>();

    public static void cT(boolean z) {
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null) {
                aVar.cR(z);
            }
        }
    }

    public static void cS(boolean z) {
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null) {
                aVar.cS(z);
            }
        }
    }

    public static a iT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.Xd())) {
                return aVar;
            }
        }
        return null;
    }

    public static a B(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.Xe())) || TextUtils.equals(str3, aVar.Xd())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !bAK.contains(aVar)) {
            bAK.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            bAK.remove(aVar);
        }
    }

    public static void Xg() {
        bAK.clear();
    }

    public static boolean iU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = bAK.size() - 1; size >= 0; size--) {
                a aVar = bAK.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = bAK.size() - 1; size >= 0; size--) {
            a aVar = bAK.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

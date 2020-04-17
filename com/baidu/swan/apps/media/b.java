package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static ArrayList<a> bYR = new ArrayList<>();

    public static void dP(boolean z) {
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null) {
                aVar.dN(z);
            }
        }
    }

    public static void dO(boolean z) {
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null) {
                aVar.dO(z);
            }
        }
    }

    public static a kg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.aeT())) {
                return aVar;
            }
        }
        return null;
    }

    public static a B(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aeU())) || TextUtils.equals(str3, aVar.aeT())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !bYR.contains(aVar)) {
            bYR.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            bYR.remove(aVar);
        }
    }

    public static void aeW() {
        bYR.clear();
    }

    public static boolean kh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = bYR.size() - 1; size >= 0; size--) {
                a aVar = bYR.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = bYR.size() - 1; size >= 0; size--) {
            a aVar = bYR.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

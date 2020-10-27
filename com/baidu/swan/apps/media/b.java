package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class b {
    private static ArrayList<a> cUP = new ArrayList<>();

    public static void fr(boolean z) {
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null) {
                aVar.fp(z);
            }
        }
    }

    public static void fq(boolean z) {
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null) {
                aVar.fq(z);
            }
        }
    }

    public static a pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.atG())) {
                return aVar;
            }
        }
        return null;
    }

    public static a O(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.axH())) || TextUtils.equals(str3, aVar.atG())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cUP.contains(aVar)) {
            cUP.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cUP.remove(aVar);
        }
    }

    public static void axJ() {
        cUP.clear();
    }

    public static boolean pB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hD(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cUP.size() - 1; size >= 0; size--) {
                a aVar = cUP.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cUP.size() - 1; size >= 0; size--) {
            a aVar = cUP.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

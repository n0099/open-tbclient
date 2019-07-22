package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static ArrayList<a> aBb = new ArrayList<>();

    public static void r(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aBb.size() - 1; size >= 0; size--) {
                a aVar = aBb.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.bw(z);
                }
            }
        }
    }

    public static void by(boolean z) {
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null) {
                aVar.bw(z);
            }
        }
    }

    public static void bx(boolean z) {
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null) {
                aVar.bx(z);
            }
        }
    }

    public static a fg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.GM())) {
                return aVar;
            }
        }
        return null;
    }

    public static a p(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.GN())) || TextUtils.equals(str3, aVar.GM())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !aBb.contains(aVar)) {
            aBb.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            aBb.remove(aVar);
        }
    }

    public static void GP() {
        aBb.clear();
    }

    public static boolean fh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void fi(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aBb.size() - 1; size >= 0; size--) {
                a aVar = aBb.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = aBb.size() - 1; size >= 0; size--) {
            a aVar = aBb.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static ArrayList<a> GQ() {
        return aBb;
    }
}

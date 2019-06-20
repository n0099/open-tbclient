package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static ArrayList<a> aAt = new ArrayList<>();

    public static void r(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aAt.size() - 1; size >= 0; size--) {
                a aVar = aAt.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.bt(z);
                }
            }
        }
    }

    public static void bv(boolean z) {
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null) {
                aVar.bt(z);
            }
        }
    }

    public static void bu(boolean z) {
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null) {
                aVar.bu(z);
            }
        }
    }

    public static a fb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.Gc())) {
                return aVar;
            }
        }
        return null;
    }

    public static a p(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.Gd())) || TextUtils.equals(str3, aVar.Gc())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !aAt.contains(aVar)) {
            aAt.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            aAt.remove(aVar);
        }
    }

    public static void Gf() {
        aAt.clear();
    }

    public static boolean fc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void fd(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = aAt.size() - 1; size >= 0; size--) {
                a aVar = aAt.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = aAt.size() - 1; size >= 0; size--) {
            a aVar = aAt.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static ArrayList<a> Gg() {
        return aAt;
    }
}

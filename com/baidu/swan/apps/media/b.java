package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class b {
    private static ArrayList<a> cAo = new ArrayList<>();

    public static void eI(boolean z) {
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null) {
                aVar.eG(z);
            }
        }
    }

    public static void eH(boolean z) {
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null) {
                aVar.eH(z);
            }
        }
    }

    public static a ov(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.aoZ())) {
                return aVar;
            }
        }
        return null;
    }

    public static a G(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.atc())) || TextUtils.equals(str3, aVar.aoZ())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cAo.contains(aVar)) {
            cAo.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cAo.remove(aVar);
        }
    }

    public static void ate() {
        cAo.clear();
    }

    public static boolean ow(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void he(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cAo.size() - 1; size >= 0; size--) {
                a aVar = cAo.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cAo.size() - 1; size >= 0; size--) {
            a aVar = cAo.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class b {
    private static ArrayList<a> bwo = new ArrayList<>();

    public static void cL(boolean z) {
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null) {
                aVar.cJ(z);
            }
        }
    }

    public static void cK(boolean z) {
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null) {
                aVar.cK(z);
            }
        }
    }

    public static a iF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.UK())) {
                return aVar;
            }
        }
        return null;
    }

    public static a A(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.UL())) || TextUtils.equals(str3, aVar.UK())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !bwo.contains(aVar)) {
            bwo.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            bwo.remove(aVar);
        }
    }

    public static void UN() {
        bwo.clear();
    }

    public static boolean iG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = bwo.size() - 1; size >= 0; size--) {
                a aVar = bwo.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = bwo.size() - 1; size >= 0; size--) {
            a aVar = bwo.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

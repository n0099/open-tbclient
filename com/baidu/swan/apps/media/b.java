package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class b {
    private static ArrayList<a> daJ = new ArrayList<>();

    public static void fA(boolean z) {
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null) {
                aVar.fy(z);
            }
        }
    }

    public static void fz(boolean z) {
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null) {
                aVar.fz(z);
            }
        }
    }

    public static a pO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.awg())) {
                return aVar;
            }
        }
        return null;
    }

    public static a O(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aAh())) || TextUtils.equals(str3, aVar.awg())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !daJ.contains(aVar)) {
            daJ.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            daJ.remove(aVar);
        }
    }

    public static void aAj() {
        daJ.clear();
    }

    public static boolean pP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hK(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = daJ.size() - 1; size >= 0; size--) {
                a aVar = daJ.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = daJ.size() - 1; size >= 0; size--) {
            a aVar = daJ.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

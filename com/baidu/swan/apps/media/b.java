package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class b {
    private static ArrayList<a> cMt = new ArrayList<>();

    public static void fe(boolean z) {
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null) {
                aVar.fc(z);
            }
        }
    }

    public static void fd(boolean z) {
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null) {
                aVar.fd(z);
            }
        }
    }

    public static a ph(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.arL())) {
                return aVar;
            }
        }
        return null;
    }

    public static a H(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.avN())) || TextUtils.equals(str3, aVar.arL())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cMt.contains(aVar)) {
            cMt.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cMt.remove(aVar);
        }
    }

    public static void avP() {
        cMt.clear();
    }

    public static boolean pi(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hv(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cMt.size() - 1; size >= 0; size--) {
                a aVar = cMt.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cMt.size() - 1; size >= 0; size--) {
            a aVar = cMt.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

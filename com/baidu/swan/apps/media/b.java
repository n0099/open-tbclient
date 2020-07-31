package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class b {
    private static ArrayList<a> cqt = new ArrayList<>();

    public static void et(boolean z) {
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null) {
                aVar.er(z);
            }
        }
    }

    public static void es(boolean z) {
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null) {
                aVar.es(z);
            }
        }
    }

    public static a mc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.agP())) {
                return aVar;
            }
        }
        return null;
    }

    public static a F(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.akD())) || TextUtils.equals(str3, aVar.agP())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !cqt.contains(aVar)) {
            cqt.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            cqt.remove(aVar);
        }
    }

    public static void akF() {
        cqt.clear();
    }

    public static boolean md(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void destroy(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = cqt.size() - 1; size >= 0; size--) {
                a aVar = cqt.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = cqt.size() - 1; size >= 0; size--) {
            a aVar = cqt.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

package com.baidu.swan.apps.media;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class b {
    private static ArrayList<a> dkS = new ArrayList<>();

    public static void gb(boolean z) {
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null) {
                aVar.fZ(z);
            }
        }
    }

    public static void ga(boolean z) {
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null) {
                aVar.ga(z);
            }
        }
    }

    public static a qi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.azX())) {
                return aVar;
            }
        }
        return null;
    }

    public static a U(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aDZ())) || TextUtils.equals(str3, aVar.azX())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !dkS.contains(aVar)) {
            dkS.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            dkS.remove(aVar);
        }
    }

    public static void aEb() {
        dkS.clear();
    }

    public static boolean qj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hP(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = dkS.size() - 1; size >= 0; size--) {
                a aVar = dkS.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = dkS.size() - 1; size >= 0; size--) {
            a aVar = dkS.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

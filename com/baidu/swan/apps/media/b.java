package com.baidu.swan.apps.media;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    private static ArrayList<a> djS = new ArrayList<>();

    public static void fZ(boolean z) {
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null) {
                aVar.fX(z);
            }
        }
    }

    public static void fY(boolean z) {
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null) {
                aVar.fY(z);
            }
        }
    }

    public static a pw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.awF())) {
                return aVar;
            }
        }
        return null;
    }

    public static a U(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aAH())) || TextUtils.equals(str3, aVar.awF())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !djS.contains(aVar)) {
            djS.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            djS.remove(aVar);
        }
    }

    public static void aAJ() {
        djS.clear();
    }

    public static boolean px(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void hi(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = djS.size() - 1; size >= 0; size--) {
                a aVar = djS.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = djS.size() - 1; size >= 0; size--) {
            a aVar = djS.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

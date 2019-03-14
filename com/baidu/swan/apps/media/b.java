package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static ArrayList<a> azr = new ArrayList<>();

    public static void r(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = azr.size() - 1; size >= 0; size--) {
                a aVar = azr.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.bk(z);
                }
            }
        }
    }

    public static void bm(boolean z) {
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null) {
                aVar.bk(z);
            }
        }
    }

    public static void bl(boolean z) {
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null) {
                aVar.bl(z);
            }
        }
    }

    public static a eQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.Ei())) {
                return aVar;
            }
        }
        return null;
    }

    public static a p(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.Ej())) || TextUtils.equals(str3, aVar.Ei())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !azr.contains(aVar)) {
            azr.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            azr.remove(aVar);
        }
    }

    public static void El() {
        azr.clear();
    }

    public static boolean eR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void eS(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = azr.size() - 1; size >= 0; size--) {
                a aVar = azr.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = azr.size() - 1; size >= 0; size--) {
            a aVar = azr.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static ArrayList<a> Em() {
        return azr;
    }
}

package com.baidu.swan.apps.media;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static ArrayList<a> azv = new ArrayList<>();

    public static void r(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = azv.size() - 1; size >= 0; size--) {
                a aVar = azv.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.bk(z);
                }
            }
        }
    }

    public static void bm(boolean z) {
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null) {
                aVar.bk(z);
            }
        }
    }

    public static void bl(boolean z) {
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null) {
                aVar.bl(z);
            }
        }
    }

    public static a eR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.Eg())) {
                return aVar;
            }
        }
        return null;
    }

    public static a p(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.Eh())) || TextUtils.equals(str3, aVar.Eg())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !azv.contains(aVar)) {
            azv.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            azv.remove(aVar);
        }
    }

    public static void Ej() {
        azv.clear();
    }

    public static boolean eS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void eT(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = azv.size() - 1; size >= 0; size--) {
                a aVar = azv.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = azv.size() - 1; size >= 0; size--) {
            a aVar = azv.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public static ArrayList<a> Ek() {
        return azv;
    }
}

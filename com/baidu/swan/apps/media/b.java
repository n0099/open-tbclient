package com.baidu.swan.apps.media;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    private static ArrayList<a> dgd = new ArrayList<>();

    public static void fX(boolean z) {
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null) {
                aVar.fV(z);
            }
        }
    }

    public static void fW(boolean z) {
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null) {
                aVar.fW(z);
            }
        }
    }

    public static a oX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.awe())) {
                return aVar;
            }
        }
        return null;
    }

    public static a T(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.getSlaveId())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.aAg())) || TextUtils.equals(str3, aVar.awe())))) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !dgd.contains(aVar)) {
            dgd.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            dgd.remove(aVar);
        }
    }

    public static void aAi() {
        dgd.clear();
    }

    public static boolean oY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.getSlaveId()) && aVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public static void gE(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int size = dgd.size() - 1; size >= 0; size--) {
                a aVar = dgd.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.getSlaveId())) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void destroy() {
        for (int size = dgd.size() - 1; size >= 0; size--) {
            a aVar = dgd.get(size);
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}

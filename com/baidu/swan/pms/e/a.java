package com.baidu.swan.pms.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.utils.AbiType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = d.DEBUG;
    private static Map<String, a> exr = new HashMap();
    private static Map<String, Map<String, a>> exs = new HashMap();
    public final String dbu;
    public final String evD;
    public final AbiType evJ;

    private a(@NonNull String str, @NonNull AbiType abiType) {
        this.dbu = TextUtils.isEmpty(str) ? "" : str;
        this.evJ = abiType;
        this.evD = c(str, abiType);
        if (DEBUG) {
            Log.i("SoBundleId", "SoBundleId: " + this.evD + " libName=" + str + " abi=" + abiType);
        }
    }

    @NonNull
    public String toString() {
        return this.evD;
    }

    @Nullable
    public static synchronized a b(String str, AbiType abiType) {
        a dq;
        synchronized (a.class) {
            dq = dq(str, c(str, abiType));
        }
        return dq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
        if (android.text.TextUtils.equals(r6, r0.dbu) == false) goto L21;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a dq(String str, String str2) {
        a aVar;
        synchronized (a.class) {
            if (DEBUG) {
                Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                aVar = null;
            } else {
                yt(str);
                aVar = exr.get(str2);
                if (DEBUG) {
                    Log.i("SoBundleId", "of: end libName=" + str + " soBundleId=" + aVar);
                }
                if (aVar != null) {
                }
                aVar = null;
            }
        }
        return aVar;
    }

    public static synchronized Map<String, a> ys(@NonNull String str) {
        HashMap hashMap;
        synchronized (a.class) {
            hashMap = new HashMap(yt(str));
        }
        return hashMap;
    }

    private static synchronized Map<String, a> yt(@NonNull String str) {
        Map<String, a> map;
        synchronized (a.class) {
            map = exs.get(str);
            if (map == null) {
                map = new HashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    for (AbiType abiType : AbiType.values()) {
                        a aVar = new a(str, abiType);
                        map.put(aVar.evD, aVar);
                    }
                    exr.putAll(map);
                    exs.put(str, map);
                }
            }
        }
        return map;
    }

    private static String c(String str, AbiType abiType) {
        return "so_" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + abiType.id;
    }
}

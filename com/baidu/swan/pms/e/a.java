package com.baidu.swan.pms.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.pms.d;
import com.baidu.swan.pms.utils.AbiType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = d.DEBUG;
    private static Map<String, a> ehN = new HashMap();
    private static Map<String, Map<String, a>> ehO = new HashMap();
    public final String cQI;
    public final String efY;
    public final AbiType ege;

    private a(@NonNull String str, @NonNull AbiType abiType) {
        this.cQI = TextUtils.isEmpty(str) ? "" : str;
        this.ege = abiType;
        this.efY = c(str, abiType);
        if (DEBUG) {
            Log.i("SoBundleId", "SoBundleId: " + this.efY + " libName=" + str + " abi=" + abiType);
        }
    }

    @NonNull
    public String toString() {
        return this.efY;
    }

    @Nullable
    public static synchronized a b(String str, AbiType abiType) {
        a dr;
        synchronized (a.class) {
            dr = dr(str, c(str, abiType));
        }
        return dr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
        if (android.text.TextUtils.equals(r6, r0.cQI) == false) goto L21;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized a dr(String str, String str2) {
        a aVar;
        synchronized (a.class) {
            if (DEBUG) {
                Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                aVar = null;
            } else {
                yy(str);
                aVar = ehN.get(str2);
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

    public static synchronized Map<String, a> yx(@NonNull String str) {
        HashMap hashMap;
        synchronized (a.class) {
            hashMap = new HashMap(yy(str));
        }
        return hashMap;
    }

    private static synchronized Map<String, a> yy(@NonNull String str) {
        Map<String, a> map;
        synchronized (a.class) {
            map = ehO.get(str);
            if (map == null) {
                map = new HashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    for (AbiType abiType : AbiType.values()) {
                        a aVar = new a(str, abiType);
                        map.put(aVar.efY, aVar);
                    }
                    ehN.putAll(map);
                    ehO.put(str, map);
                }
            }
        }
        return map;
    }

    private static String c(String str, AbiType abiType) {
        return "so_" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + abiType.id;
    }
}

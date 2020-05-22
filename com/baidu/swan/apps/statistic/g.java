package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import java.util.HashSet;
/* loaded from: classes11.dex */
public final class g {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cGc = 0;

    public static void gR(int i) {
        cGc = i;
    }

    public static String ov(String str) {
        if (!TextUtils.isEmpty(str)) {
            String params = ah.getParams(str);
            if (!TextUtils.isEmpty(params)) {
                HashSet hashSet = new HashSet();
                hashSet.add("bduss");
                hashSet.add("bduss".toUpperCase());
                return ah.delAllParamsFromUrl(str) + "?" + ah.deleteQueryParam(params, hashSet);
            }
            return str;
        }
        return str;
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event) {
        return (EvenT) a(event, "coreState", Integer.valueOf(com.baidu.swan.apps.core.turbo.d.abk()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT b(EvenT event) {
        return (EvenT) a(event, "packageState", Integer.valueOf(com.baidu.swan.apps.runtime.d.aoB().aox().aoM()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT c(EvenT event) {
        return (EvenT) a(event, "isDownloading", Integer.valueOf(com.baidu.swan.apps.runtime.d.aoB().aox().aoL() ? 1 : 0));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.v(str, obj);
        }
        return event;
    }
}

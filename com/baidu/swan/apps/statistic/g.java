package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class g {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cZg = 0;

    public static int aDl() {
        return cZg;
    }

    public static void jF(int i) {
        cZg = i;
    }

    public static String rG(String str) {
        if (!TextUtils.isEmpty(str)) {
            String params = ai.getParams(str);
            if (!TextUtils.isEmpty(params)) {
                HashSet hashSet = new HashSet();
                hashSet.add("bduss");
                hashSet.add("bduss".toUpperCase());
                return ai.delAllParamsFromUrl(str) + "?" + ai.deleteQueryParam(params, hashSet);
            }
            return str;
        }
        return str;
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event) {
        return (EvenT) a(event, "coreState", Integer.valueOf(com.baidu.swan.apps.core.turbo.d.akB()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT b(EvenT event) {
        return (EvenT) a(event, "packageState", Integer.valueOf(com.baidu.swan.apps.runtime.d.aAn().aAj().aAy()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT c(EvenT event) {
        return (EvenT) a(event, "isDownloading", Integer.valueOf(com.baidu.swan.apps.runtime.d.aAn().aAj().aAx() ? 1 : 0));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.u(str, obj);
        }
        return event;
    }
}

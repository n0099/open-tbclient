package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import java.util.HashSet;
/* loaded from: classes7.dex */
public final class g {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cOd = 0;

    public static int aus() {
        return cOd;
    }

    public static void hn(int i) {
        cOd = i;
    }

    public static String pm(String str) {
        if (!TextUtils.isEmpty(str)) {
            String params = aj.getParams(str);
            if (!TextUtils.isEmpty(params)) {
                HashSet hashSet = new HashSet();
                hashSet.add("bduss");
                hashSet.add("bduss".toUpperCase());
                return aj.delAllParamsFromUrl(str) + "?" + aj.deleteQueryParam(params, hashSet);
            }
            return str;
        }
        return str;
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event) {
        return (EvenT) a(event, "coreState", Integer.valueOf(com.baidu.swan.apps.core.turbo.d.adv()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT b(EvenT event) {
        return (EvenT) a(event, "packageState", Integer.valueOf(com.baidu.swan.apps.runtime.d.arr().arn().arC()));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT c(EvenT event) {
        return (EvenT) a(event, "isDownloading", Integer.valueOf(com.baidu.swan.apps.runtime.d.arr().arn().arB() ? 1 : 0));
    }

    public static <EvenT extends com.baidu.swan.apps.statistic.a.e> EvenT a(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.v(str, obj);
        }
        return event;
    }
}

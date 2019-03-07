package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public String atf;
    public String atj;
    public String atl;
    public String atm;
    public String atn;

    public static com.baidu.swan.apps.m.a.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.atf);
        treeMap.put("pagePath", bVar.atl);
        treeMap.put("devhook", bVar.atj);
        if (!TextUtils.isEmpty(bVar.atn)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.atn);
            }
            treeMap.put("initData", bVar.atn);
        }
        if (!TextUtils.isEmpty(bVar.atm)) {
            treeMap.put("onReachBottomDistance", bVar.atm);
        }
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.atf + "', pagePath='" + this.atl + "', onReachBottomDistance='" + this.atm + "'}";
    }
}

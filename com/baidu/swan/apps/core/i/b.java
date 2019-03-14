package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String atg;
    public String atk;
    public String atm;
    public String atn;
    public String ato;

    public static com.baidu.swan.apps.m.a.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.atg);
        treeMap.put("pagePath", bVar.atm);
        treeMap.put("devhook", bVar.atk);
        if (!TextUtils.isEmpty(bVar.ato)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.ato);
            }
            treeMap.put("initData", bVar.ato);
        }
        if (!TextUtils.isEmpty(bVar.atn)) {
            treeMap.put("onReachBottomDistance", bVar.atn);
        }
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.atg + "', pagePath='" + this.atm + "', onReachBottomDistance='" + this.atn + "'}";
    }
}

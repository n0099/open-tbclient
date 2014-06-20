package com.baidu.adp.lib.resourceLoader;

import android.content.IntentFilter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class BdResourceLoaderNetHelperStatic {
    private static boolean a;
    private static boolean b;

    static {
        a = false;
        b = true;
        try {
            g gVar = new g(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(gVar, intentFilter);
            b = com.baidu.adp.lib.network.willdelete.h.a();
            a = true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static boolean a() {
        return !a ? com.baidu.adp.lib.network.willdelete.h.a() : b;
    }
}

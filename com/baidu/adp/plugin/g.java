package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g CV;
    private Map<String, a> CW;

    public static g iN() {
        if (CV == null) {
            synchronized (g.class) {
                if (CV == null) {
                    CV = new g();
                }
            }
        }
        return CV;
    }

    private g() {
        this.CW = null;
        this.CW = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.CW.put(str, aVar);
    }

    public synchronized a aS(String str) {
        return this.CW.get(str);
    }

    public synchronized void aT(String str) {
        this.CW.remove(str);
    }

    public int iO() {
        return this.CW.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy CX;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.CX = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g CS;
    private Map<String, a> CT;

    public static g iO() {
        if (CS == null) {
            synchronized (g.class) {
                if (CS == null) {
                    CS = new g();
                }
            }
        }
        return CS;
    }

    private g() {
        this.CT = null;
        this.CT = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.CT.put(str, aVar);
    }

    public synchronized a aN(String str) {
        return this.CT.get(str);
    }

    public synchronized void aO(String str) {
        this.CT.remove(str);
    }

    public int iP() {
        return this.CT.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy CU;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.CU = serviceProxy;
            this.mIntent = intent;
        }
    }
}

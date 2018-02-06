package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqj;
    private Map<String, a> aqk;

    public static d qj() {
        if (aqj == null) {
            synchronized (d.class) {
                if (aqj == null) {
                    aqj = new d();
                }
            }
        }
        return aqj;
    }

    private d() {
        this.aqk = null;
        this.aqk = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aqk.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aqk.get(str);
    }

    public synchronized void bg(String str) {
        this.aqk.remove(str);
    }

    public int qk() {
        return this.aqk.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aql;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aql = serviceProxy;
            this.mIntent = intent;
        }
    }
}

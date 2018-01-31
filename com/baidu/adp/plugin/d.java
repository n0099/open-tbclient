package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqk;
    private Map<String, a> aql;

    public static d qj() {
        if (aqk == null) {
            synchronized (d.class) {
                if (aqk == null) {
                    aqk = new d();
                }
            }
        }
        return aqk;
    }

    private d() {
        this.aql = null;
        this.aql = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aql.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aql.get(str);
    }

    public synchronized void bg(String str) {
        this.aql.remove(str);
    }

    public int qk() {
        return this.aql.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aqm;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aqm = serviceProxy;
            this.mIntent = intent;
        }
    }
}

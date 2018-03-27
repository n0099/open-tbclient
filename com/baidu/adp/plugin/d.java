package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqb;
    private Map<String, a> aqc;

    public static d qj() {
        if (aqb == null) {
            synchronized (d.class) {
                if (aqb == null) {
                    aqb = new d();
                }
            }
        }
        return aqb;
    }

    private d() {
        this.aqc = null;
        this.aqc = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aqc.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aqc.get(str);
    }

    public synchronized void bg(String str) {
        this.aqc.remove(str);
    }

    public int qk() {
        return this.aqc.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aqd;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aqd = serviceProxy;
            this.mIntent = intent;
        }
    }
}

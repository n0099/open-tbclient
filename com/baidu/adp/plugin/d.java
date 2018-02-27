package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqa;
    private Map<String, a> aqb;

    public static d qj() {
        if (aqa == null) {
            synchronized (d.class) {
                if (aqa == null) {
                    aqa = new d();
                }
            }
        }
        return aqa;
    }

    private d() {
        this.aqb = null;
        this.aqb = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aqb.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aqb.get(str);
    }

    public synchronized void bg(String str) {
        this.aqb.remove(str);
    }

    public int qk() {
        return this.aqb.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aqc;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aqc = serviceProxy;
            this.mIntent = intent;
        }
    }
}

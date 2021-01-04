package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Tb;
    private Map<String, a> Tc;

    public static d oK() {
        if (Tb == null) {
            synchronized (d.class) {
                if (Tb == null) {
                    Tb = new d();
                }
            }
        }
        return Tb;
    }

    private d() {
        this.Tc = null;
        this.Tc = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Tc.put(str, aVar);
    }

    public synchronized a ck(String str) {
        return this.Tc.get(str);
    }

    public synchronized void cl(String str) {
        this.Tc.remove(str);
    }

    public int oL() {
        return this.Tc.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Td;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Td = serviceProxy;
            this.mIntent = intent;
        }
    }
}

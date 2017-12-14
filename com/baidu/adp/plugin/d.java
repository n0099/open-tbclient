package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Cc;
    private Map<String, a> Cd;

    public static d iJ() {
        if (Cc == null) {
            synchronized (d.class) {
                if (Cc == null) {
                    Cc = new d();
                }
            }
        }
        return Cc;
    }

    private d() {
        this.Cd = null;
        this.Cd = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Cd.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.Cd.get(str);
    }

    public synchronized void aY(String str) {
        this.Cd.remove(str);
    }

    public int iK() {
        return this.Cd.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Ce;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Ce = serviceProxy;
            this.mIntent = intent;
        }
    }
}

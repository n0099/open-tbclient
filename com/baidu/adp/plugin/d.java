package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Cd;
    private Map<String, a> Ce;

    public static d iJ() {
        if (Cd == null) {
            synchronized (d.class) {
                if (Cd == null) {
                    Cd = new d();
                }
            }
        }
        return Cd;
    }

    private d() {
        this.Ce = null;
        this.Ce = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ce.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.Ce.get(str);
    }

    public synchronized void aY(String str) {
        this.Ce.remove(str);
    }

    public int iK() {
        return this.Ce.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Cf;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Cf = serviceProxy;
            this.mIntent = intent;
        }
    }
}

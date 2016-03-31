package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g Dd;
    private Map<String, a> De;

    public static g kJ() {
        if (Dd == null) {
            synchronized (g.class) {
                if (Dd == null) {
                    Dd = new g();
                }
            }
        }
        return Dd;
    }

    private g() {
        this.De = null;
        this.De = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.De.put(str, aVar);
    }

    public synchronized a be(String str) {
        return this.De.get(str);
    }

    public synchronized void bf(String str) {
        this.De.remove(str);
    }

    public int kK() {
        return this.De.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Df;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Df = serviceProxy;
            this.mIntent = intent;
        }
    }
}

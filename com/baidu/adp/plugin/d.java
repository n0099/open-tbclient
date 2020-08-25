package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Rr;
    private Map<String, a> Rs;

    public static d pd() {
        if (Rr == null) {
            synchronized (d.class) {
                if (Rr == null) {
                    Rr = new d();
                }
            }
        }
        return Rr;
    }

    private d() {
        this.Rs = null;
        this.Rs = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Rs.put(str, aVar);
    }

    public synchronized a cj(String str) {
        return this.Rs.get(str);
    }

    public synchronized void ck(String str) {
        this.Rs.remove(str);
    }

    public int pe() {
        return this.Rs.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Rt;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Rt = serviceProxy;
            this.mIntent = intent;
        }
    }
}

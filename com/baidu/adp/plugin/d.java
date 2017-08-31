package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Cq;
    private Map<String, a> Cr;

    public static d iN() {
        if (Cq == null) {
            synchronized (d.class) {
                if (Cq == null) {
                    Cq = new d();
                }
            }
        }
        return Cq;
    }

    private d() {
        this.Cr = null;
        this.Cr = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Cr.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.Cr.get(str);
    }

    public synchronized void aY(String str) {
        this.Cr.remove(str);
    }

    public int iO() {
        return this.Cr.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Cs;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Cs = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Qc;
    private Map<String, a> Qe;

    public static d nk() {
        if (Qc == null) {
            synchronized (d.class) {
                if (Qc == null) {
                    Qc = new d();
                }
            }
        }
        return Qc;
    }

    private d() {
        this.Qe = null;
        this.Qe = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Qe.put(str, aVar);
    }

    public synchronized a ce(String str) {
        return this.Qe.get(str);
    }

    public synchronized void cf(String str) {
        this.Qe.remove(str);
    }

    public int nl() {
        return this.Qe.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Qf;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Qf = serviceProxy;
            this.mIntent = intent;
        }
    }
}

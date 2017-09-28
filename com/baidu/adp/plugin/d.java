package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Cs;
    private Map<String, a> Ct;

    public static d iM() {
        if (Cs == null) {
            synchronized (d.class) {
                if (Cs == null) {
                    Cs = new d();
                }
            }
        }
        return Cs;
    }

    private d() {
        this.Ct = null;
        this.Ct = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ct.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.Ct.get(str);
    }

    public synchronized void aY(String str) {
        this.Ct.remove(str);
    }

    public int iN() {
        return this.Ct.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Cu;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Cu = serviceProxy;
            this.mIntent = intent;
        }
    }
}

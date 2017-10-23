package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ct;
    private Map<String, a> Cu;

    public static d iM() {
        if (Ct == null) {
            synchronized (d.class) {
                if (Ct == null) {
                    Ct = new d();
                }
            }
        }
        return Ct;
    }

    private d() {
        this.Cu = null;
        this.Cu = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Cu.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.Cu.get(str);
    }

    public synchronized void aY(String str) {
        this.Cu.remove(str);
    }

    public int iN() {
        return this.Cu.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Cv;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Cv = serviceProxy;
            this.mIntent = intent;
        }
    }
}

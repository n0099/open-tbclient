package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d wC;
    private Map<String, a> wD;

    public static d it() {
        if (wC == null) {
            synchronized (d.class) {
                if (wC == null) {
                    wC = new d();
                }
            }
        }
        return wC;
    }

    private d() {
        this.wD = null;
        this.wD = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.wD.put(str, aVar);
    }

    public synchronized a aM(String str) {
        return this.wD.get(str);
    }

    public synchronized void aN(String str) {
        this.wD.remove(str);
    }

    public int iu() {
        return this.wD.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy wE;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.wE = serviceProxy;
            this.mIntent = intent;
        }
    }
}

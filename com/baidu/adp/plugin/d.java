package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d AD;
    private Map<String, a> AE;

    public static d io() {
        if (AD == null) {
            synchronized (d.class) {
                if (AD == null) {
                    AD = new d();
                }
            }
        }
        return AD;
    }

    private d() {
        this.AE = null;
        this.AE = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.AE.put(str, aVar);
    }

    public synchronized a bc(String str) {
        return this.AE.get(str);
    }

    public synchronized void bd(String str) {
        this.AE.remove(str);
    }

    public int ip() {
        return this.AE.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy AF;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.AF = serviceProxy;
            this.mIntent = intent;
        }
    }
}

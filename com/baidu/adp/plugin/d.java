package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d GJ;
    private Map<String, a> GK;

    public static d le() {
        if (GJ == null) {
            synchronized (d.class) {
                if (GJ == null) {
                    GJ = new d();
                }
            }
        }
        return GJ;
    }

    private d() {
        this.GK = null;
        this.GK = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.GK.put(str, aVar);
    }

    public synchronized a br(String str) {
        return this.GK.get(str);
    }

    public synchronized void bs(String str) {
        this.GK.remove(str);
    }

    public int lf() {
        return this.GK.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy GL;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.GL = serviceProxy;
            this.mIntent = intent;
        }
    }
}

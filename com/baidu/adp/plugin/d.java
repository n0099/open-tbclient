package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d SZ;
    private Map<String, a> Ta;

    public static d pj() {
        if (SZ == null) {
            synchronized (d.class) {
                if (SZ == null) {
                    SZ = new d();
                }
            }
        }
        return SZ;
    }

    private d() {
        this.Ta = null;
        this.Ta = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ta.put(str, aVar);
    }

    public synchronized a cr(String str) {
        return this.Ta.get(str);
    }

    public synchronized void cs(String str) {
        this.Ta.remove(str);
    }

    public int pk() {
        return this.Ta.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Tb;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Tb = serviceProxy;
            this.mIntent = intent;
        }
    }
}

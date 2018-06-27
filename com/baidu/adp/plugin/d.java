package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d GM;
    private Map<String, a> GN;

    public static d lc() {
        if (GM == null) {
            synchronized (d.class) {
                if (GM == null) {
                    GM = new d();
                }
            }
        }
        return GM;
    }

    private d() {
        this.GN = null;
        this.GN = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.GN.put(str, aVar);
    }

    public synchronized a bq(String str) {
        return this.GN.get(str);
    }

    public synchronized void br(String str) {
        this.GN.remove(str);
    }

    public int ld() {
        return this.GN.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy GO;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.GO = serviceProxy;
            this.mIntent = intent;
        }
    }
}

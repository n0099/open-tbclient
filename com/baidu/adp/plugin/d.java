package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d uz;
    private Map<String, a> uA;

    public static d hY() {
        if (uz == null) {
            synchronized (d.class) {
                if (uz == null) {
                    uz = new d();
                }
            }
        }
        return uz;
    }

    private d() {
        this.uA = null;
        this.uA = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.uA.put(str, aVar);
    }

    public synchronized a aA(String str) {
        return this.uA.get(str);
    }

    public synchronized void aB(String str) {
        this.uA.remove(str);
    }

    public int hZ() {
        return this.uA.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy uB;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.uB = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g tZ;
    private Map<String, a> ua;

    public static g gX() {
        if (tZ == null) {
            synchronized (g.class) {
                if (tZ == null) {
                    tZ = new g();
                }
            }
        }
        return tZ;
    }

    private g() {
        this.ua = null;
        this.ua = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.ua.put(str, aVar);
    }

    public synchronized a aY(String str) {
        return this.ua.get(str);
    }

    public synchronized void aZ(String str) {
        this.ua.remove(str);
    }

    public int gY() {
        return this.ua.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy ub;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.ub = serviceProxy;
            this.mIntent = intent;
        }
    }
}

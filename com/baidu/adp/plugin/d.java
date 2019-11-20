package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d tV;
    private Map<String, a> tW;

    public static d hY() {
        if (tV == null) {
            synchronized (d.class) {
                if (tV == null) {
                    tV = new d();
                }
            }
        }
        return tV;
    }

    private d() {
        this.tW = null;
        this.tW = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.tW.put(str, aVar);
    }

    public synchronized a aA(String str) {
        return this.tW.get(str);
    }

    public synchronized void aB(String str) {
        this.tW.remove(str);
    }

    public int hZ() {
        return this.tW.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy tX;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.tX = serviceProxy;
            this.mIntent = intent;
        }
    }
}

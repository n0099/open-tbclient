package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d wX;
    private Map<String, a> wY;

    public static d iH() {
        if (wX == null) {
            synchronized (d.class) {
                if (wX == null) {
                    wX = new d();
                }
            }
        }
        return wX;
    }

    private d() {
        this.wY = null;
        this.wY = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.wY.put(str, aVar);
    }

    public synchronized a aP(String str) {
        return this.wY.get(str);
    }

    public synchronized void aQ(String str) {
        this.wY.remove(str);
    }

    public int iI() {
        return this.wY.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy wZ;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.wZ = serviceProxy;
            this.mIntent = intent;
        }
    }
}

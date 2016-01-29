package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g CY;
    private Map<String, a> CZ;

    public static g kU() {
        if (CY == null) {
            synchronized (g.class) {
                if (CY == null) {
                    CY = new g();
                }
            }
        }
        return CY;
    }

    private g() {
        this.CZ = null;
        this.CZ = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.CZ.put(str, aVar);
    }

    public synchronized a bg(String str) {
        return this.CZ.get(str);
    }

    public synchronized void bh(String str) {
        this.CZ.remove(str);
    }

    public int kV() {
        return this.CZ.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Da;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Da = serviceProxy;
            this.mIntent = intent;
        }
    }
}

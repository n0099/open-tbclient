package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d PY;
    private Map<String, a> PZ;

    public static d nk() {
        if (PY == null) {
            synchronized (d.class) {
                if (PY == null) {
                    PY = new d();
                }
            }
        }
        return PY;
    }

    private d() {
        this.PZ = null;
        this.PZ = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.PZ.put(str, aVar);
    }

    public synchronized a ce(String str) {
        return this.PZ.get(str);
    }

    public synchronized void cf(String str) {
        this.PZ.remove(str);
    }

    public int nl() {
        return this.PZ.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Qa;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Qa = serviceProxy;
            this.mIntent = intent;
        }
    }
}

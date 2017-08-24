package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ew;
    private Map<String, a> Ex;

    public static d iV() {
        if (Ew == null) {
            synchronized (d.class) {
                if (Ew == null) {
                    Ew = new d();
                }
            }
        }
        return Ew;
    }

    private d() {
        this.Ex = null;
        this.Ex = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ex.put(str, aVar);
    }

    public synchronized a bb(String str) {
        return this.Ex.get(str);
    }

    public synchronized void bc(String str) {
        this.Ex.remove(str);
    }

    public int iW() {
        return this.Ex.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Ey;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Ey = serviceProxy;
            this.mIntent = intent;
        }
    }
}

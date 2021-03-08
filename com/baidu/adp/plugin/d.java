package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ur;
    private Map<String, a> Us;

    public static d oI() {
        if (Ur == null) {
            synchronized (d.class) {
                if (Ur == null) {
                    Ur = new d();
                }
            }
        }
        return Ur;
    }

    private d() {
        this.Us = null;
        this.Us = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Us.put(str, aVar);
    }

    public synchronized a co(String str) {
        return this.Us.get(str);
    }

    public synchronized void cp(String str) {
        this.Us.remove(str);
    }

    public int oJ() {
        return this.Us.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Ut;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Ut = serviceProxy;
            this.mIntent = intent;
        }
    }
}

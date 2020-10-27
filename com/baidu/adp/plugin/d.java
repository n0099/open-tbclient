package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Sd;
    private Map<String, a> Se;

    public static d pi() {
        if (Sd == null) {
            synchronized (d.class) {
                if (Sd == null) {
                    Sd = new d();
                }
            }
        }
        return Sd;
    }

    private d() {
        this.Se = null;
        this.Se = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Se.put(str, aVar);
    }

    public synchronized a cm(String str) {
        return this.Se.get(str);
    }

    public synchronized void cn(String str) {
        this.Se.remove(str);
    }

    public int pj() {
        return this.Se.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Sf;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Sf = serviceProxy;
            this.mIntent = intent;
        }
    }
}

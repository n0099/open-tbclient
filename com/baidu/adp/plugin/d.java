package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Sc;
    private Map<String, a> Sd;

    public static d pi() {
        if (Sc == null) {
            synchronized (d.class) {
                if (Sc == null) {
                    Sc = new d();
                }
            }
        }
        return Sc;
    }

    private d() {
        this.Sd = null;
        this.Sd = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Sd.put(str, aVar);
    }

    public synchronized a cm(String str) {
        return this.Sd.get(str);
    }

    public synchronized void cn(String str) {
        this.Sd.remove(str);
    }

    public int pj() {
        return this.Sd.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Se;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Se = serviceProxy;
            this.mIntent = intent;
        }
    }
}

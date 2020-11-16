package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Se;
    private Map<String, a> Sf;

    public static d pi() {
        if (Se == null) {
            synchronized (d.class) {
                if (Se == null) {
                    Se = new d();
                }
            }
        }
        return Se;
    }

    private d() {
        this.Sf = null;
        this.Sf = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Sf.put(str, aVar);
    }

    public synchronized a co(String str) {
        return this.Sf.get(str);
    }

    public synchronized void cp(String str) {
        this.Sf.remove(str);
    }

    public int pj() {
        return this.Sf.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Sg;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Sg = serviceProxy;
            this.mIntent = intent;
        }
    }
}

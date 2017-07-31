package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Eu;
    private Map<String, a> Ev;

    public static d iV() {
        if (Eu == null) {
            synchronized (d.class) {
                if (Eu == null) {
                    Eu = new d();
                }
            }
        }
        return Eu;
    }

    private d() {
        this.Ev = null;
        this.Ev = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ev.put(str, aVar);
    }

    public synchronized a ba(String str) {
        return this.Ev.get(str);
    }

    public synchronized void bb(String str) {
        this.Ev.remove(str);
    }

    public int iW() {
        return this.Ev.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Ew;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Ew = serviceProxy;
            this.mIntent = intent;
        }
    }
}

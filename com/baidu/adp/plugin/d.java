package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ji;
    private Map<String, a> Jj;

    public static d mk() {
        if (Ji == null) {
            synchronized (d.class) {
                if (Ji == null) {
                    Ji = new d();
                }
            }
        }
        return Ji;
    }

    private d() {
        this.Jj = null;
        this.Jj = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Jj.put(str, aVar);
    }

    public synchronized a bI(String str) {
        return this.Jj.get(str);
    }

    public synchronized void bJ(String str) {
        this.Jj.remove(str);
    }

    public int ml() {
        return this.Jj.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Jk;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Jk = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d RJ;
    private Map<String, a> RK;

    public static d pi() {
        if (RJ == null) {
            synchronized (d.class) {
                if (RJ == null) {
                    RJ = new d();
                }
            }
        }
        return RJ;
    }

    private d() {
        this.RK = null;
        this.RK = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.RK.put(str, aVar);
    }

    public synchronized a cm(String str) {
        return this.RK.get(str);
    }

    public synchronized void cn(String str) {
        this.RK.remove(str);
    }

    public int pj() {
        return this.RK.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy RL;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.RL = serviceProxy;
            this.mIntent = intent;
        }
    }
}

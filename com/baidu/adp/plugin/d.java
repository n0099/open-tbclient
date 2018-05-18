package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d AC;
    private Map<String, a> AD;

    public static d io() {
        if (AC == null) {
            synchronized (d.class) {
                if (AC == null) {
                    AC = new d();
                }
            }
        }
        return AC;
    }

    private d() {
        this.AD = null;
        this.AD = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.AD.put(str, aVar);
    }

    public synchronized a bc(String str) {
        return this.AD.get(str);
    }

    public synchronized void bd(String str) {
        this.AD.remove(str);
    }

    public int ip() {
        return this.AD.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy AE;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.AE = serviceProxy;
            this.mIntent = intent;
        }
    }
}

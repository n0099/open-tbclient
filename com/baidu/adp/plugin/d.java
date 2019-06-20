package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d HB;
    private Map<String, a> HC;

    public static d lq() {
        if (HB == null) {
            synchronized (d.class) {
                if (HB == null) {
                    HB = new d();
                }
            }
        }
        return HB;
    }

    private d() {
        this.HC = null;
        this.HC = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.HC.put(str, aVar);
    }

    public synchronized a br(String str) {
        return this.HC.get(str);
    }

    public synchronized void bs(String str) {
        this.HC.remove(str);
    }

    public int lr() {
        return this.HC.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy HD;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.HD = serviceProxy;
            this.mIntent = intent;
        }
    }
}

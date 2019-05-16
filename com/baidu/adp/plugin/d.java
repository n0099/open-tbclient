package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d HC;
    private Map<String, a> HD;

    public static d lq() {
        if (HC == null) {
            synchronized (d.class) {
                if (HC == null) {
                    HC = new d();
                }
            }
        }
        return HC;
    }

    private d() {
        this.HD = null;
        this.HD = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.HD.put(str, aVar);
    }

    public synchronized a br(String str) {
        return this.HD.get(str);
    }

    public synchronized void bs(String str) {
        this.HD.remove(str);
    }

    public int lr() {
        return this.HD.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy HE;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.HE = serviceProxy;
            this.mIntent = intent;
        }
    }
}

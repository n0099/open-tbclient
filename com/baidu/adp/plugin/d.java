package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqi;
    private Map<String, a> aqj;

    public static d qi() {
        if (aqi == null) {
            synchronized (d.class) {
                if (aqi == null) {
                    aqi = new d();
                }
            }
        }
        return aqi;
    }

    private d() {
        this.aqj = null;
        this.aqj = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aqj.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aqj.get(str);
    }

    public synchronized void bg(String str) {
        this.aqj.remove(str);
    }

    public int qj() {
        return this.aqj.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aqk;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aqk = serviceProxy;
            this.mIntent = intent;
        }
    }
}

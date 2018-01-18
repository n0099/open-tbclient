package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d aqh;
    private Map<String, a> aqi;

    public static d qi() {
        if (aqh == null) {
            synchronized (d.class) {
                if (aqh == null) {
                    aqh = new d();
                }
            }
        }
        return aqh;
    }

    private d() {
        this.aqi = null;
        this.aqi = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.aqi.put(str, aVar);
    }

    public synchronized a bf(String str) {
        return this.aqi.get(str);
    }

    public synchronized void bg(String str) {
        this.aqi.remove(str);
    }

    public int qj() {
        return this.aqi.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy aqj;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.aqj = serviceProxy;
            this.mIntent = intent;
        }
    }
}

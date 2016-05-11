package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g tv;
    private Map<String, a> tw;

    public static g gW() {
        if (tv == null) {
            synchronized (g.class) {
                if (tv == null) {
                    tv = new g();
                }
            }
        }
        return tv;
    }

    private g() {
        this.tw = null;
        this.tw = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.tw.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.tw.get(str);
    }

    public synchronized void aY(String str) {
        this.tw.remove(str);
    }

    public int gX() {
        return this.tw.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy tx;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.tx = serviceProxy;
            this.mIntent = intent;
        }
    }
}

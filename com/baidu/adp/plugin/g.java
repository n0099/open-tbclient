package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g wm;
    private Map<String, a> wn;

    public static g hS() {
        if (wm == null) {
            synchronized (g.class) {
                if (wm == null) {
                    wm = new g();
                }
            }
        }
        return wm;
    }

    private g() {
        this.wn = null;
        this.wn = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.wn.put(str, aVar);
    }

    public synchronized a aZ(String str) {
        return this.wn.get(str);
    }

    public synchronized void ba(String str) {
        this.wn.remove(str);
    }

    public int hT() {
        return this.wn.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy wo;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.wo = serviceProxy;
            this.mIntent = intent;
        }
    }
}

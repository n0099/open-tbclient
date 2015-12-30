package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g CO;
    private Map<String, a> CP;

    public static g kK() {
        if (CO == null) {
            synchronized (g.class) {
                if (CO == null) {
                    CO = new g();
                }
            }
        }
        return CO;
    }

    private g() {
        this.CP = null;
        this.CP = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.CP.put(str, aVar);
    }

    public synchronized a bg(String str) {
        return this.CP.get(str);
    }

    public synchronized void bh(String str) {
        this.CP.remove(str);
    }

    public int kL() {
        return this.CP.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy CQ;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.CQ = serviceProxy;
            this.mIntent = intent;
        }
    }
}

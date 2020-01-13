package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d wG;
    private Map<String, a> wH;

    public static d is() {
        if (wG == null) {
            synchronized (d.class) {
                if (wG == null) {
                    wG = new d();
                }
            }
        }
        return wG;
    }

    private d() {
        this.wH = null;
        this.wH = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.wH.put(str, aVar);
    }

    public synchronized a aM(String str) {
        return this.wH.get(str);
    }

    public synchronized void aN(String str) {
        this.wH.remove(str);
    }

    public int it() {
        return this.wH.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy wI;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.wI = serviceProxy;
            this.mIntent = intent;
        }
    }
}

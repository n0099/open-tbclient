package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g wd;
    private Map<String, a> we;

    public static g hQ() {
        if (wd == null) {
            synchronized (g.class) {
                if (wd == null) {
                    wd = new g();
                }
            }
        }
        return wd;
    }

    private g() {
        this.we = null;
        this.we = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.we.put(str, aVar);
    }

    public synchronized a aY(String str) {
        return this.we.get(str);
    }

    public synchronized void aZ(String str) {
        this.we.remove(str);
    }

    public int hR() {
        return this.we.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy wf;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.wf = serviceProxy;
            this.mIntent = intent;
        }
    }
}

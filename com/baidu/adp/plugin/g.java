package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g Dr;
    private Map<String, a> Ds;

    public static g iK() {
        if (Dr == null) {
            synchronized (g.class) {
                if (Dr == null) {
                    Dr = new g();
                }
            }
        }
        return Dr;
    }

    private g() {
        this.Ds = null;
        this.Ds = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Ds.put(str, aVar);
    }

    public synchronized a aS(String str) {
        return this.Ds.get(str);
    }

    public synchronized void aT(String str) {
        this.Ds.remove(str);
    }

    public int iL() {
        return this.Ds.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Dt;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Dt = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static volatile g tx;
    private Map<String, a> ty;

    public static g gY() {
        if (tx == null) {
            synchronized (g.class) {
                if (tx == null) {
                    tx = new g();
                }
            }
        }
        return tx;
    }

    private g() {
        this.ty = null;
        this.ty = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.ty.put(str, aVar);
    }

    public synchronized a aX(String str) {
        return this.ty.get(str);
    }

    public synchronized void aY(String str) {
        this.ty.remove(str);
    }

    public int gZ() {
        return this.ty.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public Intent mIntent;
        public ServiceProxy tz;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.tz = serviceProxy;
            this.mIntent = intent;
        }
    }
}

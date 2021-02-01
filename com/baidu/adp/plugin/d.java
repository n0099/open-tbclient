package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d SX;
    private Map<String, a> SY;

    public static d oI() {
        if (SX == null) {
            synchronized (d.class) {
                if (SX == null) {
                    SX = new d();
                }
            }
        }
        return SX;
    }

    private d() {
        this.SY = null;
        this.SY = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.SY.put(str, aVar);
    }

    public synchronized a ck(String str) {
        return this.SY.get(str);
    }

    public synchronized void cl(String str) {
        this.SY.remove(str);
    }

    public int oJ() {
        return this.SY.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy SZ;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.SZ = serviceProxy;
            this.mIntent = intent;
        }
    }
}

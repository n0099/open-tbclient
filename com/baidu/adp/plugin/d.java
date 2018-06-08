package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d GK;
    private Map<String, a> GL;

    public static d lc() {
        if (GK == null) {
            synchronized (d.class) {
                if (GK == null) {
                    GK = new d();
                }
            }
        }
        return GK;
    }

    private d() {
        this.GL = null;
        this.GL = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.GL.put(str, aVar);
    }

    public synchronized a bo(String str) {
        return this.GL.get(str);
    }

    public synchronized void bp(String str) {
        this.GL.remove(str);
    }

    public int ld() {
        return this.GL.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy GM;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.GM = serviceProxy;
            this.mIntent = intent;
        }
    }
}

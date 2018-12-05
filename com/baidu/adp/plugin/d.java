package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d JK;
    private Map<String, a> JL;

    public static d mr() {
        if (JK == null) {
            synchronized (d.class) {
                if (JK == null) {
                    JK = new d();
                }
            }
        }
        return JK;
    }

    private d() {
        this.JL = null;
        this.JL = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.JL.put(str, aVar);
    }

    public synchronized a bH(String str) {
        return this.JL.get(str);
    }

    public synchronized void bI(String str) {
        this.JL.remove(str);
    }

    public int ms() {
        return this.JL.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy JM;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.JM = serviceProxy;
            this.mIntent = intent;
        }
    }
}

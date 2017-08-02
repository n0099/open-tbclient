package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d CV;
    private Map<String, a> CW;

    public static d iL() {
        if (CV == null) {
            synchronized (d.class) {
                if (CV == null) {
                    CV = new d();
                }
            }
        }
        return CV;
    }

    private d() {
        this.CW = null;
        this.CW = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.CW.put(str, aVar);
    }

    public synchronized a aU(String str) {
        return this.CW.get(str);
    }

    public synchronized void aV(String str) {
        this.CW.remove(str);
    }

    public int iM() {
        return this.CW.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy CX;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.CX = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d JS;
    private Map<String, a> JT;

    public static d mw() {
        if (JS == null) {
            synchronized (d.class) {
                if (JS == null) {
                    JS = new d();
                }
            }
        }
        return JS;
    }

    private d() {
        this.JT = null;
        this.JT = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.JT.put(str, aVar);
    }

    public synchronized a bH(String str) {
        return this.JT.get(str);
    }

    public synchronized void bI(String str) {
        this.JT.remove(str);
    }

    public int mx() {
        return this.JT.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy JU;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.JU = serviceProxy;
            this.mIntent = intent;
        }
    }
}

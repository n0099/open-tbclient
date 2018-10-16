package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d JH;
    private Map<String, a> JI;

    public static d mu() {
        if (JH == null) {
            synchronized (d.class) {
                if (JH == null) {
                    JH = new d();
                }
            }
        }
        return JH;
    }

    private d() {
        this.JI = null;
        this.JI = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.JI.put(str, aVar);
    }

    public synchronized a bH(String str) {
        return this.JI.get(str);
    }

    public synchronized void bI(String str) {
        this.JI.remove(str);
    }

    public int mv() {
        return this.JI.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy JJ;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.JJ = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d HM;
    private Map<String, a> HN;

    public static d lG() {
        if (HM == null) {
            synchronized (d.class) {
                if (HM == null) {
                    HM = new d();
                }
            }
        }
        return HM;
    }

    private d() {
        this.HN = null;
        this.HN = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.HN.put(str, aVar);
    }

    public synchronized a bt(String str) {
        return this.HN.get(str);
    }

    public synchronized void bu(String str) {
        this.HN.remove(str);
    }

    public int lH() {
        return this.HN.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy HO;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.HO = serviceProxy;
            this.mIntent = intent;
        }
    }
}

package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Qn;
    private Map<String, a> Qo;

    public static d nm() {
        if (Qn == null) {
            synchronized (d.class) {
                if (Qn == null) {
                    Qn = new d();
                }
            }
        }
        return Qn;
    }

    private d() {
        this.Qo = null;
        this.Qo = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.Qo.put(str, aVar);
    }

    public synchronized a cf(String str) {
        return this.Qo.get(str);
    }

    public synchronized void cg(String str) {
        this.Qo.remove(str);
    }

    public int nn() {
        return this.Qo.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy Qp;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.Qp = serviceProxy;
            this.mIntent = intent;
        }
    }
}

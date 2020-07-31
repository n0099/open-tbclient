package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d QN;
    private Map<String, a> QO;

    public static d nD() {
        if (QN == null) {
            synchronized (d.class) {
                if (QN == null) {
                    QN = new d();
                }
            }
        }
        return QN;
    }

    private d() {
        this.QO = null;
        this.QO = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.QO.put(str, aVar);
    }

    public synchronized a ce(String str) {
        return this.QO.get(str);
    }

    public synchronized void cf(String str) {
        this.QO.remove(str);
    }

    public int nE() {
        return this.QO.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy QP;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.QP = serviceProxy;
            this.mIntent = intent;
        }
    }
}

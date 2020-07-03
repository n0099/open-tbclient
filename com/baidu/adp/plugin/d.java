package com.baidu.adp.plugin;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d QP;
    private Map<String, a> QR;

    public static d nC() {
        if (QP == null) {
            synchronized (d.class) {
                if (QP == null) {
                    QP = new d();
                }
            }
        }
        return QP;
    }

    private d() {
        this.QR = null;
        this.QR = new HashMap();
    }

    public synchronized void a(String str, a aVar) {
        this.QR.put(str, aVar);
    }

    public synchronized a cg(String str) {
        return this.QR.get(str);
    }

    public synchronized void ch(String str) {
        this.QR.remove(str);
    }

    public int nD() {
        return this.QR.size();
    }

    /* loaded from: classes.dex */
    public static class a {
        public ServiceProxy QS;
        public Intent mIntent;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.QS = serviceProxy;
            this.mIntent = intent;
        }
    }
}

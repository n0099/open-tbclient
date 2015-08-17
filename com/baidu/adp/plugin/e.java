package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cr = null;
    private HashMap<String, Class<?>> Cq;
    private int Cs = 0;
    private int Ct = 0;

    public static e kF() {
        if (Cr == null) {
            synchronized (e.class) {
                if (Cr == null) {
                    Cr = new e();
                }
            }
        }
        return Cr;
    }

    private e() {
        this.Cq = null;
        this.Cq = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cq.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.Ct == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Ct++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Ct;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.Cs == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.Cs++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Cs;
            }
            try {
                cls2 = Class.forName(str);
                this.Cq.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

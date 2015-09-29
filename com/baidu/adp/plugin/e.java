package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cs = null;
    private HashMap<String, Class<?>> Cr;
    private int Ct = 0;
    private int Cu = 0;

    public static e kD() {
        if (Cs == null) {
            synchronized (e.class) {
                if (Cs == null) {
                    Cs = new e();
                }
            }
        }
        return Cs;
    }

    private e() {
        this.Cr = null;
        this.Cr = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cr.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.Cu == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cu++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Cu;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.Ct == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.Ct++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Ct;
            }
            try {
                cls2 = Class.forName(str);
                this.Cr.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

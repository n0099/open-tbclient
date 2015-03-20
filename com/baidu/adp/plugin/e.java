package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e CT = null;
    private HashMap<String, Class<?>> CS;
    private int CU = 0;
    private int CV = 0;

    public static e ks() {
        if (CT == null) {
            synchronized (e.class) {
                if (CT == null) {
                    CT = new e();
                }
            }
        }
        return CT;
    }

    private e() {
        this.CS = null;
        this.CS = new HashMap<>();
    }

    public Class<?> n(Class<?> cls) {
        String str;
        Class<?> cls2 = this.CS.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.CV == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.CV++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.CV;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.CU == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.CU++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.CU;
            }
            try {
                cls2 = Class.forName(str);
                this.CS.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

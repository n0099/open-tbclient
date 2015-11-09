package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private static volatile f Ct = null;
    private HashMap<String, Class<?>> Cs;
    private int Cu = 0;
    private int Cv = 0;

    public static f kE() {
        if (Ct == null) {
            synchronized (f.class) {
                if (Ct == null) {
                    Ct = new f();
                }
            }
        }
        return Ct;
    }

    private f() {
        this.Cs = null;
        this.Cs = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cs.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.Cv == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cv++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Cv;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.Cu == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.Cu++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Cu;
            }
            try {
                cls2 = Class.forName(str);
                this.Cs.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

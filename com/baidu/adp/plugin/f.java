package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private static volatile f CA = null;
    private int CB = 0;
    private int CC = 0;
    private HashMap<String, Class<?>> Cz;

    public static f kF() {
        if (CA == null) {
            synchronized (f.class) {
                if (CA == null) {
                    CA = new f();
                }
            }
        }
        return CA;
    }

    private f() {
        this.Cz = null;
        this.Cz = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cz.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.CC == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.CC++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.CC;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.CB == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.CB++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.CB;
            }
            try {
                cls2 = Class.forName(str);
                this.Cz.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

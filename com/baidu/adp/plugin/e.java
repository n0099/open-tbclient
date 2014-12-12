package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e sb = null;
    private HashMap<String, Class<?>> sa;
    private int sc = 0;
    private int sd = 0;

    public static e hh() {
        if (sb == null) {
            synchronized (e.class) {
                if (sb == null) {
                    sb = new e();
                }
            }
        }
        return sb;
    }

    private e() {
        this.sa = null;
        this.sa = new HashMap<>();
    }

    public Class<?> n(Class<?> cls) {
        String str;
        Class<?> cls2 = this.sa.get(cls.getName());
        if (cls2 == null) {
            if (g.class.isAssignableFrom(cls)) {
                if (this.sc == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.sc++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.sc;
            } else if (!com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.sd == 10) {
                BdLog.e("can not find service,Has started 10 Remoteservice");
                return null;
            } else {
                this.sd++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.sd;
            }
            try {
                cls2 = Class.forName(str);
                this.sa.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

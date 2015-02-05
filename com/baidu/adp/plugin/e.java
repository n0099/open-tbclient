package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e sd = null;
    private HashMap<String, Class<?>> sc;
    private int se = 0;
    private int sf = 0;

    public static e gY() {
        if (sd == null) {
            synchronized (e.class) {
                if (sd == null) {
                    sd = new e();
                }
            }
        }
        return sd;
    }

    private e() {
        this.sc = null;
        this.sc = new HashMap<>();
    }

    public Class<?> n(Class<?> cls) {
        String str;
        Class<?> cls2 = this.sc.get(cls.getName());
        if (cls2 == null) {
            if (g.class.isAssignableFrom(cls)) {
                if (this.se == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.se++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.se;
            } else if (!com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.sf == 10) {
                BdLog.e("can not find service,Has started 10 Remoteservice");
                return null;
            } else {
                this.sf++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.sf;
            }
            try {
                cls2 = Class.forName(str);
                this.sc.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

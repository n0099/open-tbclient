package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.h;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cr = null;
    private Map<Class<?>, Class<?>> Cn;
    private Map<Class<?>, Class<?>> Co;
    private int Cp = 0;
    private int Cq = 0;

    public static e kD() {
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
        this.Cn = null;
        this.Co = null;
        this.Cn = new HashMap();
        this.Co = new HashMap();
    }

    public Class<?> f(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.Cn.get(cls);
            if (cls2 == null) {
                if (this.Cp == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.Cp++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.Cp);
                    this.Cn.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (com.baidu.adp.plugin.pluginBase.f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.Co.get(cls);
            if (cls3 == null) {
                if (this.Cq == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.Cq++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.Cq);
                    this.Co.put(cls, cls3);
                    return cls3;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls3;
                }
            }
            return cls3;
        } else if (com.baidu.adp.plugin.pluginBase.d.class.isAssignableFrom(cls)) {
            return RemoteActivityProxy.class;
        } else {
            if (com.baidu.adp.plugin.pluginBase.c.class.isAssignableFrom(cls)) {
                return ActivityProxy.class;
            }
            return null;
        }
    }
}

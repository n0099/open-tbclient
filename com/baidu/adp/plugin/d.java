package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.f;
import com.baidu.adp.plugin.pluginBase.h;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static volatile d Cp = null;
    private Map<Class<?>, Class<?>> Cl;
    private Map<Class<?>, Class<?>> Cm;
    private int Cn = 0;
    private int Co = 0;

    public static d kE() {
        if (Cp == null) {
            synchronized (d.class) {
                if (Cp == null) {
                    Cp = new d();
                }
            }
        }
        return Cp;
    }

    private d() {
        this.Cl = null;
        this.Cm = null;
        this.Cl = new HashMap();
        this.Cm = new HashMap();
    }

    public Class<?> f(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.Cl.get(cls);
            if (cls2 == null) {
                if (this.Cn == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.Cn++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.Cn);
                    this.Cl.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.Cm.get(cls);
            if (cls3 == null) {
                if (this.Co == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.Co++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.Co);
                    this.Cm.put(cls, cls3);
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

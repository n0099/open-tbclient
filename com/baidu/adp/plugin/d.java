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
    private static volatile d se = null;
    private Map<Class<?>, Class<?>> sa;
    private Map<Class<?>, Class<?>> sb;
    private int sc = 0;
    private int sd = 0;

    public static d he() {
        if (se == null) {
            synchronized (d.class) {
                if (se == null) {
                    se = new d();
                }
            }
        }
        return se;
    }

    private d() {
        this.sa = null;
        this.sb = null;
        this.sa = new HashMap();
        this.sb = new HashMap();
    }

    public Class<?> m(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.sa.get(cls);
            if (cls2 == null) {
                if (this.sc == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.sc++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.sc);
                    this.sa.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.sb.get(cls);
            if (cls3 == null) {
                if (this.sd == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.sd++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.sd);
                    this.sb.put(cls, cls3);
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
            return ActivityProxy.class;
        }
    }
}

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
    private static volatile d CH = null;
    private Map<Class<?>, Class<?>> CC;
    private Map<Class<?>, Class<?>> CE;
    private int CF = 0;
    private int CG = 0;

    public static d kL() {
        if (CH == null) {
            synchronized (d.class) {
                if (CH == null) {
                    CH = new d();
                }
            }
        }
        return CH;
    }

    private d() {
        this.CC = null;
        this.CE = null;
        this.CC = new HashMap();
        this.CE = new HashMap();
    }

    public Class<?> m(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.CC.get(cls);
            if (cls2 == null) {
                if (this.CF == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.CF++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.CF);
                    this.CC.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.CE.get(cls);
            if (cls3 == null) {
                if (this.CG == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.CG++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.CG);
                    this.CE.put(cls, cls3);
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

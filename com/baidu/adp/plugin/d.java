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
    private static volatile d CR = null;
    private Map<Class<?>, Class<?>> CM;
    private Map<Class<?>, Class<?>> CO;
    private int CP = 0;
    private int CQ = 0;

    public static d kr() {
        if (CR == null) {
            synchronized (d.class) {
                if (CR == null) {
                    CR = new d();
                }
            }
        }
        return CR;
    }

    private d() {
        this.CM = null;
        this.CO = null;
        this.CM = new HashMap();
        this.CO = new HashMap();
    }

    public Class<?> m(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.CM.get(cls);
            if (cls2 == null) {
                if (this.CP == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.CP++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.CP);
                    this.CM.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.CO.get(cls);
            if (cls3 == null) {
                if (this.CQ == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.CQ++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.CQ);
                    this.CO.put(cls, cls3);
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

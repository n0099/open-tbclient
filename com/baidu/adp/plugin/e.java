package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.h;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cy = null;
    private Map<Class<?>, Class<?>> Cu;
    private Map<Class<?>, Class<?>> Cv;
    private int Cw = 0;
    private int Cx = 0;

    public static e kE() {
        if (Cy == null) {
            synchronized (e.class) {
                if (Cy == null) {
                    Cy = new e();
                }
            }
        }
        return Cy;
    }

    private e() {
        this.Cu = null;
        this.Cv = null;
        this.Cu = new HashMap();
        this.Cv = new HashMap();
    }

    public Class<?> g(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.Cu.get(cls);
            if (cls2 == null) {
                if (this.Cw == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.Cw++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.Cw);
                    this.Cu.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (com.baidu.adp.plugin.pluginBase.f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.Cv.get(cls);
            if (cls3 == null) {
                if (this.Cx == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.Cx++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.Cx);
                    this.Cv.put(cls, cls3);
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

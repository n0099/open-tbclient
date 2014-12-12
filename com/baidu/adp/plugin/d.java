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
    private static volatile d rZ = null;
    private Map<Class<?>, Class<?>> rV;
    private Map<Class<?>, Class<?>> rW;
    private int rX = 0;
    private int rY = 0;

    public static d hg() {
        if (rZ == null) {
            synchronized (d.class) {
                if (rZ == null) {
                    rZ = new d();
                }
            }
        }
        return rZ;
    }

    private d() {
        this.rV = null;
        this.rW = null;
        this.rV = new HashMap();
        this.rW = new HashMap();
    }

    public Class<?> m(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (h.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.rV.get(cls);
            if (cls2 == null) {
                if (this.rX == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.rX++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.rX);
                    this.rV.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (f.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.rW.get(cls);
            if (cls3 == null) {
                if (this.rY == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.rY++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.rY);
                    this.rW.put(cls, cls3);
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

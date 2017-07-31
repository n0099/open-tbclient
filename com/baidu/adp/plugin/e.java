package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Ey = null;
    private HashMap<String, Class<?>> Ex;
    private int Ez = 0;
    private int EA = 0;

    public static e iX() {
        if (Ey == null) {
            synchronized (e.class) {
                if (Ey == null) {
                    Ey = new e();
                }
            }
        }
        return Ey;
    }

    private e() {
        this.Ex = null;
        this.Ex = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Ex.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.EA == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.EA++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.EA;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Ez == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Ez++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Ez;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Ex.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

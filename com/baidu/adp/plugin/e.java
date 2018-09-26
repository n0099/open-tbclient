package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Jm = null;
    private HashMap<String, Class<?>> Jl;
    private int Jn = 0;
    private int Jo = 0;

    public static e mm() {
        if (Jm == null) {
            synchronized (e.class) {
                if (Jm == null) {
                    Jm = new e();
                }
            }
        }
        return Jm;
    }

    private e() {
        this.Jl = null;
        this.Jl = new HashMap<>();
    }

    public Class<?> k(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Jl.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Jo == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Jo++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Jo;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Jn == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Jn++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Jn;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Jl.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

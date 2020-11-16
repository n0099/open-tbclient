package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Si = null;
    private HashMap<String, Class<?>> Sh;
    private int Sj = 0;
    private int Sk = 0;

    public static e pk() {
        if (Si == null) {
            synchronized (e.class) {
                if (Si == null) {
                    Si = new e();
                }
            }
        }
        return Si;
    }

    private e() {
        this.Sh = null;
        this.Sh = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Sh.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Sk == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Sk++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Sk;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Sj == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Sj++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Sj;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Sh.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

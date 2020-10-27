package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Sh = null;
    private HashMap<String, Class<?>> Sg;
    private int Si = 0;
    private int Sj = 0;

    public static e pk() {
        if (Sh == null) {
            synchronized (e.class) {
                if (Sh == null) {
                    Sh = new e();
                }
            }
        }
        return Sh;
    }

    private e() {
        this.Sg = null;
        this.Sg = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Sg.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Sj == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Sj++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Sj;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Si == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Si++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Si;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Sg.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

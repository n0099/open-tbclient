package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Sg = null;
    private HashMap<String, Class<?>> Sf;
    private int Sh = 0;
    private int Si = 0;

    public static e pk() {
        if (Sg == null) {
            synchronized (e.class) {
                if (Sg == null) {
                    Sg = new e();
                }
            }
        }
        return Sg;
    }

    private e() {
        this.Sf = null;
        this.Sf = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Sf.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Si == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Si++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Si;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Sh == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Sh++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Sh;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Sf.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

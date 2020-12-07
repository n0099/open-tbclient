package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Td = null;
    private HashMap<String, Class<?>> Tc;
    private int Te = 0;
    private int Tf = 0;

    public static e pl() {
        if (Td == null) {
            synchronized (e.class) {
                if (Td == null) {
                    Td = new e();
                }
            }
        }
        return Td;
    }

    private e() {
        this.Tc = null;
        this.Tc = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Tc.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Tf == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Tf++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Tf;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Te == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Te++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Te;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Tc.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

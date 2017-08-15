package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e EA = null;
    private int EB = 0;
    private int EC = 0;
    private HashMap<String, Class<?>> Ez;

    public static e iX() {
        if (EA == null) {
            synchronized (e.class) {
                if (EA == null) {
                    EA = new e();
                }
            }
        }
        return EA;
    }

    private e() {
        this.Ez = null;
        this.Ez = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Ez.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.EC == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.EC++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.EC;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.EB == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.EB++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.EB;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Ez.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

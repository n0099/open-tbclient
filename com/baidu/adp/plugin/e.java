package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e uD = null;
    private HashMap<String, Class<?>> uC;
    private int uE = 0;
    private int uF = 0;

    public static e ia() {
        if (uD == null) {
            synchronized (e.class) {
                if (uD == null) {
                    uD = new e();
                }
            }
        }
        return uD;
    }

    private e() {
        this.uC = null;
        this.uC = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.uC.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.uF == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.uF++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.uF;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.uE == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.uE++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.uE;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.uC.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

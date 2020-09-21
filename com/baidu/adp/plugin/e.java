package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e RP = null;
    private HashMap<String, Class<?>> RO;
    private int RQ = 0;
    private int RR = 0;

    public static e pk() {
        if (RP == null) {
            synchronized (e.class) {
                if (RP == null) {
                    RP = new e();
                }
            }
        }
        return RP;
    }

    private e() {
        this.RO = null;
        this.RO = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.RO.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.RR == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.RR++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.RR;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.RQ == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.RQ++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.RQ;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.RO.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

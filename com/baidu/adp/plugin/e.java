package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e aqe = null;
    private HashMap<String, Class<?>> aqd;
    private int aqf = 0;
    private int aqg = 0;

    public static e ql() {
        if (aqe == null) {
            synchronized (e.class) {
                if (aqe == null) {
                    aqe = new e();
                }
            }
        }
        return aqe;
    }

    private e() {
        this.aqd = null;
        this.aqd = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.aqd.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.aqg == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.aqg++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.aqg;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.aqf == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.aqf++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.aqf;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.aqd.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

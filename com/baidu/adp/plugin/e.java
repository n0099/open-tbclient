package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e aqf = null;
    private HashMap<String, Class<?>> aqe;
    private int aqg = 0;
    private int aqh = 0;

    public static e ql() {
        if (aqf == null) {
            synchronized (e.class) {
                if (aqf == null) {
                    aqf = new e();
                }
            }
        }
        return aqf;
    }

    private e() {
        this.aqe = null;
        this.aqe = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.aqe.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.aqh == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.aqh++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.aqh;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.aqg == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.aqg++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.aqg;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.aqe.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

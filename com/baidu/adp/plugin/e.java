package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cu = null;
    private HashMap<String, Class<?>> Ct;
    private int Cv = 0;
    private int Cw = 0;

    public static e iP() {
        if (Cu == null) {
            synchronized (e.class) {
                if (Cu == null) {
                    Cu = new e();
                }
            }
        }
        return Cu;
    }

    private e() {
        this.Ct = null;
        this.Ct = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Ct.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Cw == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cw++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Cw;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Cv == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Cv++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Cv;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Ct.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

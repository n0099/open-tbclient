package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cg = null;
    private HashMap<String, Class<?>> Cf;
    private int Ch = 0;
    private int Ci = 0;

    public static e iL() {
        if (Cg == null) {
            synchronized (e.class) {
                if (Cg == null) {
                    Cg = new e();
                }
            }
        }
        return Cg;
    }

    private e() {
        this.Cf = null;
        this.Cf = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cf.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Ci == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Ci++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Ci;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Ch == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Ch++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Ch;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Cf.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

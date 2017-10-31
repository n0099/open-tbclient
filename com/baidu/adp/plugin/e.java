package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Ch = null;
    private HashMap<String, Class<?>> Cg;
    private int Ci = 0;
    private int Cj = 0;

    public static e iL() {
        if (Ch == null) {
            synchronized (e.class) {
                if (Ch == null) {
                    Ch = new e();
                }
            }
        }
        return Ch;
    }

    private e() {
        this.Cg = null;
        this.Cg = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cg.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Cj == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cj++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Cj;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Ci == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Ci++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Ci;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Cg.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

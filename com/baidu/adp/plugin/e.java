package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Qh = null;
    private HashMap<String, Class<?>> Qg;
    private int Qi = 0;
    private int Qj = 0;

    public static e nm() {
        if (Qh == null) {
            synchronized (e.class) {
                if (Qh == null) {
                    Qh = new e();
                }
            }
        }
        return Qh;
    }

    private e() {
        this.Qg = null;
        this.Qg = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Qg.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Qj == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Qj++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Qj;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Qi == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Qi++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Qi;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Qg.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

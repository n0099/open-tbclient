package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Qc = null;
    private HashMap<String, Class<?>> Qb;
    private int Qe = 0;
    private int Qf = 0;

    public static e nm() {
        if (Qc == null) {
            synchronized (e.class) {
                if (Qc == null) {
                    Qc = new e();
                }
            }
        }
        return Qc;
    }

    private e() {
        this.Qb = null;
        this.Qb = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Qb.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Qf == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Qf++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Qf;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Qe == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Qe++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Qe;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Qb.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

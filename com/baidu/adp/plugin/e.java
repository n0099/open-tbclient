package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Rv = null;
    private HashMap<String, Class<?>> Ru;
    private int Rw = 0;
    private int Rx = 0;

    public static e pf() {
        if (Rv == null) {
            synchronized (e.class) {
                if (Rv == null) {
                    Rv = new e();
                }
            }
        }
        return Rv;
    }

    private e() {
        this.Ru = null;
        this.Ru = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Ru.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Rx == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Rx++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Rx;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Rw == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Rw++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Rw;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Ru.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

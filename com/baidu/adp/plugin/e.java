package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Qr = null;
    private HashMap<String, Class<?>> Qq;
    private int Qs = 0;
    private int Qt = 0;

    public static e no() {
        if (Qr == null) {
            synchronized (e.class) {
                if (Qr == null) {
                    Qr = new e();
                }
            }
        }
        return Qr;
    }

    private e() {
        this.Qq = null;
        this.Qq = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Qq.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Qt == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Qt++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Qt;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Qs == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Qs++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Qs;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Qq.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

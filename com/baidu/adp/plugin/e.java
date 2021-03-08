package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Uv = null;
    private HashMap<String, Class<?>> Uu;
    private int Uw = 0;
    private int Ux = 0;

    public static e oK() {
        if (Uv == null) {
            synchronized (e.class) {
                if (Uv == null) {
                    Uv = new e();
                }
            }
        }
        return Uv;
    }

    private e() {
        this.Uu = null;
        this.Uu = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Uu.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Ux == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Ux++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Ux;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Uw == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Uw++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Uw;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Uu.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

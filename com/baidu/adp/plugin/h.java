package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h Dh = null;
    private HashMap<String, Class<?>> Dg;
    private int Di = 0;
    private int Dj = 0;

    public static h kL() {
        if (Dh == null) {
            synchronized (h.class) {
                if (Dh == null) {
                    Dh = new h();
                }
            }
        }
        return Dh;
    }

    private h() {
        this.Dg = null;
        this.Dg = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Dg.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Dj == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Dj++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Dj;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Di == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Di++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Di;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Dg.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

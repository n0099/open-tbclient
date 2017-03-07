package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h Dv = null;
    private HashMap<String, Class<?>> Du;
    private int Dw = 0;
    private int Dx = 0;

    public static h iM() {
        if (Dv == null) {
            synchronized (h.class) {
                if (Dv == null) {
                    Dv = new h();
                }
            }
        }
        return Dv;
    }

    private h() {
        this.Du = null;
        this.Du = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Du.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Dx == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Dx++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Dx;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Dw == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Dw++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Dw;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Du.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

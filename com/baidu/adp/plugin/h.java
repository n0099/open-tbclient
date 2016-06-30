package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h tB = null;
    private HashMap<String, Class<?>> tA;
    private int tC = 0;
    private int tD = 0;

    public static h ha() {
        if (tB == null) {
            synchronized (h.class) {
                if (tB == null) {
                    tB = new h();
                }
            }
        }
        return tB;
    }

    private h() {
        this.tA = null;
        this.tA = new HashMap<>();
    }

    public Class<?> p(Class<?> cls) {
        String str;
        Class<?> cls2 = this.tA.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.tD == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.tD++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.tD;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.tC == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.tC++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.tC;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.tA.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

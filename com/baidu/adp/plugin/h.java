package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h CZ = null;
    private HashMap<String, Class<?>> CY;
    private int Da = 0;
    private int Db = 0;

    public static h iP() {
        if (CZ == null) {
            synchronized (h.class) {
                if (CZ == null) {
                    CZ = new h();
                }
            }
        }
        return CZ;
    }

    private h() {
        this.CY = null;
        this.CY = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.CY.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Db == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Db++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.Db;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Da == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Da++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Da;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.CY.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

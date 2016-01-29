package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h Dc = null;
    private HashMap<String, Class<?>> Db;
    private int Dd = 0;
    private int De = 0;

    public static h kW() {
        if (Dc == null) {
            synchronized (h.class) {
                if (Dc == null) {
                    Dc = new h();
                }
            }
        }
        return Dc;
    }

    private h() {
        this.Db = null;
        this.Db = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Db.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.De == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.De++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.De;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Dd == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Dd++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.Dd;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Db.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

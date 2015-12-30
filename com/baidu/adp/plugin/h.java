package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h CS = null;
    private HashMap<String, Class<?>> CR;
    private int CT = 0;
    private int CU = 0;

    public static h kM() {
        if (CS == null) {
            synchronized (h.class) {
                if (CS == null) {
                    CS = new h();
                }
            }
        }
        return CS;
    }

    private h() {
        this.CR = null;
        this.CR = new HashMap<>();
    }

    public Class<?> g(Class<?> cls) {
        String str;
        Class<?> cls2 = this.CR.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.CU == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.CU++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.CU;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.CT == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.CT++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.CT;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.CR.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

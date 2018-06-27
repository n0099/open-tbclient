package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e GQ = null;
    private HashMap<String, Class<?>> GP;
    private int GR = 0;
    private int GU = 0;

    public static e le() {
        if (GQ == null) {
            synchronized (e.class) {
                if (GQ == null) {
                    GQ = new e();
                }
            }
        }
        return GQ;
    }

    private e() {
        this.GP = null;
        this.GP = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.GP.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.GU == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.GU++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.GU;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.GR == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.GR++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.GR;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.GP.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

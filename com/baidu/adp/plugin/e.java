package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e xb = null;
    private HashMap<String, Class<?>> xa;
    private int xc = 0;
    private int xd = 0;

    public static e iJ() {
        if (xb == null) {
            synchronized (e.class) {
                if (xb == null) {
                    xb = new e();
                }
            }
        }
        return xb;
    }

    private e() {
        this.xa = null;
        this.xa = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.xa.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.xd == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.xd++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.xd;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.xc == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.xc++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.xc;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.xa.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e tZ = null;
    private HashMap<String, Class<?>> tY;
    private int ub = 0;
    private int uc = 0;

    public static e ia() {
        if (tZ == null) {
            synchronized (e.class) {
                if (tZ == null) {
                    tZ = new e();
                }
            }
        }
        return tZ;
    }

    private e() {
        this.tY = null;
        this.tY = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.tY.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.uc == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.uc++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.uc;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.ub == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.ub++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.ub;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.tY.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

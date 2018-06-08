package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e GO = null;
    private HashMap<String, Class<?>> GN;
    private int GP = 0;
    private int GQ = 0;

    public static e le() {
        if (GO == null) {
            synchronized (e.class) {
                if (GO == null) {
                    GO = new e();
                }
            }
        }
        return GO;
    }

    private e() {
        this.GN = null;
        this.GN = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.GN.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.GQ == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.GQ++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.GQ;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.GP == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.GP++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.GP;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.GN.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

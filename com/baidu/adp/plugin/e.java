package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e JL = null;
    private HashMap<String, Class<?>> JK;
    private int JM = 0;
    private int JN = 0;

    public static e mw() {
        if (JL == null) {
            synchronized (e.class) {
                if (JL == null) {
                    JL = new e();
                }
            }
        }
        return JL;
    }

    private e() {
        this.JK = null;
        this.JK = new HashMap<>();
    }

    public Class<?> k(Class<?> cls) {
        String str;
        Class<?> cls2 = this.JK.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.JN == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.JN++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.JN;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.JM == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.JM++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.JM;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.JK.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

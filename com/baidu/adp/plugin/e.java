package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e JO = null;
    private HashMap<String, Class<?>> JN;
    private int JP = 0;
    private int JQ = 0;

    public static e mt() {
        if (JO == null) {
            synchronized (e.class) {
                if (JO == null) {
                    JO = new e();
                }
            }
        }
        return JO;
    }

    private e() {
        this.JN = null;
        this.JN = new HashMap<>();
    }

    public Class<?> k(Class<?> cls) {
        String str;
        Class<?> cls2 = this.JN.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.JQ == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.JQ++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.JQ;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.JP == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.JP++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.JP;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.JN.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

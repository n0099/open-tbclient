package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e aql = null;
    private HashMap<String, Class<?>> aqk;
    private int aqm = 0;
    private int aqn = 0;

    public static e qk() {
        if (aql == null) {
            synchronized (e.class) {
                if (aql == null) {
                    aql = new e();
                }
            }
        }
        return aql;
    }

    private e() {
        this.aqk = null;
        this.aqk = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.aqk.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.aqn == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.aqn++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.aqn;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.aqm == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.aqm++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.aqm;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.aqk.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

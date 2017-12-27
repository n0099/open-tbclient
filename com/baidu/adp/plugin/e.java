package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e aqm = null;
    private HashMap<String, Class<?>> aql;
    private int aqn = 0;
    private int aqo = 0;

    public static e qk() {
        if (aqm == null) {
            synchronized (e.class) {
                if (aqm == null) {
                    aqm = new e();
                }
            }
        }
        return aqm;
    }

    private e() {
        this.aql = null;
        this.aql = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.aql.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.aqo == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.aqo++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.aqo;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.aqn == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.aqn++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.aqn;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.aql.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

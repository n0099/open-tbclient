package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e AH = null;
    private HashMap<String, Class<?>> AG;
    private int AI = 0;
    private int AJ = 0;

    public static e iq() {
        if (AH == null) {
            synchronized (e.class) {
                if (AH == null) {
                    AH = new e();
                }
            }
        }
        return AH;
    }

    private e() {
        this.AG = null;
        this.AG = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.AG.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.AJ == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.AJ++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.AJ;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.AI == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.AI++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.AI;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.AG.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

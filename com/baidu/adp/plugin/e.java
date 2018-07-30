package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e GN = null;
    private HashMap<String, Class<?>> GM;
    private int GO = 0;
    private int GP = 0;

    public static e lg() {
        if (GN == null) {
            synchronized (e.class) {
                if (GN == null) {
                    GN = new e();
                }
            }
        }
        return GN;
    }

    private e() {
        this.GM = null;
        this.GM = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.GM.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.GP == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.GP++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.GP;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.GO == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.GO++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.GO;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.GM.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

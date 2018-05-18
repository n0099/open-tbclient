package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e AG = null;
    private HashMap<String, Class<?>> AF;
    private int AH = 0;
    private int AI = 0;

    public static e iq() {
        if (AG == null) {
            synchronized (e.class) {
                if (AG == null) {
                    AG = new e();
                }
            }
        }
        return AG;
    }

    private e() {
        this.AF = null;
        this.AF = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.AF.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.AI == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.AI++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.AI;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.AH == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.AH++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.AH;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.AF.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

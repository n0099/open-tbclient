package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e wG = null;
    private HashMap<String, Class<?>> wF;
    private int wH = 0;
    private int wI = 0;

    public static e iv() {
        if (wG == null) {
            synchronized (e.class) {
                if (wG == null) {
                    wG = new e();
                }
            }
        }
        return wG;
    }

    private e() {
        this.wF = null;
        this.wF = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.wF.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.wI == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.wI++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.wI;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.wH == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.wH++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.wH;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.wF.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

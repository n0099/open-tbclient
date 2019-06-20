package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e HF = null;
    private HashMap<String, Class<?>> HE;
    private int HG = 0;
    private int HH = 0;

    public static e ls() {
        if (HF == null) {
            synchronized (e.class) {
                if (HF == null) {
                    HF = new e();
                }
            }
        }
        return HF;
    }

    private e() {
        this.HE = null;
        this.HE = new HashMap<>();
    }

    public Class<?> j(Class<?> cls) {
        String str;
        Class<?> cls2 = this.HE.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.HH == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.HH++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.HH;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.HG == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.HG++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.HG;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.HE.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

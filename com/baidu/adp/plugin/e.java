package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e JW = null;
    private HashMap<String, Class<?>> JV;
    private int JX = 0;
    private int JY = 0;

    public static e my() {
        if (JW == null) {
            synchronized (e.class) {
                if (JW == null) {
                    JW = new e();
                }
            }
        }
        return JW;
    }

    private e() {
        this.JV = null;
        this.JV = new HashMap<>();
    }

    public Class<?> k(Class<?> cls) {
        String str;
        Class<?> cls2 = this.JV.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.JY == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.JY++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.JY;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.JX == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.JX++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.JX;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.JV.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

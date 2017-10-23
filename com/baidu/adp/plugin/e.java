package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cx = null;
    private HashMap<String, Class<?>> Cw;
    private int Cy = 0;
    private int Cz = 0;

    public static e iO() {
        if (Cx == null) {
            synchronized (e.class) {
                if (Cx == null) {
                    Cx = new e();
                }
            }
        }
        return Cx;
    }

    private e() {
        this.Cw = null;
        this.Cw = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cw.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Cz == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cz++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Cz;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Cy == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Cy++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Cy;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Cw.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

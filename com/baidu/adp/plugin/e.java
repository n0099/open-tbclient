package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e Cw = null;
    private HashMap<String, Class<?>> Cv;
    private int Cx = 0;
    private int Cy = 0;

    public static e iO() {
        if (Cw == null) {
            synchronized (e.class) {
                if (Cw == null) {
                    Cw = new e();
                }
            }
        }
        return Cw;
    }

    private e() {
        this.Cv = null;
        this.Cv = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.Cv.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.Cy == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.Cy++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.Cy;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.Cx == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.Cx++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.Cx;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.Cv.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

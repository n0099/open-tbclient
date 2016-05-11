package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h tz = null;
    private int tA = 0;
    private int tB = 0;
    private HashMap<String, Class<?>> ty;

    public static h gY() {
        if (tz == null) {
            synchronized (h.class) {
                if (tz == null) {
                    tz = new h();
                }
            }
        }
        return tz;
    }

    private h() {
        this.ty = null;
        this.ty = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.ty.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.tB == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.tB++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.tB;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.tA == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.tA++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.tA;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.ty.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

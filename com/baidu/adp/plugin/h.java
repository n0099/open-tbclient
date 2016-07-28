package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h ud = null;
    private HashMap<String, Class<?>> uc;
    private int ue = 0;
    private int uf = 0;

    public static h gZ() {
        if (ud == null) {
            synchronized (h.class) {
                if (ud == null) {
                    ud = new h();
                }
            }
        }
        return ud;
    }

    private h() {
        this.uc = null;
        this.uc = new HashMap<>();
    }

    public Class<?> p(Class<?> cls) {
        String str;
        Class<?> cls2 = this.uc.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.uf == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.uf++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.uf;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.ue == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.ue++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.ue;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.uc.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

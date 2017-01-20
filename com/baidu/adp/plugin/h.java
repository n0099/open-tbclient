package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h wh = null;
    private HashMap<String, Class<?>> wg;
    private int wi = 0;
    private int wj = 0;

    public static h hS() {
        if (wh == null) {
            synchronized (h.class) {
                if (wh == null) {
                    wh = new h();
                }
            }
        }
        return wh;
    }

    private h() {
        this.wg = null;
        this.wg = new HashMap<>();
    }

    public Class<?> p(Class<?> cls) {
        String str;
        Class<?> cls2 = this.wg.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.wj == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.wj++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.wj;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.wi == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.wi++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.wi;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.wg.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

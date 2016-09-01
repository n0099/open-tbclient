package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h wq = null;
    private HashMap<String, Class<?>> wp;
    private int wr = 0;
    private int ws = 0;

    public static h hU() {
        if (wq == null) {
            synchronized (h.class) {
                if (wq == null) {
                    wq = new h();
                }
            }
        }
        return wq;
    }

    private h() {
        this.wp = null;
        this.wp = new HashMap<>();
    }

    public Class<?> p(Class<?> cls) {
        String str;
        Class<?> cls2 = this.wp.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.ws == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.ws++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.ws;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.wr == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.wr++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.wr;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.wp.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

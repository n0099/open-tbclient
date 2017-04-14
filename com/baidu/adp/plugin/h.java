package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static volatile h CW = null;
    private HashMap<String, Class<?>> CV;
    private int CX = 0;
    private int CY = 0;

    public static h iQ() {
        if (CW == null) {
            synchronized (h.class) {
                if (CW == null) {
                    CW = new h();
                }
            }
        }
        return CW;
    }

    private h() {
        this.CV = null;
        this.CV = new HashMap<>();
    }

    public Class<?> h(Class<?> cls) {
        String str;
        Class<?> cls2 = this.CV.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.CY == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.CY++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.CY;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.CX == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.CX++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.CX;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.CV.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

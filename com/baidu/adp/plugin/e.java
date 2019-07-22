package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e HQ = null;
    private HashMap<String, Class<?>> HP;
    private int HR = 0;
    private int HS = 0;

    public static e lI() {
        if (HQ == null) {
            synchronized (e.class) {
                if (HQ == null) {
                    HQ = new e();
                }
            }
        }
        return HQ;
    }

    private e() {
        this.HP = null;
        this.HP = new HashMap<>();
    }

    public Class<?> j(Class<?> cls) {
        String str;
        Class<?> cls2 = this.HP.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.HS == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.HS++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.HS;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.HR == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.HR++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.HR;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.HP.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

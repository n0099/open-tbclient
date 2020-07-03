package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e QU = null;
    private HashMap<String, Class<?>> QT;
    private int QV = 0;
    private int QW = 0;

    public static e nE() {
        if (QU == null) {
            synchronized (e.class) {
                if (QU == null) {
                    QU = new e();
                }
            }
        }
        return QU;
    }

    private e() {
        this.QT = null;
        this.QT = new HashMap<>();
    }

    public Class<?> o(Class<?> cls) {
        String str;
        Class<?> cls2 = this.QT.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                if (this.QW == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.QW++;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.QW;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                if (this.QV == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.QV++;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.QV;
            } else if (!PluginBaseThirdService.class.isAssignableFrom(cls)) {
                str = "";
            } else {
                str = "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy";
            }
            try {
                cls2 = Class.forName(str);
                this.QT.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

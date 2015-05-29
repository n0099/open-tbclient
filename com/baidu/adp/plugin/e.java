package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e CJ = null;
    private HashMap<String, Class<?>> CI;
    private int CK = 0;
    private int CL = 0;

    public static e kM() {
        if (CJ == null) {
            synchronized (e.class) {
                if (CJ == null) {
                    CJ = new e();
                }
            }
        }
        return CJ;
    }

    private e() {
        this.CI = null;
        this.CI = new HashMap<>();
    }

    public Class<?> n(Class<?> cls) {
        String str;
        Class<?> cls2 = this.CI.get(cls.getName());
        if (cls2 == null) {
            if (com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                if (this.CL == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.CL++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.CL;
            } else if (!g.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.CK == 20) {
                BdLog.e("can not find service,Has started 20 service");
                return null;
            } else {
                this.CK++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.CK;
            }
            try {
                cls2 = Class.forName(str);
                this.CI.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

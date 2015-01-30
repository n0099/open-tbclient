package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.g;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static volatile e sg = null;
    private HashMap<String, Class<?>> sf;
    private int sh = 0;
    private int si = 0;

    public static e hf() {
        if (sg == null) {
            synchronized (e.class) {
                if (sg == null) {
                    sg = new e();
                }
            }
        }
        return sg;
    }

    private e() {
        this.sf = null;
        this.sf = new HashMap<>();
    }

    public Class<?> n(Class<?> cls) {
        String str;
        Class<?> cls2 = this.sf.get(cls.getName());
        if (cls2 == null) {
            if (g.class.isAssignableFrom(cls)) {
                if (this.sh == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.sh++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.ServiceProxy") + this.sh;
            } else if (!com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(cls)) {
                str = "";
            } else if (this.si == 10) {
                BdLog.e("can not find service,Has started 10 Remoteservice");
                return null;
            } else {
                this.si++;
                str = String.valueOf("com.baidu.adp.plugin.proxy.service.RemoteServiceProxy") + this.si;
            }
            try {
                cls2 = Class.forName(str);
                this.sf.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e) {
                BdLog.e(e);
                return cls2;
            }
        }
        return cls2;
    }
}

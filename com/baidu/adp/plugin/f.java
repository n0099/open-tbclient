package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdSingleTaskActivity;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdFragmentActivityProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static volatile f CN = null;
    private Map<Class<?>, Class<?>> CH;
    private Map<Class<?>, Class<?>> CI;
    private Map<Class<?>, Class<?>> CJ;
    private int CK = 0;
    private int CL = 0;
    private int CM = 0;

    public static f kJ() {
        if (CN == null) {
            synchronized (f.class) {
                if (CN == null) {
                    CN = new f();
                }
            }
        }
        return CN;
    }

    private f() {
        this.CH = null;
        this.CI = null;
        this.CJ = null;
        this.CH = new HashMap();
        this.CI = new HashMap();
        this.CJ = new HashMap();
    }

    public Class<?> f(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.CH.get(cls);
            if (cls2 == null) {
                if (this.CL == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.CL++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.CL);
                    this.CH.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.CI.get(cls);
            if (cls3 == null) {
                if (this.CM == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.CM++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.CM);
                    this.CI.put(cls, cls3);
                    return cls3;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls3;
                }
            }
            return cls3;
        } else if (PluginBaseRemoteActivity.class.isAssignableFrom(cls)) {
            return RemoteActivityProxy.class;
        } else {
            if (PluginBaseThirdSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls4 = this.CJ.get(cls);
                if (cls4 == null) {
                    if (this.CK == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.CK++;
                    try {
                        cls4 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy") + this.CK);
                        this.CJ.put(cls, cls4);
                        return cls4;
                    } catch (Exception e3) {
                        BdLog.e(e3);
                        return cls4;
                    }
                }
                return cls4;
            } else if (PluginBaseThirdActivity.class.isAssignableFrom(cls)) {
                return ThirdActivityProxy.class;
            } else {
                if (ThirdFragmentActivityProxy.class.isAssignableFrom(cls)) {
                    return ThirdFragmentActivityProxy.class;
                }
                if (PluginBaseActivity.class.isAssignableFrom(cls)) {
                    return ActivityProxy.class;
                }
                return null;
            }
        }
    }
}

package com.baidu.adp.plugin;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdSingleTaskActivity;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdFragmentActivityProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static volatile f CR = null;
    private Map<Class<?>, Class<?>> CL;
    private Map<Class<?>, Class<?>> CM;
    private Map<Class<?>, Class<?>> CN;
    private int CO = 0;
    private int CP = 0;
    private int CQ = 0;

    public static f iN() {
        if (CR == null) {
            synchronized (f.class) {
                if (CR == null) {
                    CR = new f();
                }
            }
        }
        return CR;
    }

    private f() {
        this.CL = null;
        this.CM = null;
        this.CN = null;
        this.CL = new HashMap();
        this.CM = new HashMap();
        this.CN = new HashMap();
    }

    public Class<?> g(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.CL.get(cls);
            if (cls2 == null) {
                if (this.CP == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.CP++;
                try {
                    cls2 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy") + this.CP);
                    this.CL.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.CM.get(cls);
            if (cls3 == null) {
                if (this.CQ == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.CQ++;
                try {
                    cls3 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy") + this.CQ);
                    this.CM.put(cls, cls3);
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
                Class<?> cls4 = this.CN.get(cls);
                if (cls4 == null) {
                    if (this.CO == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.CO++;
                    try {
                        cls4 = Class.forName(String.valueOf("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy") + this.CO);
                        this.CN.put(cls, cls4);
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
                if (PluginBaseThirdFragmentActivity.class.isAssignableFrom(cls)) {
                    return ThirdFragmentActivityProxy.class;
                }
                if (PluginBaseFragmentActivity.class.isAssignableFrom(cls)) {
                    return FragmentActivityProxy.class;
                }
                if (PluginBaseActivity.class.isAssignableFrom(cls)) {
                    return ActivityProxy.class;
                }
                return null;
            }
        }
    }
}

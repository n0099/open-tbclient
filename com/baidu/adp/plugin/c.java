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
public class c {
    private static volatile c wF = null;
    private Map<Class<?>, Class<?>> wA;
    private Map<Class<?>, Class<?>> wB;
    private int wC = 0;
    private int wD = 0;
    private int wE = 0;
    private Map<Class<?>, Class<?>> wz;

    public static c ir() {
        if (wF == null) {
            synchronized (c.class) {
                if (wF == null) {
                    wF = new c();
                }
            }
        }
        return wF;
    }

    private c() {
        this.wz = null;
        this.wA = null;
        this.wB = null;
        this.wz = new HashMap();
        this.wA = new HashMap();
        this.wB = new HashMap();
    }

    public Class<?> n(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.wz.get(cls);
            if (cls2 == null) {
                if (this.wD == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.wD++;
                try {
                    cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.wD);
                    this.wz.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.wA.get(cls);
            if (cls3 == null) {
                if (this.wE == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.wE++;
                try {
                    cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.wE);
                    this.wA.put(cls, cls3);
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
                Class<?> cls4 = this.wB.get(cls);
                if (cls4 == null) {
                    if (this.wC == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.wC++;
                    try {
                        cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.wC);
                        this.wB.put(cls, cls4);
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

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
    private static volatile c Rq = null;
    private Map<Class<?>, Class<?>> Rk;
    private Map<Class<?>, Class<?>> Rl;
    private Map<Class<?>, Class<?>> Rm;
    private int Rn = 0;
    private int Ro = 0;
    private int Rp = 0;

    public static c pc() {
        if (Rq == null) {
            synchronized (c.class) {
                if (Rq == null) {
                    Rq = new c();
                }
            }
        }
        return Rq;
    }

    private c() {
        this.Rk = null;
        this.Rl = null;
        this.Rm = null;
        this.Rk = new HashMap();
        this.Rl = new HashMap();
        this.Rm = new HashMap();
    }

    public Class<?> n(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.Rk.get(cls);
            if (cls2 == null) {
                if (this.Ro == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.Ro++;
                try {
                    cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.Ro);
                    this.Rk.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.Rl.get(cls);
            if (cls3 == null) {
                if (this.Rp == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.Rp++;
                try {
                    cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.Rp);
                    this.Rl.put(cls, cls3);
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
                Class<?> cls4 = this.Rm.get(cls);
                if (cls4 == null) {
                    if (this.Rn == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.Rn++;
                    try {
                        cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.Rn);
                        this.Rm.put(cls, cls4);
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

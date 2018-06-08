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
    private static volatile c GJ = null;
    private Map<Class<?>, Class<?>> GD;
    private Map<Class<?>, Class<?>> GE;
    private Map<Class<?>, Class<?>> GF;
    private int GG = 0;
    private int GH = 0;
    private int GI = 0;

    public static c lb() {
        if (GJ == null) {
            synchronized (c.class) {
                if (GJ == null) {
                    GJ = new c();
                }
            }
        }
        return GJ;
    }

    private c() {
        this.GD = null;
        this.GE = null;
        this.GF = null;
        this.GD = new HashMap();
        this.GE = new HashMap();
        this.GF = new HashMap();
    }

    public Class<?> g(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.GD.get(cls);
            if (cls2 == null) {
                if (this.GH == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.GH++;
                try {
                    cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.GH);
                    this.GD.put(cls, cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.GE.get(cls);
            if (cls3 == null) {
                if (this.GI == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.GI++;
                try {
                    cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.GI);
                    this.GE.put(cls, cls3);
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
                Class<?> cls4 = this.GF.get(cls);
                if (cls4 == null) {
                    if (this.GG == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.GG++;
                    try {
                        cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.GG);
                        this.GF.put(cls, cls4);
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

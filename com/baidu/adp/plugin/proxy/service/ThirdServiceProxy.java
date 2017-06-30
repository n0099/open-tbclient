package com.baidu.adp.plugin.proxy.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.b.a;
import com.baidu.adp.plugin.g;
import com.baidu.adp.plugin.proxy.ServiceProxy;
/* loaded from: classes.dex */
public class ThirdServiceProxy extends ServiceProxy {
    private Object createServiceInstance(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        String name = ThirdServiceProxy.class.getName();
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
        if (plugin2 == null || TextUtils.isEmpty(stringExtra2)) {
            a.jj().f("plugin_use", "plugin_third_service_create_failed", stringExtra);
            return null;
        }
        try {
            ServiceProxy serviceProxy = (ServiceProxy) plugin2.getDexClassLoader().loadClass(name).newInstance();
            serviceProxy.onCreate();
            g.iN().a(stringExtra2, new g.a(serviceProxy, intent));
            return serviceProxy;
        } catch (Exception e) {
            BdLog.e(e);
            a.jj().f("plugin_use", "plugin_third_service exception: " + e.getMessage(), stringExtra);
            return null;
        }
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        g.a aS = g.iN().aS(stringExtra);
        if (aS == null) {
            ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
            if (thirdServiceProxy == null) {
                BdLog.e("thrid_service_proxy_onbin_failed : " + stringExtra);
                return null;
            }
            new g.a(thirdServiceProxy, intent);
            return thirdServiceProxy.onBind(intent);
        }
        g.iN().a(stringExtra, aS);
        return super.onBind(intent);
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        if (g.iN().iO() == 0) {
            g.iN().a(stringExtra, new g.a(this, intent));
            super.onStartCommand(intent, i, i2);
            return 3;
        } else if (g.iN().aS(stringExtra) == null) {
            ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
            if (thirdServiceProxy == null) {
                BdLog.e("third_service_proxy_create_failed:" + stringExtra);
                return 3;
            }
            return thirdServiceProxy.onStartCommand(intent, i, i2);
        } else {
            super.onStartCommand(intent, i, i2);
            return 3;
        }
    }
}

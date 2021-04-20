package com.baidu.adp.plugin.proxy.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import d.b.c.h.d;
import d.b.c.h.h.a;
/* loaded from: classes.dex */
public class ThirdServiceProxy extends ServiceProxy {
    private Object createServiceInstance(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        String name = ThirdServiceProxy.class.getName();
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
        if (plugin2 != null && !TextUtils.isEmpty(stringExtra2)) {
            try {
                ServiceProxy serviceProxy = (ServiceProxy) plugin2.getDexClassLoader().loadClass(name).newInstance();
                serviceProxy.onCreate();
                d.a().d(stringExtra2, new d.a(serviceProxy, intent));
                return serviceProxy;
            } catch (Exception e2) {
                BdLog.e(e2);
                a b2 = a.b();
                b2.q("plugin_use", "plugin_third_service exception: " + e2.getMessage(), stringExtra);
                return null;
            }
        }
        a.b().q("plugin_use", "plugin_third_service_create_failed", stringExtra);
        return null;
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        d.a c2 = d.a().c(stringExtra);
        if (c2 == null) {
            ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
            if (thirdServiceProxy == null) {
                BdLog.e("thrid_service_proxy_onbin_failed : " + stringExtra);
                return null;
            }
            return thirdServiceProxy.onBind(intent);
        }
        d.a().d(stringExtra, c2);
        return super.onBind(intent);
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        if (d.a().b() == 0) {
            d.a().d(stringExtra, new d.a(this, intent));
            super.onStartCommand(intent, i, i2);
            return 3;
        } else if (d.a().c(stringExtra) == null) {
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

package com.baidu.adp.plugin.proxy.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.g;
import com.baidu.adp.plugin.proxy.ServiceProxy;
/* loaded from: classes.dex */
public class ThirdServiceProxy extends ServiceProxy {
    private Object createServiceInstance(Intent intent) {
        String stringExtra = intent.getStringExtra("intent_extra_package_name");
        String stringExtra2 = intent.getStringExtra("intent_extra_service");
        String name = ThirdServiceProxy.class.getName();
        a plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
        if (plugin2 == null || TextUtils.isEmpty(stringExtra2)) {
            com.baidu.adp.plugin.b.a.lf().h("plugin_use", "plugin_third_service_create_failed", stringExtra);
            return null;
        }
        try {
            ServiceProxy serviceProxy = (ServiceProxy) plugin2.kt().loadClass(name).newInstance();
            serviceProxy.onCreate();
            g.kK().a(stringExtra2, new g.a(serviceProxy, intent));
            return serviceProxy;
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lf().h("plugin_use", "plugin_third_service exception: " + e.getMessage(), stringExtra);
            return null;
        }
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra("intent_extra_service");
        g.a bg = g.kK().bg(stringExtra);
        if (bg == null) {
            ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
            if (thirdServiceProxy == null) {
                BdLog.e("thrid_service_proxy_onbin_failed : " + stringExtra);
                return null;
            }
            new g.a(thirdServiceProxy, intent);
            return thirdServiceProxy.onBind(intent);
        }
        g.kK().a(stringExtra, bg);
        return super.onBind(intent);
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra("intent_extra_service");
        if (g.kK().kL() == 0) {
            g.kK().a(stringExtra, new g.a(this, intent));
            super.onStartCommand(intent, i, i2);
            return 3;
        } else if (g.kK().bg(stringExtra) == null) {
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

package com.baidu.adp.plugin.proxy.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import c.a.e.h.d;
import c.a.e.h.h.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ThirdServiceProxy extends ServiceProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdServiceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Object createServiceInstance(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, intent)) == null) {
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
        return invokeL.objValue;
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
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
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i2, i3)) == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
            if (d.a().b() == 0) {
                d.a().d(stringExtra, new d.a(this, intent));
                super.onStartCommand(intent, i2, i3);
                return 3;
            } else if (d.a().c(stringExtra) == null) {
                ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
                if (thirdServiceProxy == null) {
                    BdLog.e("third_service_proxy_create_failed:" + stringExtra);
                    return 3;
                }
                return thirdServiceProxy.onStartCommand(intent, i2, i3);
            } else {
                super.onStartCommand(intent, i2, i3);
                return 3;
            }
        }
        return invokeLII.intValue;
    }
}

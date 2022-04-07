package com.baidu.adp.plugin.proxy.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
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
import com.repackage.em;
import com.repackage.vl;
/* loaded from: classes.dex */
public class ThirdServiceProxy extends ServiceProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdServiceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    vl.a().d(stringExtra2, new vl.a(serviceProxy, intent));
                    return serviceProxy;
                } catch (Exception e) {
                    BdLog.e(e);
                    em b = em.b();
                    b.o("plugin_use", "plugin_third_service exception: " + e.getMessage(), stringExtra);
                    return null;
                }
            }
            em.b().o("plugin_use", "plugin_third_service_create_failed", stringExtra);
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
            vl.a c = vl.a().c(stringExtra);
            if (c == null) {
                ThirdServiceProxy thirdServiceProxy = (ThirdServiceProxy) createServiceInstance(intent);
                if (thirdServiceProxy == null) {
                    BdLog.e("thrid_service_proxy_onbin_failed : " + stringExtra);
                    return null;
                }
                return thirdServiceProxy.onBind(intent);
            }
            vl.a().d(stringExtra, c);
            return super.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.plugin.proxy.ServiceProxy, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i, i2)) == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
            if (vl.a().b() == 0) {
                vl.a().d(stringExtra, new vl.a(this, intent));
                super.onStartCommand(intent, i, i2);
                return 3;
            } else if (vl.a().c(stringExtra) == null) {
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
        return invokeLII.intValue;
    }
}

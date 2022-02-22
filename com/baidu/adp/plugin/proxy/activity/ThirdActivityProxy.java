package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import c.a.d.j.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ThirdActivityProxy extends ActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdActivityProxy() {
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

    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, c.a.d.j.f.a
    public boolean proxyStopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
            d.a c2 = stringExtra != null ? d.a().c(stringExtra) : null;
            if (c2 != null && c2.a != null) {
                if (d.a().b() == 1) {
                    d.a().e(stringExtra);
                    c2.a.stopSelf();
                    return true;
                }
                c2.a.onDestroy();
                d.a().e(stringExtra);
                return true;
            }
            BdLog.d("service stop error!" + intent.toString());
            return false;
        }
        return invokeL.booleanValue;
    }
}

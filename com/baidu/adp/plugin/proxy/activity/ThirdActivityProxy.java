package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sl;
/* loaded from: classes.dex */
public class ThirdActivityProxy extends ActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ThirdActivityProxy() {
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

    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, com.repackage.ul
    public boolean proxyStopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
            sl.a c = stringExtra != null ? sl.a().c(stringExtra) : null;
            if (c != null && c.a != null) {
                if (sl.a().b() == 1) {
                    sl.a().e(stringExtra);
                    c.a.stopSelf();
                    return true;
                }
                c.a.onDestroy();
                sl.a().e(stringExtra);
                return true;
            }
            BdLog.d("service stop error!" + intent.toString());
            return false;
        }
        return invokeL.booleanValue;
    }
}

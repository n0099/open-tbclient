package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.StatusCode;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, intent) == null) {
            try {
                String[] g2 = com.baidu.sofire.utility.c.g(context);
                com.baidu.sofire.core.d.a(context, 0, g2[0], g2[1], StatusCode.SERVICE_CODE_CARD_MAYBE_ERR_AND_NOT_SUPPORT);
                int i2 = 0;
                while (true) {
                    Thread.sleep(500L);
                    i2++;
                    if (i2 > 60) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", "152");
                        hashMap.put("1", g2[0]);
                        com.baidu.sofire.utility.c.a(context.getApplicationContext(), "1014115", (Map<String, Object>) hashMap, false);
                        break;
                    }
                    f a2 = f.a();
                    if (a2 != null && a2.d("com.baidu.sofire.x24") != null) {
                        break;
                    }
                }
                com.baidu.sofire.core.d.a((int) StatusCode.SERVICE_CODE_CARD_MAYBE_ERR_AND_NOT_SUPPORT, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onEnd(Object... objArr) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objArr)) == null) ? super.onEnd(objArr) : invokeL.objValue;
                    }
                }, new Class[]{Context.class, Intent.class}, context, intent);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }
}

package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.MethodImpl;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AwakeReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AWAKE_CONTENT = "c";
    public static final String AWAKE_SOURCE = "source";
    public static final String AWAKE_TYPE = "t";
    public static final String METHOD_NAME = "onReceiveAwakeMessage";
    public static final int PULGIN_ID = 100028;
    public static final String PULGIN_PKGNAME = "com.baidu.techain.x24";
    public static final String TYPE_ACTIVITY = "a";
    public static final String TYPE_PROVIDER = "p";
    public static final String TYPE_RECEIVER = "r";
    public static final String TYPE_SERVICE = "s";
    public transient /* synthetic */ FieldHolder $fh;

    public AwakeReceiver() {
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

    public static void onReceiveAwakeMessage(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, intent) == null) {
            try {
                String[] selectAppKeyAndSecurityKey = CommonMethods.selectAppKeyAndSecurityKey(context);
                MethodImpl.initDelay(context, 0, selectAppKeyAndSecurityKey[0], selectAppKeyAndSecurityKey[1], 100028);
                int i = 0;
                while (true) {
                    Thread.sleep(500L);
                    i++;
                    if (i > 60) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", "152");
                        hashMap.put("1", selectAppKeyAndSecurityKey[0]);
                        CommonMethods.sendEventUDC(context.getApplicationContext(), "1014115", hashMap, false);
                        break;
                    }
                    PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                    if (peekInstance != null && peekInstance.getApkInfoByPackageName("com.baidu.sofire.x24") != null) {
                        break;
                    }
                }
                MethodImpl.call(100028, METHOD_NAME, new Callback() { // from class: com.baidu.sofire.AwakeReceiver.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}

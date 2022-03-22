package com.baidu.sofire.core;

import android.content.Context;
import com.baidu.sofire.d.D;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TimeoutRunner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TimeoutRunner() {
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

    public static void handleWork(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            try {
                D d2 = D.getInstance(context);
                ForHostApp forHostApp = ForHostApp.getInstance(context);
                for (ApkInfo apkInfo : d2.getAllPlugins()) {
                    if (apkInfo.duration != 0 && apkInfo.startTime + (apkInfo.duration * 60 * 1000) < System.currentTimeMillis()) {
                        forHostApp.unloadPlugin(apkInfo.packageName);
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}

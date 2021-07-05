package com.baidu.nps.stub.context;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.nps.stub.component.NPSApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class ContextHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ContextHolder() {
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

    public final Application getContextInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Application applicationContext = com.baidu.nps.utils.ContextHolder.getApplicationContext();
            return TextUtils.isEmpty(getPackageName()) ? applicationContext : new NPSApplication(applicationContext, getPackageName());
        }
        return (Application) invokeV.objValue;
    }

    public abstract String getPackageName();
}

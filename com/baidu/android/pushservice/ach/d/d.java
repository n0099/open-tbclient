package com.baidu.android.pushservice.ach.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public WindowManager.LayoutParams c;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(com.baidu.android.pushservice.v.a.a(c(context)), (ViewGroup) null);
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (View) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-16000, this, null) : (View) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15999, this, eVar);
        }
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public WindowManager.LayoutParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (WindowManager.LayoutParams) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15994, this, null) : (WindowManager.LayoutParams) invokeV.objValue;
    }
}

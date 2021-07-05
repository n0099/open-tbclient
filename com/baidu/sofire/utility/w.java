package com.baidu.sofire.utility;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static w f10523c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10524a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f10525b;

    public w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SharedPreferences sharedPreferences = com.baidu.sofire.h.a.a(context).f10393a;
        this.f10524a = sharedPreferences;
        this.f10525b = sharedPreferences.edit();
    }

    public static synchronized w a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (w.class) {
                if (context == null) {
                    return f10523c;
                }
                if (f10523c == null) {
                    f10523c = new w(context);
                }
                return f10523c;
            }
        }
        return (w) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10524a.getBoolean("lt_sdcf", true) : invokeV.booleanValue;
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f10525b.putBoolean("lt_sssf", z);
            this.f10525b.commit();
        }
    }
}

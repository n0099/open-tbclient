package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static j a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f30903b;

    /* renamed from: c  reason: collision with root package name */
    public String f30904c;

    /* renamed from: d  reason: collision with root package name */
    public String f30905d;

    /* renamed from: e  reason: collision with root package name */
    public String f30906e;

    /* renamed from: f  reason: collision with root package name */
    public Context f30907f;

    public j(Context context) {
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
        this.f30905d = PushSettings.c(context);
        this.f30903b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f30906e = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f30904c = PushSettings.b(context);
        }
        this.f30907f = context;
    }

    public static j a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (j.class) {
                    if (a == null) {
                        a = new j(context);
                    }
                }
            }
            return a;
        }
        return (j) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30903b : (String) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            synchronized (this) {
                this.f30903b = str;
                this.f30905d = str2;
                this.f30904c = str3;
                this.f30906e = str4;
                PushSettings.a(this.f30907f, str, str3);
                PushSettings.a(this.f30907f, str2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30905d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30904c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30906e : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f30903b)) {
                this.f30903b = PushSettings.a(this.f30907f);
            }
            if (TextUtils.isEmpty(this.f30905d)) {
                this.f30905d = PushSettings.c(this.f30907f);
            }
            return (TextUtils.isEmpty(this.f30903b) || TextUtils.isEmpty(this.f30905d)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

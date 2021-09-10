package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static k f37662a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f37663b;

    /* renamed from: c  reason: collision with root package name */
    public String f37664c;

    /* renamed from: d  reason: collision with root package name */
    public String f37665d;

    /* renamed from: e  reason: collision with root package name */
    public String f37666e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37667f;

    public k(Context context) {
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
        this.f37665d = PushSettings.c(context);
        this.f37663b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f37666e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f37664c = PushSettings.b(context);
        }
        this.f37667f = context;
    }

    public static k a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f37662a == null) {
                synchronized (k.class) {
                    if (f37662a == null) {
                        f37662a = new k(context);
                    }
                }
            }
            return f37662a;
        }
        return (k) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37663b : (String) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            synchronized (this) {
                this.f37663b = str;
                this.f37665d = str2;
                this.f37664c = str3;
                this.f37666e = str4;
                PushSettings.a(this.f37667f, str, str3);
                PushSettings.a(this.f37667f, str2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37665d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37664c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37666e : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f37663b)) {
                this.f37663b = PushSettings.a(this.f37667f);
            }
            if (TextUtils.isEmpty(this.f37665d)) {
                this.f37665d = PushSettings.c(this.f37667f);
            }
            return (TextUtils.isEmpty(this.f37663b) || TextUtils.isEmpty(this.f37665d)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

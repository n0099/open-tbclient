package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static k f3506a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f3507b;

    /* renamed from: c  reason: collision with root package name */
    public String f3508c;

    /* renamed from: d  reason: collision with root package name */
    public String f3509d;

    /* renamed from: e  reason: collision with root package name */
    public String f3510e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3511f;

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
        this.f3509d = PushSettings.c(context);
        this.f3507b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f3510e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f3508c = PushSettings.b(context);
        }
        this.f3511f = context;
    }

    public static k a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3506a == null) {
                synchronized (k.class) {
                    if (f3506a == null) {
                        f3506a = new k(context);
                    }
                }
            }
            return f3506a;
        }
        return (k) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3507b : (String) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            synchronized (this) {
                this.f3507b = str;
                this.f3509d = str2;
                this.f3508c = str3;
                this.f3510e = str4;
                PushSettings.a(this.f3511f, str, str3);
                PushSettings.a(this.f3511f, str2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3509d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3508c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3510e : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f3507b)) {
                this.f3507b = PushSettings.a(this.f3511f);
            }
            if (TextUtils.isEmpty(this.f3509d)) {
                this.f3509d = PushSettings.c(this.f3511f);
            }
            return (TextUtils.isEmpty(this.f3507b) || TextUtils.isEmpty(this.f3509d)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

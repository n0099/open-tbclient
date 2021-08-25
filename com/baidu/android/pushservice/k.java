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
    public static k f37543a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f37544b;

    /* renamed from: c  reason: collision with root package name */
    public String f37545c;

    /* renamed from: d  reason: collision with root package name */
    public String f37546d;

    /* renamed from: e  reason: collision with root package name */
    public String f37547e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37548f;

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
        this.f37546d = PushSettings.c(context);
        this.f37544b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f37547e = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f37545c = PushSettings.b(context);
        }
        this.f37548f = context;
    }

    public static k a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f37543a == null) {
                synchronized (k.class) {
                    if (f37543a == null) {
                        f37543a = new k(context);
                    }
                }
            }
            return f37543a;
        }
        return (k) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37544b : (String) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            synchronized (this) {
                this.f37544b = str;
                this.f37546d = str2;
                this.f37545c = str3;
                this.f37547e = str4;
                PushSettings.a(this.f37548f, str, str3);
                PushSettings.a(this.f37548f, str2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37546d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37545c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37547e : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f37544b)) {
                this.f37544b = PushSettings.a(this.f37548f);
            }
            if (TextUtils.isEmpty(this.f37546d)) {
                this.f37546d = PushSettings.c(this.f37548f);
            }
            return (TextUtils.isEmpty(this.f37544b) || TextUtils.isEmpty(this.f37546d)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

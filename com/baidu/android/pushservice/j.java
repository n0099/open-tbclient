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
    public String f24744b;

    /* renamed from: c  reason: collision with root package name */
    public String f24745c;

    /* renamed from: d  reason: collision with root package name */
    public String f24746d;

    /* renamed from: e  reason: collision with root package name */
    public String f24747e;

    /* renamed from: f  reason: collision with root package name */
    public Context f24748f;

    public j(Context context) {
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
        this.f24746d = PushSettings.c(context);
        this.f24744b = PushSettings.a(context);
        if (com.baidu.android.pushservice.b.d.b(context)) {
            this.f24747e = com.baidu.android.pushservice.i.i.a(context, "com.baidu.pushservice.channel_token_new");
            this.f24745c = PushSettings.b(context);
        }
        this.f24748f = context;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24744b : (String) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            synchronized (this) {
                this.f24744b = str;
                this.f24746d = str2;
                this.f24745c = str3;
                this.f24747e = str4;
                PushSettings.a(this.f24748f, str, str3);
                PushSettings.a(this.f24748f, str2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24746d : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24745c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24747e : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f24744b)) {
                this.f24744b = PushSettings.a(this.f24748f);
            }
            if (TextUtils.isEmpty(this.f24746d)) {
                this.f24746d = PushSettings.c(this.f24748f);
            }
            return (TextUtils.isEmpty(this.f24744b) || TextUtils.isEmpty(this.f24746d)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

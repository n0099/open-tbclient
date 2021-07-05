package com.alipay.android.phone.mrpc.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class p extends u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f1666c;

    /* renamed from: d  reason: collision with root package name */
    public String f1667d;

    /* renamed from: e  reason: collision with root package name */
    public long f1668e;

    /* renamed from: f  reason: collision with root package name */
    public long f1669f;

    /* renamed from: g  reason: collision with root package name */
    public String f1670g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f1671h;

    public p(HttpUrlHeader httpUrlHeader, int i2, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpUrlHeader, Integer.valueOf(i2), str, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1671h = httpUrlHeader;
        this.f1666c = i2;
        this.f1667d = str;
        this.f1684a = bArr;
    }

    public final HttpUrlHeader a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1671h : (HttpUrlHeader) invokeV.objValue;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f1668e = j;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f1670g = str;
        }
    }

    public final void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f1669f = j;
        }
    }
}

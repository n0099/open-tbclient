package com.alipay.android.phone.mrpc.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public abstract class a implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Method f35721a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f35722b;

    /* renamed from: c  reason: collision with root package name */
    public String f35723c;

    /* renamed from: d  reason: collision with root package name */
    public int f35724d;

    /* renamed from: e  reason: collision with root package name */
    public String f35725e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35726f;

    public a(Method method, int i2, String str, byte[] bArr, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, Integer.valueOf(i2), str, bArr, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35721a = method;
        this.f35724d = i2;
        this.f35723c = str;
        this.f35722b = bArr;
        this.f35725e = str2;
        this.f35726f = z;
    }
}

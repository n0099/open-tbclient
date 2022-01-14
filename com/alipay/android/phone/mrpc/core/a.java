package com.alipay.android.phone.mrpc.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public abstract class a implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30635b;

    /* renamed from: c  reason: collision with root package name */
    public String f30636c;

    /* renamed from: d  reason: collision with root package name */
    public int f30637d;

    /* renamed from: e  reason: collision with root package name */
    public String f30638e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30639f;

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
        this.a = method;
        this.f30637d = i2;
        this.f30636c = str;
        this.f30635b = bArr;
        this.f30638e = str2;
        this.f30639f = z;
    }
}

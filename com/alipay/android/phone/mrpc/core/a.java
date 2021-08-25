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
    public Method f35585a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f35586b;

    /* renamed from: c  reason: collision with root package name */
    public String f35587c;

    /* renamed from: d  reason: collision with root package name */
    public int f35588d;

    /* renamed from: e  reason: collision with root package name */
    public String f35589e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35590f;

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
        this.f35585a = method;
        this.f35588d = i2;
        this.f35587c = str;
        this.f35586b = bArr;
        this.f35589e = str2;
        this.f35590f = z;
    }
}

package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f31790b;

    /* renamed from: c  reason: collision with root package name */
    public String f31791c;

    /* renamed from: d  reason: collision with root package name */
    public String f31792d;

    /* renamed from: e  reason: collision with root package name */
    public String f31793e;

    /* renamed from: f  reason: collision with root package name */
    public String f31794f;

    /* renamed from: g  reason: collision with root package name */
    public String f31795g;

    /* renamed from: h  reason: collision with root package name */
    public String f31796h;

    /* renamed from: i  reason: collision with root package name */
    public String f31797i;

    /* renamed from: j  reason: collision with root package name */
    public String f31798j;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f31790b = 0L;
        this.f31791c = "";
        this.f31792d = "";
        this.f31793e = "";
        this.f31794f = "";
        this.f31795g = "";
        this.f31796h = "";
        this.f31797i = "";
        this.f31798j = "";
    }
}

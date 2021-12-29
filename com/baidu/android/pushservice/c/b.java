package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f32803b;

    /* renamed from: c  reason: collision with root package name */
    public String f32804c;

    /* renamed from: d  reason: collision with root package name */
    public String f32805d;

    /* renamed from: e  reason: collision with root package name */
    public String f32806e;

    /* renamed from: f  reason: collision with root package name */
    public String f32807f;

    /* renamed from: g  reason: collision with root package name */
    public String f32808g;

    /* renamed from: h  reason: collision with root package name */
    public String f32809h;

    /* renamed from: i  reason: collision with root package name */
    public String f32810i;

    /* renamed from: j  reason: collision with root package name */
    public String f32811j;

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
        this.f32803b = 0L;
        this.f32804c = "";
        this.f32805d = "";
        this.f32806e = "";
        this.f32807f = "";
        this.f32808g = "";
        this.f32809h = "";
        this.f32810i = "";
        this.f32811j = "";
    }
}

package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f24290b;

    /* renamed from: c  reason: collision with root package name */
    public String f24291c;

    /* renamed from: d  reason: collision with root package name */
    public String f24292d;

    /* renamed from: e  reason: collision with root package name */
    public String f24293e;

    /* renamed from: f  reason: collision with root package name */
    public String f24294f;

    /* renamed from: g  reason: collision with root package name */
    public String f24295g;

    /* renamed from: h  reason: collision with root package name */
    public String f24296h;
    public String i;
    public String j;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f24290b = 0L;
        this.f24291c = "";
        this.f24292d = "";
        this.f24293e = "";
        this.f24294f = "";
        this.f24295g = "";
        this.f24296h = "";
        this.i = "";
        this.j = "";
    }
}

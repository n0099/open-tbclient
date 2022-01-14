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
    public long f31762b;

    /* renamed from: c  reason: collision with root package name */
    public String f31763c;

    /* renamed from: d  reason: collision with root package name */
    public String f31764d;

    /* renamed from: e  reason: collision with root package name */
    public String f31765e;

    /* renamed from: f  reason: collision with root package name */
    public String f31766f;

    /* renamed from: g  reason: collision with root package name */
    public String f31767g;

    /* renamed from: h  reason: collision with root package name */
    public String f31768h;

    /* renamed from: i  reason: collision with root package name */
    public String f31769i;

    /* renamed from: j  reason: collision with root package name */
    public String f31770j;

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
        this.f31762b = 0L;
        this.f31763c = "";
        this.f31764d = "";
        this.f31765e = "";
        this.f31766f = "";
        this.f31767g = "";
        this.f31768h = "";
        this.f31769i = "";
        this.f31770j = "";
    }
}

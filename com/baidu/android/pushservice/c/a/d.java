package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24249b;

    /* renamed from: c  reason: collision with root package name */
    public String f24250c;

    /* renamed from: d  reason: collision with root package name */
    public String f24251d;

    /* renamed from: e  reason: collision with root package name */
    public long f24252e;

    /* renamed from: f  reason: collision with root package name */
    public long f24253f;

    /* renamed from: g  reason: collision with root package name */
    public long f24254g;

    /* renamed from: h  reason: collision with root package name */
    public String f24255h;
    public long i;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}

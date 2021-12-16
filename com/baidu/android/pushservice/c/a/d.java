package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f32613b;

    /* renamed from: c  reason: collision with root package name */
    public String f32614c;

    /* renamed from: d  reason: collision with root package name */
    public String f32615d;

    /* renamed from: e  reason: collision with root package name */
    public long f32616e;

    /* renamed from: f  reason: collision with root package name */
    public long f32617f;

    /* renamed from: g  reason: collision with root package name */
    public long f32618g;

    /* renamed from: h  reason: collision with root package name */
    public String f32619h;

    /* renamed from: i  reason: collision with root package name */
    public long f32620i;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}

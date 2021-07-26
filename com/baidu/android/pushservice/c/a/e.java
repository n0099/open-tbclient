package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2878a;

    /* renamed from: b  reason: collision with root package name */
    public String f2879b;

    /* renamed from: c  reason: collision with root package name */
    public long f2880c;

    /* renamed from: d  reason: collision with root package name */
    public long f2881d;

    /* renamed from: e  reason: collision with root package name */
    public long f2882e;

    /* renamed from: f  reason: collision with root package name */
    public String f2883f;

    /* renamed from: g  reason: collision with root package name */
    public long f2884g;

    public e() {
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

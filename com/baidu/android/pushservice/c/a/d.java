package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2840a;

    /* renamed from: b  reason: collision with root package name */
    public String f2841b;

    /* renamed from: c  reason: collision with root package name */
    public String f2842c;

    /* renamed from: d  reason: collision with root package name */
    public String f2843d;

    /* renamed from: e  reason: collision with root package name */
    public long f2844e;

    /* renamed from: f  reason: collision with root package name */
    public long f2845f;

    /* renamed from: g  reason: collision with root package name */
    public long f2846g;

    /* renamed from: h  reason: collision with root package name */
    public String f2847h;

    /* renamed from: i  reason: collision with root package name */
    public long f2848i;

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

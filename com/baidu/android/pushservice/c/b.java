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
    public long f31996b;

    /* renamed from: c  reason: collision with root package name */
    public String f31997c;

    /* renamed from: d  reason: collision with root package name */
    public String f31998d;

    /* renamed from: e  reason: collision with root package name */
    public String f31999e;

    /* renamed from: f  reason: collision with root package name */
    public String f32000f;

    /* renamed from: g  reason: collision with root package name */
    public String f32001g;

    /* renamed from: h  reason: collision with root package name */
    public String f32002h;

    /* renamed from: i  reason: collision with root package name */
    public String f32003i;

    /* renamed from: j  reason: collision with root package name */
    public String f32004j;

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
        this.f31996b = 0L;
        this.f31997c = "";
        this.f31998d = "";
        this.f31999e = "";
        this.f32000f = "";
        this.f32001g = "";
        this.f32002h = "";
        this.f32003i = "";
        this.f32004j = "";
    }
}

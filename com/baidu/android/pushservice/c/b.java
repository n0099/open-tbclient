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
    public long f30399b;

    /* renamed from: c  reason: collision with root package name */
    public String f30400c;

    /* renamed from: d  reason: collision with root package name */
    public String f30401d;

    /* renamed from: e  reason: collision with root package name */
    public String f30402e;

    /* renamed from: f  reason: collision with root package name */
    public String f30403f;

    /* renamed from: g  reason: collision with root package name */
    public String f30404g;

    /* renamed from: h  reason: collision with root package name */
    public String f30405h;

    /* renamed from: i  reason: collision with root package name */
    public String f30406i;

    /* renamed from: j  reason: collision with root package name */
    public String f30407j;

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
        this.f30399b = 0L;
        this.f30400c = "";
        this.f30401d = "";
        this.f30402e = "";
        this.f30403f = "";
        this.f30404g = "";
        this.f30405h = "";
        this.f30406i = "";
        this.f30407j = "";
    }
}

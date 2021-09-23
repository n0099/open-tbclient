package com.alipay.apmobilesecuritysdk.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f35814a;

    /* renamed from: b  reason: collision with root package name */
    public String f35815b;

    /* renamed from: c  reason: collision with root package name */
    public String f35816c;

    /* renamed from: d  reason: collision with root package name */
    public String f35817d;

    /* renamed from: e  reason: collision with root package name */
    public String f35818e;

    public c(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35814a = "";
        this.f35815b = "";
        this.f35816c = "";
        this.f35817d = "";
        this.f35818e = "";
        this.f35814a = str;
        this.f35815b = str2;
        this.f35816c = str3;
        this.f35817d = str4;
        this.f35818e = str5;
    }
}

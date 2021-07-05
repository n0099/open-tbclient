package com.alipay.apmobilesecuritysdk.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1706a;

    /* renamed from: b  reason: collision with root package name */
    public String f1707b;

    /* renamed from: c  reason: collision with root package name */
    public String f1708c;

    /* renamed from: d  reason: collision with root package name */
    public String f1709d;

    /* renamed from: e  reason: collision with root package name */
    public String f1710e;

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
        this.f1706a = "";
        this.f1707b = "";
        this.f1708c = "";
        this.f1709d = "";
        this.f1710e = "";
        this.f1706a = str;
        this.f1707b = str2;
        this.f1708c = str3;
        this.f1709d = str4;
        this.f1710e = str5;
    }
}

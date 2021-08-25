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
    public String f35682a;

    /* renamed from: b  reason: collision with root package name */
    public String f35683b;

    /* renamed from: c  reason: collision with root package name */
    public String f35684c;

    /* renamed from: d  reason: collision with root package name */
    public String f35685d;

    /* renamed from: e  reason: collision with root package name */
    public String f35686e;

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
        this.f35682a = "";
        this.f35683b = "";
        this.f35684c = "";
        this.f35685d = "";
        this.f35686e = "";
        this.f35682a = str;
        this.f35683b = str2;
        this.f35684c = str3;
        this.f35685d = str4;
        this.f35686e = str5;
    }
}

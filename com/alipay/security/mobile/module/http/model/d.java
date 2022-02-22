package com.alipay.security.mobile.module.http.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f31255b;

    /* renamed from: c  reason: collision with root package name */
    public String f31256c;

    /* renamed from: d  reason: collision with root package name */
    public String f31257d;

    /* renamed from: e  reason: collision with root package name */
    public String f31258e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f31259f;

    /* renamed from: g  reason: collision with root package name */
    public String f31260g;

    /* renamed from: h  reason: collision with root package name */
    public String f31261h;

    /* renamed from: i  reason: collision with root package name */
    public String f31262i;

    /* renamed from: j  reason: collision with root package name */
    public String f31263j;

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

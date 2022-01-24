package com.alipay.security.mobile.module.http.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f31049b;

    /* renamed from: c  reason: collision with root package name */
    public String f31050c;

    /* renamed from: d  reason: collision with root package name */
    public String f31051d;

    /* renamed from: e  reason: collision with root package name */
    public String f31052e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f31053f;

    /* renamed from: g  reason: collision with root package name */
    public String f31054g;

    /* renamed from: h  reason: collision with root package name */
    public String f31055h;

    /* renamed from: i  reason: collision with root package name */
    public String f31056i;

    /* renamed from: j  reason: collision with root package name */
    public String f31057j;

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

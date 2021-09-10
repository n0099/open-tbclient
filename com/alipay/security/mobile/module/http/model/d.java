package com.alipay.security.mobile.module.http.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36203a;

    /* renamed from: b  reason: collision with root package name */
    public String f36204b;

    /* renamed from: c  reason: collision with root package name */
    public String f36205c;

    /* renamed from: d  reason: collision with root package name */
    public String f36206d;

    /* renamed from: e  reason: collision with root package name */
    public String f36207e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f36208f;

    /* renamed from: g  reason: collision with root package name */
    public String f36209g;

    /* renamed from: h  reason: collision with root package name */
    public String f36210h;

    /* renamed from: i  reason: collision with root package name */
    public String f36211i;

    /* renamed from: j  reason: collision with root package name */
    public String f36212j;

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

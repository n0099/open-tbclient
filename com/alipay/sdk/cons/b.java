package com.alipay.sdk.cons;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "https";

    /* renamed from: b  reason: collision with root package name */
    public static final String f31302b = "user_agent";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31303c = "tid";

    /* renamed from: d  reason: collision with root package name */
    public static final String f31304d = "external_info";

    /* renamed from: e  reason: collision with root package name */
    public static final String f31305e = "has_alipay";

    /* renamed from: f  reason: collision with root package name */
    public static final String f31306f = "has_msp_app";

    /* renamed from: g  reason: collision with root package name */
    public static final String f31307g = "utdid";

    /* renamed from: h  reason: collision with root package name */
    public static final String f31308h = "app_key";

    /* renamed from: i  reason: collision with root package name */
    public static final String f31309i = "trideskey";

    /* renamed from: j  reason: collision with root package name */
    public static final String f31310j = "new_client_key";

    /* renamed from: k  reason: collision with root package name */
    public static final String f31311k = "pa";
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }
}

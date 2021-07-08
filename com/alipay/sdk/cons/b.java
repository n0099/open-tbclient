package com.alipay.sdk.cons;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1841a = "https";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1842b = "user_agent";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1843c = "tid";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1844d = "external_info";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1845e = "has_alipay";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1846f = "has_msp_app";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1847g = "utdid";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1848h = "app_key";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1849i = "trideskey";
    public static final String j = "new_client_key";
    public static final String k = "pa";
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

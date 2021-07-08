package com.alipay.sdk.cons;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1850a = "status";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1851b = "msg";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1852c = "form";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1853d = "onload";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1854e = "name";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1855f = "host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1856g = "params";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1857h = "enctype";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1858i = "request_param";
    public static final String j = "validate";
    public static final String k = "formSubmit";
    public static final String l = "namespace";
    public static final String m = "apiVersion";
    public static final String n = "apiName";
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

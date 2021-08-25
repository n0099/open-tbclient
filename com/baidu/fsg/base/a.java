package com.baidu.fsg.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39184a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39185b = "com.baidu.fsg.base";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39186c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39187d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f39188e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f39189f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f39190g = "";

    /* renamed from: h  reason: collision with root package name */
    public static final String f39191h = "BgAAAA";

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f39192i = true;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f39193j = true;
    public static final String k = "2.0.2.0";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

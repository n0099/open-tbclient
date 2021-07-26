package com.baidu.fsg.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5139a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5140b = "com.baidu.fsg.base";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5141c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5142d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f5143e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f5144f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5145g = "";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5146h = "BgAAAA";

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5147i = true;
    public static final boolean j = true;
    public static final String k = "2.0.1.0";
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

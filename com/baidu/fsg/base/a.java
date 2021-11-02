package com.baidu.fsg.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f37306a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f37307b = "com.baidu.fsg.base";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37308c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37309d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f37310e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final String f37311f = "1.0";

    /* renamed from: g  reason: collision with root package name */
    public static final String f37312g = "test";

    /* renamed from: h  reason: collision with root package name */
    public static final String f37313h = "BgAAAA";

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f37314i = false;
    public static final boolean j = false;
    public static final String k = "2.1.0.0";
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

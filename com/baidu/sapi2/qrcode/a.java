package com.baidu.sapi2.qrcode;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44877a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44878b = "com.baidu.sapi2.qrcode";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f44879c = "com.baidu.sapi2.qrcode";

    /* renamed from: d  reason: collision with root package name */
    public static final String f44880d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f44881e = "";

    /* renamed from: f  reason: collision with root package name */
    public static final int f44882f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f44883g = "9.4.1";
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

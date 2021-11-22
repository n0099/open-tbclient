package com.baidu.sapi2.portrait;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43553a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43554b = "com.baidu.sapi2.portrait";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f43555c = "com.baidu.sapi2.portrait";

    /* renamed from: d  reason: collision with root package name */
    public static final String f43556d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f43557e = "";

    /* renamed from: f  reason: collision with root package name */
    public static final int f43558f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f43559g = "9.4.3";
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

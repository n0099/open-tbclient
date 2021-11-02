package com.baidu.apollon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35821a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f35822b = "com.baidu.apollon";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35823c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35824d = "common";

    /* renamed from: e  reason: collision with root package name */
    public static final int f35825e = 155;

    /* renamed from: f  reason: collision with root package name */
    public static final String f35826f = "1.5.5";
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

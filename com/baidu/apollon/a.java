package com.baidu.apollon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f37795a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f37796b = "com.baidu.apollon";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37797c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37798d = "common";

    /* renamed from: e  reason: collision with root package name */
    public static final int f37799e = 155;

    /* renamed from: f  reason: collision with root package name */
    public static final String f37800f = "1.5.5";
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

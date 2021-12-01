package com.baidu.apollon.beans;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f32930b = -15;

    /* renamed from: c  reason: collision with root package name */
    public static final int f32931c = -16;

    /* renamed from: d  reason: collision with root package name */
    public static final int f32932d = -2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f32933e = -3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f32934f = -4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f32935g = -5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f32936h = 5003;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32937i = -7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f32938j = -8;
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

package com.baidu.sofire.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10371a;

    /* renamed from: b  reason: collision with root package name */
    public String f10372b;

    /* renamed from: c  reason: collision with root package name */
    public int f10373c;

    /* renamed from: d  reason: collision with root package name */
    public String f10374d;

    /* renamed from: e  reason: collision with root package name */
    public long f10375e;

    /* renamed from: f  reason: collision with root package name */
    public int f10376f;

    /* renamed from: g  reason: collision with root package name */
    public int f10377g;

    /* renamed from: h  reason: collision with root package name */
    public int f10378h;

    /* renamed from: i  reason: collision with root package name */
    public int f10379i;
    public String j;

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

package com.baidu.sofire.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f45094a;

    /* renamed from: b  reason: collision with root package name */
    public String f45095b;

    /* renamed from: c  reason: collision with root package name */
    public int f45096c;

    /* renamed from: d  reason: collision with root package name */
    public String f45097d;

    /* renamed from: e  reason: collision with root package name */
    public long f45098e;

    /* renamed from: f  reason: collision with root package name */
    public int f45099f;

    /* renamed from: g  reason: collision with root package name */
    public int f45100g;

    /* renamed from: h  reason: collision with root package name */
    public int f45101h;

    /* renamed from: i  reason: collision with root package name */
    public int f45102i;

    /* renamed from: j  reason: collision with root package name */
    public String f45103j;

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

package com.baidu.sofire.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f43994a;

    /* renamed from: b  reason: collision with root package name */
    public String f43995b;

    /* renamed from: c  reason: collision with root package name */
    public int f43996c;

    /* renamed from: d  reason: collision with root package name */
    public String f43997d;

    /* renamed from: e  reason: collision with root package name */
    public long f43998e;

    /* renamed from: f  reason: collision with root package name */
    public int f43999f;

    /* renamed from: g  reason: collision with root package name */
    public int f44000g;

    /* renamed from: h  reason: collision with root package name */
    public int f44001h;

    /* renamed from: i  reason: collision with root package name */
    public int f44002i;
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

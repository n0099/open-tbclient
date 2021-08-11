package com.baidu.apollon.beans;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f37606a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f37607b = -15;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37608c = -16;

    /* renamed from: d  reason: collision with root package name */
    public static final int f37609d = -2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37610e = -3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f37611f = -4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37612g = -5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f37613h = 5003;

    /* renamed from: i  reason: collision with root package name */
    public static final int f37614i = -7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f37615j = -8;
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

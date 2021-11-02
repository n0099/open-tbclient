package com.baidu.apollon.beans;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f35903a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f35904b = -15;

    /* renamed from: c  reason: collision with root package name */
    public static final int f35905c = -16;

    /* renamed from: d  reason: collision with root package name */
    public static final int f35906d = -2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f35907e = -3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f35908f = -4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f35909g = -5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f35910h = 5003;

    /* renamed from: i  reason: collision with root package name */
    public static final int f35911i = -7;
    public static final int j = -8;
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

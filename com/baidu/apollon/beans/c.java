package com.baidu.apollon.beans;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f3694a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3695b = -15;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3696c = -16;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3697d = -2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3698e = -3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f3699f = -4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f3700g = -5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f3701h = 5003;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3702i = -7;
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

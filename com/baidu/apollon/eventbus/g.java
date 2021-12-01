package com.baidu.apollon.eventbus;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f32974b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32975c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32976d;

    /* renamed from: e  reason: collision with root package name */
    public final EventBus.ThreadMode f32977e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f32978f;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, method, str, Integer.valueOf(i2), threadMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
        this.f32974b = method;
        this.f32976d = str;
        this.f32975c = i2;
        this.f32977e = threadMode;
        this.f32978f = true;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return this.a == gVar.a && this.f32974b.equals(gVar.f32974b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.hashCode() + this.f32974b.hashCode() : invokeV.intValue;
    }
}

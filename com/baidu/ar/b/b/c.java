package com.baidu.ar.b.b;

import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class c<T> extends com.baidu.ar.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int cI;

    /* renamed from: cn  reason: collision with root package name */
    public FramePixels f32853cn;

    public c(int i2, FramePixels framePixels) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), framePixels};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cI = i2;
        this.f32853cn = framePixels;
    }

    @Override // com.baidu.ar.c.a
    public T ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (com.baidu.ar.b.a.as().c(this.cI)) {
                try {
                    com.baidu.ar.b.a.as().a(this.cI, true);
                    return e(this.f32853cn);
                } finally {
                    com.baidu.ar.b.a.as().a(this.cI, false);
                }
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public abstract T e(FramePixels framePixels);
}

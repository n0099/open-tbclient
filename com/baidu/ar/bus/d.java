package com.baidu.ar.bus;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c kG;
    public c kH;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this) {
                try {
                    if (cVar == null) {
                        throw new NullPointerException("null cannot be enqueued");
                    }
                    if (this.kH != null) {
                        this.kH.kF = cVar;
                        this.kH = cVar;
                    } else if (this.kG != null) {
                        throw new IllegalStateException("Head present, but no tail");
                    } else {
                        this.kH = cVar;
                        this.kG = cVar;
                    }
                    notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public synchronized c cH() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                cVar = this.kG;
                if (this.kG != null) {
                    c cVar2 = this.kG.kF;
                    this.kG = cVar2;
                    if (cVar2 == null) {
                        this.kH = null;
                    }
                }
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}

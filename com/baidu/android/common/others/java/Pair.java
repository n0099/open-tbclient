package com.baidu.android.common.others.java;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public class Pair<F, S> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final F mFirst;
    public final S mSecond;

    public Pair(F f, S s) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, s};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFirst = f;
        this.mSecond = s;
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, a, b)) == null) {
            return new Pair<>(a, b);
        }
        return (Pair) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            try {
                Pair pair = (Pair) obj;
                if (this.mFirst.equals(pair.mFirst) && this.mSecond.equals(pair.mSecond)) {
                    return true;
                }
                return false;
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((this.mFirst.hashCode() + 31) * 31) + this.mSecond.hashCode();
        }
        return invokeV.intValue;
    }
}

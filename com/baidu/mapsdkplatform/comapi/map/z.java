package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ab a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26758b;

    /* renamed from: c  reason: collision with root package name */
    public int f26759c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26760d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26761e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26762f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26763g;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ab();
        this.f26758b = true;
        this.f26759c = 1;
        this.f26760d = true;
        this.f26761e = true;
        this.f26762f = true;
        this.f26763g = true;
    }

    public z a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.f26759c = i;
            return this;
        }
        return (z) invokeI.objValue;
    }

    public z a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abVar)) == null) {
            this.a = abVar;
            return this;
        }
        return (z) invokeL.objValue;
    }

    public z a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f26758b = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.f26760d = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f26761e = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f26762f = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f26763g = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }
}

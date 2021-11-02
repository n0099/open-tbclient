package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ab f40191a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40192b;

    /* renamed from: c  reason: collision with root package name */
    public int f40193c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40194d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40195e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40196f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40197g;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40191a = new ab();
        this.f40192b = true;
        this.f40193c = 1;
        this.f40194d = true;
        this.f40195e = true;
        this.f40196f = true;
        this.f40197g = true;
    }

    public z a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f40193c = i2;
            return this;
        }
        return (z) invokeI.objValue;
    }

    public z a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abVar)) == null) {
            this.f40191a = abVar;
            return this;
        }
        return (z) invokeL.objValue;
    }

    public z a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f40192b = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.f40194d = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f40195e = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f40196f = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f40197g = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }
}

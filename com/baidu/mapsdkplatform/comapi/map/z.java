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
    public boolean f34562b;

    /* renamed from: c  reason: collision with root package name */
    public int f34563c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34564d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34565e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34566f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34567g;

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
        this.a = new ab();
        this.f34562b = true;
        this.f34563c = 1;
        this.f34564d = true;
        this.f34565e = true;
        this.f34566f = true;
        this.f34567g = true;
    }

    public z a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f34563c = i2;
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
            this.f34562b = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.f34564d = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f34565e = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f34566f = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f34567g = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }
}

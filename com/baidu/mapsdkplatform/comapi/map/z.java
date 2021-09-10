package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ab f42304a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42305b;

    /* renamed from: c  reason: collision with root package name */
    public int f42306c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42307d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42308e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42310g;

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
        this.f42304a = new ab();
        this.f42305b = true;
        this.f42306c = 1;
        this.f42307d = true;
        this.f42308e = true;
        this.f42309f = true;
        this.f42310g = true;
    }

    public z a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f42306c = i2;
            return this;
        }
        return (z) invokeI.objValue;
    }

    public z a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abVar)) == null) {
            this.f42304a = abVar;
            return this;
        }
        return (z) invokeL.objValue;
    }

    public z a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f42305b = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.f42307d = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f42308e = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f42309f = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }

    public z e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f42310g = z;
            return this;
        }
        return (z) invokeZ.objValue;
    }
}

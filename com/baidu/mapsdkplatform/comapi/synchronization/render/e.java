package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public f f26874b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1502455110, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1502455110, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/e;");
        }
    }

    public e(Context context, BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baiduMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f a2 = f.a();
        this.f26874b = a2;
        a2.a(baiduMap);
    }

    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.e();
    }

    public void a(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.a(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.a(i, i2, i3, i4);
    }

    public void a(d dVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.a(dVar);
    }

    public void b() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.f();
    }

    public void b(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.d(i);
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            f fVar = this.f26874b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.b();
        }
        return (Marker) invokeV.objValue;
    }

    public void c(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.b(i);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f fVar = this.f26874b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.c(i);
    }

    public Marker e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            f fVar = this.f26874b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.d();
        }
        return (Marker) invokeV.objValue;
    }

    public void f() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.g();
        this.f26874b = null;
    }

    public void g() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fVar = this.f26874b) == null) {
            return;
        }
        fVar.h();
    }
}

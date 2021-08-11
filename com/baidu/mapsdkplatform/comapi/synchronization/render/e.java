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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42258a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public f f42259b;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f a2 = f.a();
        this.f42259b = a2;
        a2.a(baiduMap);
    }

    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.e();
    }

    public void a(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.a(i2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.a(i2, i3, i4, i5);
    }

    public void a(d dVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.a(dVar);
    }

    public void b() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.f();
    }

    public void b(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.d(i2);
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            f fVar = this.f42259b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42258a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.b();
        }
        return (Marker) invokeV.objValue;
    }

    public void c(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.b(i2);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f fVar = this.f42259b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42258a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.c(i2);
    }

    public Marker e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            f fVar = this.f42259b;
            if (fVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42258a, "The mSyncRenderStrategic created failed");
                return null;
            }
            return fVar.d();
        }
        return (Marker) invokeV.objValue;
    }

    public void f() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.g();
        this.f42259b = null;
    }

    public void g() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fVar = this.f42259b) == null) {
            return;
        }
        fVar.h();
    }
}

package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
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
/* loaded from: classes10.dex */
public class SynchronizationDisplayManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SynchronizationDisplayManager";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.a.a f35705b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1616636130, "Lcom/baidu/mapapi/synchronization/SynchronizationDisplayManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1616636130, "Lcom/baidu/mapapi/synchronization/SynchronizationDisplayManager;");
        }
    }

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baiduMap, roleOptions, displayOptions};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35705b = new com.baidu.mapsdkplatform.comapi.synchronization.a.a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.g();
            }
        }
    }

    public void adjustVisibleSpanByUser(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(i2, i3, i4, i5);
            }
        }
    }

    public Marker getCarMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
                return null;
            }
            return aVar.f();
        }
        return (Marker) invokeV.objValue;
    }

    public Marker getEndPositionMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
                return null;
            }
            return aVar.e();
        }
        return (Marker) invokeV.objValue;
    }

    public Marker getStartPositionMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
                return null;
            }
            return aVar.d();
        }
        return (Marker) invokeV.objValue;
    }

    public boolean isHttpsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
                return true;
            }
            return aVar.h();
        }
        return invokeV.booleanValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.b();
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a();
            }
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, synchronizationDisplayListener) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(synchronizationDisplayListener);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.c();
            }
        }
    }

    public void setDriverPositionFreshFrequency(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.b(i2);
            }
        }
    }

    public void setHttpsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(z);
            }
        }
    }

    public void setOperatedMapFrozenInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.c(i2);
            }
        }
    }

    public void setUnOperatedMapFrozenInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.d(i2);
            }
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, synchronizationDisplayListener) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.b(synchronizationDisplayListener);
            }
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.c(view);
            }
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, displayOptions) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(displayOptions);
            }
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.b(view);
            }
        }
    }

    public void updateOrderState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(i2);
            }
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, roleOptions) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(roleOptions);
            }
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.a.a aVar = this.f35705b;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The implement instance is null");
            } else {
                aVar.a(view);
            }
        }
    }
}

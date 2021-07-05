package com.baidu.mapsdkplatform.comapi.synchronization.a;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapapi.synchronization.SynchronizationDisplayListener;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.k;
import com.baidu.mapsdkplatform.comapi.synchronization.data.l;
import com.baidu.mapsdkplatform.comapi.synchronization.render.d;
import com.baidu.mapsdkplatform.comapi.synchronization.render.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements k, d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7775a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public l f7776b;

    /* renamed from: c  reason: collision with root package name */
    public e f7777c;

    /* renamed from: d  reason: collision with root package name */
    public SynchronizationDisplayListener f7778d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-879724963, "Lcom/baidu/mapsdkplatform/comapi/synchronization/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-879724963, "Lcom/baidu/mapsdkplatform/comapi/synchronization/a/a;");
        }
    }

    public a(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
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
        this.f7776b = null;
        this.f7777c = null;
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: Context invalid, please check!");
        }
        if (baiduMap == null || !(baiduMap instanceof BaiduMap)) {
            throw new IllegalArgumentException("BDMapSDKException: BaiduMap is null or invalid, please check!");
        }
        if (!b(roleOptions)) {
            throw new IllegalArgumentException("BDMapSDKException: RoleOptions is invalid, please check!");
        }
        l lVar = new l(roleOptions, displayOptions);
        this.f7776b = lVar;
        lVar.a(this);
        e eVar = new e(context, baiduMap);
        this.f7777c = eVar;
        eVar.a(this);
    }

    private boolean a(LatLng latLng, RoleOptions roleOptions) {
        InterceptResult invokeLL;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, latLng, roleOptions)) == null) {
            if (latLng == null) {
                return false;
            }
            double d3 = -180.0d;
            double d4 = 180.0d;
            double d5 = -90.0d;
            double d6 = 90.0d;
            double d7 = 0.0d;
            if (SyncCoordinateConverter.CoordType.COMMON == roleOptions.getCoordType()) {
                SyncCoordinateConverter syncCoordinateConverter = new SyncCoordinateConverter();
                LatLng convert = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(-90.0d, -180.0d)).convert();
                double d8 = convert.longitude;
                double d9 = convert.latitude;
                LatLng convert2 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(90.0d, 180.0d)).convert();
                double d10 = convert2.longitude;
                double d11 = convert2.latitude;
                LatLng convert3 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(0.0d, 0.0d)).convert();
                d7 = convert3.longitude;
                d2 = convert3.latitude;
                d4 = d10;
                d6 = d11;
                d3 = d8;
                d5 = d9;
            } else {
                d2 = 0.0d;
            }
            if (Double.valueOf(d7).compareTo(Double.valueOf(latLng.longitude)) == 0 && Double.valueOf(d2).compareTo(Double.valueOf(latLng.latitude)) == 0) {
                return false;
            }
            double d12 = latLng.longitude;
            if (d12 >= d3 && d12 <= d4) {
                double d13 = latLng.latitude;
                if (d13 >= d5 && d13 <= d6) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(SyncCoordinateConverter.CoordType coordType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, coordType)) == null) ? SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType : invokeL.booleanValue;
    }

    private boolean b(RoleOptions roleOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, roleOptions)) == null) {
            if (roleOptions == null || roleOptions.getOrderId() == null || roleOptions.getOrderId().equals("") || roleOptions.getRoleType() != 0 || roleOptions.getDriverId() == null || roleOptions.getDriverId().equals("") || roleOptions.getUserId() == null || roleOptions.getUserId().equals("") || !a(roleOptions.getCoordType()) || !a(roleOptions.getStartPosition(), roleOptions)) {
                if (roleOptions == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7775a, "The roleOptions is null");
                    return false;
                }
                String str = f7775a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "The roleOptions content is: OrderId = " + roleOptions.getOrderId() + "; DriverId = " + roleOptions.getDriverId() + "; UserId = " + roleOptions.getUserId() + "; StartPosition = " + roleOptions.getStartPosition() + "; EndPosition = " + roleOptions.getEndPosition() + "; DriverPosition = " + roleOptions.getDriverPosition() + "; CoordType = " + roleOptions.getCoordType());
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) ? i2 >= 0 && i2 <= 5 : invokeI.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7775a, MissionEvent.MESSAGE_RESUME);
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.a();
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void a(float f2, long j) {
        SynchronizationDisplayListener synchronizationDisplayListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Long.valueOf(j)}) == null) || (synchronizationDisplayListener = this.f7778d) == null) {
            return;
        }
        synchronizationDisplayListener.onRoutePlanInfoFreshFinished(f2, j);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            String str = f7775a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
            if (!e(i2)) {
                SynchronizationDisplayListener synchronizationDisplayListener = this.f7778d;
                if (synchronizationDisplayListener != null) {
                    synchronizationDisplayListener.onSynchronizationProcessResult(1002, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_STATE_INVALID);
                }
                i2 = 0;
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.a(i2);
            }
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.a(i2);
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (eVar = this.f7777c) == null) {
            return;
        }
        eVar.a(i2, i3, i4, i5);
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.render.d
    public void a(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (synchronizationDisplayListener = this.f7778d) == null) {
            return;
        }
        synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
    }

    public void a(View view) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (lVar = this.f7776b) == null) {
            return;
        }
        lVar.a(view);
    }

    public void a(DisplayOptions displayOptions) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, displayOptions) == null) || (lVar = this.f7776b) == null || displayOptions == null) {
            return;
        }
        lVar.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, roleOptions) == null) {
            if (roleOptions == null || !b(roleOptions)) {
                SynchronizationDisplayListener synchronizationDisplayListener = this.f7778d;
                if (synchronizationDisplayListener != null) {
                    synchronizationDisplayListener.onSynchronizationProcessResult(1003, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID);
                    return;
                }
                return;
            }
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.a(roleOptions);
            }
        }
    }

    public void a(SynchronizationDisplayListener synchronizationDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, synchronizationDisplayListener) == null) {
            if (synchronizationDisplayListener != null) {
                this.f7778d = synchronizationDisplayListener;
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7775a, "SynchronizationDisplayListener is null, must be applied.");
                throw new IllegalArgumentException("BDMapSDKException: synchronizationDisplayListener is null");
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            c.f7821b = z;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7775a, MissionEvent.MESSAGE_PAUSE);
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.b();
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 < 2) {
                i2 = 2;
            }
            if (i2 > 30) {
                i2 = 30;
            }
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.b(i2);
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.b(i2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void b(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) || (synchronizationDisplayListener = this.f7778d) == null) {
            return;
        }
        synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
    }

    public void b(View view) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || (lVar = this.f7776b) == null) {
            return;
        }
        lVar.b(view);
    }

    public void b(SynchronizationDisplayListener synchronizationDisplayListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, synchronizationDisplayListener) == null) || this.f7778d == null) {
            return;
        }
        this.f7778d = null;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7775a, "release");
            l lVar = this.f7776b;
            if (lVar != null) {
                lVar.c();
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.f();
            }
            if (this.f7778d != null) {
                this.f7778d = null;
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            if (i2 > 30) {
                i2 = 30;
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.c(i2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void c(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i2, str) == null) || (synchronizationDisplayListener = this.f7778d) == null) {
            return;
        }
        synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
    }

    public void c(View view) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (lVar = this.f7776b) == null) {
            return;
        }
        lVar.c(view);
    }

    public Marker d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            e eVar = this.f7777c;
            if (eVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7775a, "Data manager instance is null");
                return null;
            }
            return eVar.c();
        }
        return (Marker) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 < 5) {
                i2 = 5;
            }
            if (i2 > 30) {
                i2 = 30;
            }
            e eVar = this.f7777c;
            if (eVar != null) {
                eVar.d(i2);
            }
        }
    }

    public Marker e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            e eVar = this.f7777c;
            if (eVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7775a, "Data manager instance is null");
                return null;
            }
            return eVar.d();
        }
        return (Marker) invokeV.objValue;
    }

    public Marker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            e eVar = this.f7777c;
            if (eVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7775a, "Data manager instance is null");
                return null;
            }
            return eVar.e();
        }
        return (Marker) invokeV.objValue;
    }

    public void g() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (eVar = this.f7777c) == null) {
            return;
        }
        eVar.g();
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? c.f7821b : invokeV.booleanValue;
    }
}

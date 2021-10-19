package c.a.r0.x1.l;

import android.location.Address;
import c.a.e.e.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.location.LocationCallback;
import com.baidu.searchbox.live.interfaces.location.LocationInfo;
import com.baidu.searchbox.live.interfaces.service.LiveLocationService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements LiveLocationService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocationCallback f28271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f28272b;

        public a(b bVar, LocationCallback locationCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, locationCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28272b = bVar;
            this.f28271a = locationCallback;
        }

        @Override // c.a.e.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                try {
                    if (this.f28271a != null) {
                        this.f28271a.onReceiveLocation(this.f28272b.b(address));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final LocationInfo b(Address address) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, address)) == null) {
            LocationInfo locationInfo = new LocationInfo();
            if (address != null) {
                locationInfo.setCity(address.getLocality());
                locationInfo.setLatitude(address.getLatitude());
                locationInfo.setLongitude(address.getLongitude());
                locationInfo.setProvince(address.getAdminArea());
                locationInfo.setCounty(address.getCountryName());
            }
            return locationInfo;
        }
        return (LocationInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public LocationInfo getLocationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b(c.a.e.e.i.a.l().i(false, null)) : (LocationInfo) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public void requestLocate(LocationCallback locationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locationCallback) == null) {
            c.a.e.e.i.a.l().i(true, new a(this, locationCallback));
        }
    }
}

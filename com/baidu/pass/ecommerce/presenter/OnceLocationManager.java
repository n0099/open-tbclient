package com.baidu.pass.ecommerce.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.pass.ecommerce.callback.GetLocationCallback;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class OnceLocationManager implements GetLocationCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OnceLocationManager";
    public static OnceLocationManager manager;
    public transient /* synthetic */ FieldHolder $fh;
    public GetLocationCallback mGetLocationCallback;

    public OnceLocationManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static OnceLocationManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (manager == null) {
                manager = new OnceLocationManager();
            }
            return manager;
        }
        return (OnceLocationManager) invokeV.objValue;
    }

    public BDLocation convertBdLocation(double d, double d2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), str})) == null) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLatitude(d);
            bDLocation.setLongitude(d2);
            return LocationClient.getBDLocationInCoorType(bDLocation, str);
        }
        return (BDLocation) invokeCommon.objValue;
    }

    @Override // com.baidu.pass.ecommerce.callback.GetLocationCallback
    public void onGetLocation(double d, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), Double.valueOf(d2)}) == null) {
            Log.d(TAG, "onGetLocation lat=" + d + ", lng=" + d2);
            GetLocationCallback getLocationCallback = this.mGetLocationCallback;
            if (getLocationCallback != null) {
                getLocationCallback.onGetLocation(d, d2);
            }
            this.mGetLocationCallback = null;
        }
    }

    public void requestLocation(GetLocationCallback getLocationCallback) {
        MapStatusAndLocateCallback mapStatusAndLocateCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getLocationCallback) == null) {
            this.mGetLocationCallback = getLocationCallback;
            AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
            if (addressManageDTO != null && (mapStatusAndLocateCallback = addressManageDTO.mapStatusAndLocateCallback) != null) {
                mapStatusAndLocateCallback.requestLocation(this);
            }
        }
    }
}

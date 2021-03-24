package com.baidu.pass.ecommerce.presenter;

import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.pass.ecommerce.callback.GetLocationCallback;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public class OnceLocationManager implements GetLocationCallback {
    public static final String TAG = "OnceLocationManager";
    public static OnceLocationManager manager;
    public GetLocationCallback mGetLocationCallback;

    public static OnceLocationManager getInstance() {
        if (manager == null) {
            manager = new OnceLocationManager();
        }
        return manager;
    }

    public BDLocation convertBdLocation(double d2, double d3, String str) {
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLatitude(d2);
        bDLocation.setLongitude(d3);
        return LocationClient.getBDLocationInCoorType(bDLocation, str);
    }

    @Override // com.baidu.pass.ecommerce.callback.GetLocationCallback
    public void onGetLocation(double d2, double d3) {
        Log.d(TAG, "onGetLocation lat=" + d2 + ", lng=" + d3);
        GetLocationCallback getLocationCallback = this.mGetLocationCallback;
        if (getLocationCallback != null) {
            getLocationCallback.onGetLocation(d2, d3);
        }
        this.mGetLocationCallback = null;
    }

    public void requestLocation(GetLocationCallback getLocationCallback) {
        MapStatusAndLocateCallback mapStatusAndLocateCallback;
        this.mGetLocationCallback = getLocationCallback;
        AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
        if (addressManageDTO == null || (mapStatusAndLocateCallback = addressManageDTO.mapStatusAndLocateCallback) == null) {
            return;
        }
        mapStatusAndLocateCallback.requestLocation(this);
    }
}

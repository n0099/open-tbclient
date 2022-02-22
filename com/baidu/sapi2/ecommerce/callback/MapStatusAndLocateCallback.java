package com.baidu.sapi2.ecommerce.callback;

import com.baidu.pass.ecommerce.callback.GetLocationCallback;
/* loaded from: classes11.dex */
public interface MapStatusAndLocateCallback {
    boolean isMapInitSuccess();

    void requestLocation(GetLocationCallback getLocationCallback);
}

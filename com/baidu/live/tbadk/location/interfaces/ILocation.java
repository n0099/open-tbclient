package com.baidu.live.tbadk.location.interfaces;

import com.baidu.live.tbadk.location.LocationInfo;
/* loaded from: classes11.dex */
public interface ILocation {
    void getLocation(LocationCallback locationCallback);

    LocationInfo getLocationInfo();

    void requestLocate();
}

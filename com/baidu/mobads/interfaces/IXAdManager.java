package com.baidu.mobads.interfaces;

import android.location.Location;
/* loaded from: classes7.dex */
public interface IXAdManager {
    String getVersion();

    IXAdContext newAdContext();

    void setAppSid(String str);

    void setLocation(Location location);
}

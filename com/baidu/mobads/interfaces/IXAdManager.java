package com.baidu.mobads.interfaces;

import android.location.Location;
/* loaded from: classes8.dex */
public interface IXAdManager {
    String getVersion();

    IXAdContext newAdContext();

    void setAppSid(String str);

    void setLocation(Location location);
}

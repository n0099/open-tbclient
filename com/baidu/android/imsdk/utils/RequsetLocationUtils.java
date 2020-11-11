package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.List;
/* loaded from: classes18.dex */
public class RequsetLocationUtils extends BaseUtils {
    public static Location getLocatioin(Context context) {
        String str;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            List<String> providers = locationManager.getProviders(true);
            if (providers.contains("gps")) {
                str = "gps";
            } else if (providers.contains("network")) {
                str = "network";
            } else {
                LogUtils.e("RequsetLocationUtils", "no available provider");
                return null;
            }
            return locationManager.getLastKnownLocation(str);
        }
        return null;
    }
}

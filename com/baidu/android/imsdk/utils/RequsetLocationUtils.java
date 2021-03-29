package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.List;
/* loaded from: classes.dex */
public class RequsetLocationUtils extends BaseUtils {
    public static Location getLocatioin(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            List<String> providers = locationManager.getProviders(true);
            String str = "gps";
            if (!providers.contains("gps")) {
                if (providers.contains("network")) {
                    str = "network";
                } else {
                    LogUtils.e("RequsetLocationUtils", "no available provider");
                }
            }
            return locationManager.getLastKnownLocation(str);
        }
        return null;
    }
}

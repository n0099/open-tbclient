package com.baidu.location;
/* loaded from: classes.dex */
public final class BDLocationStatusCodes {
    public static final int ERROR = 1;
    public static final int GEOFENCE_NOT_AVAIABLE = 1000;
    public static final int GEOFENCE_SERVICE_NO_ALIVIABLE = 1002;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int SUCCESS = 0;

    public static int getStatusCode(int i) {
        if (i < 0 || i > 1) {
            if (1000 > i || i > 1002) {
                return 1;
            }
            return i;
        }
        return i;
    }
}

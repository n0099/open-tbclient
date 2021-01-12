package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.g;
/* loaded from: classes6.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes6.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    private static g a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        g.a tM = a(context).tM();
        if (tM != null) {
            return tM.g();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        g a2 = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        g.a R = a2.R(str, "upc");
        if (R != null) {
            targetPackageCuidV270Info.upcChannelCuid = R.g();
        }
        g.a R2 = a2.R(str, "isc");
        if (R2 != null) {
            targetPackageCuidV270Info.iscChannelCuid = R2.g();
        }
        return targetPackageCuidV270Info;
    }
}

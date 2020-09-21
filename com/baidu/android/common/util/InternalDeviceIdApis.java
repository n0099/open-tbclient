package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.g;
/* loaded from: classes18.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes18.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    private static g a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        g.a uu = a(context).uu();
        if (uu != null) {
            return uu.g();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        g a = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        g.a T = a.T(str, "upc");
        if (T != null) {
            targetPackageCuidV270Info.upcChannelCuid = T.g();
        }
        g.a T2 = a.T(str, "isc");
        if (T2 != null) {
            targetPackageCuidV270Info.iscChannelCuid = T2.g();
        }
        return targetPackageCuidV270Info;
    }
}

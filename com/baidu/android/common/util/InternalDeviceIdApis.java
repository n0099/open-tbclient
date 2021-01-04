package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.g;
/* loaded from: classes4.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes4.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    private static g a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        g.a tV = a(context).tV();
        if (tV != null) {
            return tV.g();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        g a2 = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        g.a S = a2.S(str, "upc");
        if (S != null) {
            targetPackageCuidV270Info.upcChannelCuid = S.g();
        }
        g.a S2 = a2.S(str, "isc");
        if (S2 != null) {
            targetPackageCuidV270Info.iscChannelCuid = S2.g();
        }
        return targetPackageCuidV270Info;
    }
}

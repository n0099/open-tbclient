package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.g;
/* loaded from: classes5.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes5.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    private static g a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        g.a tJ = a(context).tJ();
        if (tJ != null) {
            return tJ.g();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        g a2 = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        g.a P = a2.P(str, "upc");
        if (P != null) {
            targetPackageCuidV270Info.upcChannelCuid = P.g();
        }
        g.a P2 = a2.P(str, "isc");
        if (P2 != null) {
            targetPackageCuidV270Info.iscChannelCuid = P2.g();
        }
        return targetPackageCuidV270Info;
    }
}

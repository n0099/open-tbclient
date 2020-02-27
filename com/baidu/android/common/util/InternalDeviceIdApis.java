package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.g;
/* loaded from: classes13.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes13.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    private static g a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        g.a nG = a(context).nG();
        if (nG != null) {
            return nG.g();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        g a = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        g.a N = a.N(str, "upc");
        if (N != null) {
            targetPackageCuidV270Info.upcChannelCuid = N.g();
        }
        g.a N2 = a.N(str, "isc");
        if (N2 != null) {
            targetPackageCuidV270Info.iscChannelCuid = N2.g();
        }
        return targetPackageCuidV270Info;
    }
}

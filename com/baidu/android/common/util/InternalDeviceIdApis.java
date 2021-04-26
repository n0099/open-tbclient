package com.baidu.android.common.util;

import android.content.Context;
import d.a.j.l;
/* loaded from: classes.dex */
public class InternalDeviceIdApis {

    /* loaded from: classes.dex */
    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    public static l a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        l.a a2 = a(context).a();
        if (a2 != null) {
            return a2.n();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        l a2 = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        l.a d2 = a2.d(str, "upc");
        if (d2 != null) {
            targetPackageCuidV270Info.upcChannelCuid = d2.n();
        }
        l.a d3 = a2.d(str, "isc");
        if (d3 != null) {
            targetPackageCuidV270Info.iscChannelCuid = d3.n();
        }
        return targetPackageCuidV270Info;
    }
}

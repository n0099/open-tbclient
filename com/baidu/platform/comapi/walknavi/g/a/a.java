package com.baidu.platform.comapi.walknavi.g.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {
    public static Bundle a(Bundle bundle, int i2, int i3) {
        return bundle;
    }

    public static Bundle a(Bundle bundle, int i2, int i3, int i4) {
        bundle.putInt("updatetype", i2);
        if (i2 == 1) {
            return a(bundle, i3, i4);
        }
        if (i2 == 2) {
            return b(bundle, i3, i4);
        }
        return null;
    }

    public static Bundle b(Bundle bundle, int i2, int i3) {
        bundle.putInt("totaldist", i2);
        bundle.putInt("totaltime", i3);
        return bundle;
    }
}

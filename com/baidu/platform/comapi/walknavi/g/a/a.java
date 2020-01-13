package com.baidu.platform.comapi.walknavi.g.a;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class a {
    public static Bundle a(Bundle bundle, int i, int i2, int i3) {
        bundle.putInt("updatetype", i);
        if (i == 1) {
            return a(bundle, i2, i3);
        }
        if (i == 2) {
            return b(bundle, i2, i3);
        }
        return null;
    }

    private static Bundle a(Bundle bundle, int i, int i2) {
        return bundle;
    }

    private static Bundle b(Bundle bundle, int i, int i2) {
        bundle.putInt("totaldist", i);
        bundle.putInt("totaltime", i2);
        return bundle;
    }
}

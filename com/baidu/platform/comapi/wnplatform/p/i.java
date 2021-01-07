package com.baidu.platform.comapi.wnplatform.p;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class i {
    private static AudioManager b(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService("audio");
        }
        return null;
    }

    public static int a(Context context) {
        if (b(context) == null) {
            return 0;
        }
        return b(context).getStreamVolume(3);
    }

    public static void a(Context context, int i) {
        if (b(context) != null) {
            b(context).setStreamVolume(3, i, 0);
            if (b(context).isBluetoothScoOn()) {
                com.baidu.platform.comapi.wnplatform.d.a.a("VolumeUtil", "phone state isBluetoothScoOn volume=" + i);
                b(context).setStreamVolume(6, i, 0);
            }
        }
    }
}

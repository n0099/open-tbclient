package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.media.AudioManager;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class h {
    public static int a(Context context) {
        if (b(context) == null) {
            return 0;
        }
        return b(context).getStreamVolume(3);
    }

    public static AudioManager b(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        return null;
    }

    public static void a(Context context, int i2) {
        if (b(context) == null) {
            return;
        }
        b(context).setStreamVolume(3, i2, 0);
        if (b(context).isBluetoothScoOn()) {
            com.baidu.platform.comapi.wnplatform.d.a.a("VolumeUtil", "phone state isBluetoothScoOn volume=" + i2);
            b(context).setStreamVolume(6, i2, 0);
        }
    }
}

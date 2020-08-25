package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
/* loaded from: classes7.dex */
public class a {
    private static a a = null;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            if (z) {
            }
            if (0 == 0) {
                return d.a(context, i, i2, i3, i4, i5);
            }
            return null;
        }
        return null;
    }

    public RTCRoomProvider a(boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            if (z) {
            }
            if (0 == 0) {
                return d.e();
            }
            return null;
        }
        return null;
    }
}

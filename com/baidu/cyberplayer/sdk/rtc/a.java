package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.f;
/* loaded from: classes3.dex */
public class a {
    public static a a;

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
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return f.a(context, i, i2, i3, i4, i5);
    }

    public RTCRoomProvider a(boolean z) {
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return f.e();
    }

    public RTCVideoViewProvider a(Context context, AttributeSet attributeSet, boolean z) {
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return f.a(context, attributeSet);
    }
}

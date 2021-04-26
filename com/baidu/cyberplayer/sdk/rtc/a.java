package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f5217a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5217a == null) {
                f5217a = new a();
            }
            aVar = f5217a;
        }
        return aVar;
    }

    public CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6, boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            return d.a(context, i2, i3, i4, i5, i6);
        }
        return null;
    }

    public RTCRoomProvider a(boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            return d.e();
        }
        return null;
    }

    public RTCVideoViewProvider a(Context context, AttributeSet attributeSet, boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            return d.a(context, attributeSet);
        }
        return null;
    }
}

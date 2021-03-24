package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f5052a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5052a == null) {
                f5052a = new a();
            }
            aVar = f5052a;
        }
        return aVar;
    }

    public CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (CyberCfgManager.getInstance().getCfgBoolValue("enable_rtc", true)) {
            return d.a(context, i, i2, i3, i4, i5);
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

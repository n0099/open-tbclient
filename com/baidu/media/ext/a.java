package com.baidu.media.ext;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
/* loaded from: classes15.dex */
public class a {
    private static CyberMediaExtProvider cjd = null;

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        CaptureManagerProvider createCaptureManagerProvider = a() ? cjd.createCaptureManagerProvider(context, i, i2, i3, i4, i5) : null;
        CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + a());
        return createCaptureManagerProvider;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        RTCVideoViewProvider createRTCVideoView = a() ? cjd.createRTCVideoView(context, attributeSet) : null;
        CyberLog.i("CyberExtRTCInvoker", "createRTCVideoView provider = " + createRTCVideoView + " isExtJarLoader = " + a());
        return createRTCVideoView;
    }

    public static void a(boolean z) {
        if (a()) {
            cjd.setRTCVerbose(z);
        }
    }

    public static boolean a() {
        return cjd != null;
    }

    public static RTCRoomProvider adC() {
        RTCRoomProvider createRtcRoom = a() ? cjd.createRtcRoom() : null;
        CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + a());
        return createRtcRoom;
    }

    public static void b(boolean z) {
        if (a()) {
            cjd.enableRTCCaptureDebug(z);
        }
    }

    public static boolean c(ClassLoader classLoader) {
        if (classLoader != null && !a()) {
            try {
                cjd = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
            } catch (Exception e) {
                cjd = null;
                CyberLog.e("CyberExtRTCInvoker", "CyberMediaExtProviderImpl not found");
            }
        }
        return a();
    }
}

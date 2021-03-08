package com.baidu.media.ext;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
/* loaded from: classes5.dex */
public class a {
    private static CyberMediaExtProvider cjZ = null;

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        CaptureManagerProvider createCaptureManagerProvider = a() ? cjZ.createCaptureManagerProvider(context, i, i2, i3, i4, i5) : null;
        CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + a());
        return createCaptureManagerProvider;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        RTCVideoViewProvider createRTCVideoView = a() ? cjZ.createRTCVideoView(context, attributeSet) : null;
        CyberLog.i("CyberExtRTCInvoker", "createRTCVideoView provider = " + createRTCVideoView + " isExtJarLoader = " + a());
        return createRTCVideoView;
    }

    public static void a(boolean z) {
        if (a()) {
            cjZ.setRTCVerbose(z);
        }
    }

    public static boolean a() {
        return cjZ != null;
    }

    public static RTCRoomProvider abB() {
        RTCRoomProvider createRtcRoom = a() ? cjZ.createRtcRoom() : null;
        CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + a());
        return createRtcRoom;
    }

    public static void b(boolean z) {
        if (a()) {
            cjZ.enableRTCCaptureDebug(z);
        }
    }

    public static boolean c(ClassLoader classLoader) {
        if (classLoader != null && !a()) {
            try {
                cjZ = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
            } catch (Exception e) {
                cjZ = null;
                CyberLog.e("CyberExtRTCInvoker", "CyberMediaExtProviderImpl not found");
            }
        }
        return a();
    }
}

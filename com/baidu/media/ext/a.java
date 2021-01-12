package com.baidu.media.ext;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
/* loaded from: classes14.dex */
public class a {
    private static CyberMediaExtProvider ceq = null;

    public static RTCRoomProvider ZJ() {
        RTCRoomProvider createRtcRoom = a() ? ceq.createRtcRoom() : null;
        CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + a());
        return createRtcRoom;
    }

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        CaptureManagerProvider createCaptureManagerProvider = a() ? ceq.createCaptureManagerProvider(context, i, i2, i3, i4, i5) : null;
        CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + a());
        return createCaptureManagerProvider;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        RTCVideoViewProvider createRTCVideoView = a() ? ceq.createRTCVideoView(context, attributeSet) : null;
        CyberLog.i("CyberExtRTCInvoker", "createRTCVideoView provider = " + createRTCVideoView + " isExtJarLoader = " + a());
        return createRTCVideoView;
    }

    public static void a(boolean z) {
        if (a()) {
            ceq.setRTCVerbose(z);
        }
    }

    public static boolean a() {
        return ceq != null;
    }

    public static void b(boolean z) {
        if (a()) {
            ceq.enableRTCCaptureDebug(z);
        }
    }

    public static boolean c(ClassLoader classLoader) {
        if (classLoader != null && !a()) {
            try {
                ceq = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
            } catch (Exception e) {
                ceq = null;
                CyberLog.e("CyberExtRTCInvoker", "CyberMediaExtProviderImpl not found");
            }
        }
        return a();
    }
}

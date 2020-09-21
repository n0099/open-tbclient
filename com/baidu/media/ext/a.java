package com.baidu.media.ext;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.CyberMediaExtProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
/* loaded from: classes16.dex */
public class a {
    private static CyberMediaExtProvider bEk = null;

    public static RTCRoomProvider TJ() {
        RTCRoomProvider createRtcRoom = a() ? bEk.createRtcRoom() : null;
        CyberLog.i("CyberExtRTCInvoker", "createRtcRoom provider = " + createRtcRoom + " isExtJarLoader = " + a());
        return createRtcRoom;
    }

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        CaptureManagerProvider createCaptureManagerProvider = a() ? bEk.createCaptureManagerProvider(context, i, i2, i3, i4, i5) : null;
        CyberLog.i("CyberExtRTCInvoker", "createCaptureManager provider = " + createCaptureManagerProvider + " isExtJarLoader = " + a());
        return createCaptureManagerProvider;
    }

    public static void a(boolean z) {
        if (a()) {
            bEk.setRTCVerbose(z);
        }
    }

    public static boolean a() {
        return bEk != null;
    }

    public static void b(boolean z) {
        if (a()) {
            bEk.enableRTCCaptureDebug(z);
        }
    }

    public static boolean b(ClassLoader classLoader) {
        if (classLoader != null && !a()) {
            try {
                bEk = (CyberMediaExtProvider) Class.forName("com.baidu.cybermedia.ext.rtc.CyberMediaExtProviderImpl", true, classLoader).newInstance();
            } catch (Exception e) {
                bEk = null;
                e.printStackTrace();
            }
        }
        return a();
    }
}

package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes3.dex */
public class RTCProviderFactory {
    public static RTCProviderFactory mRoomFactory;

    public static synchronized RTCProviderFactory getInstance() {
        RTCProviderFactory rTCProviderFactory;
        synchronized (RTCProviderFactory.class) {
            if (mRoomFactory == null) {
                mRoomFactory = new RTCProviderFactory();
            }
            rTCProviderFactory = mRoomFactory;
        }
        return rTCProviderFactory;
    }

    public CaptureManagerProvider createCaptureManager(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return CyberPlayerCoreInvoker.createCaptureManager(context, i, i2, i3, i4, i5);
    }

    public RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet, boolean z) {
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return CyberPlayerCoreInvoker.createRTCVideoView(context, attributeSet);
    }

    public RTCRoomProvider creteRTCRoom(boolean z) {
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            return null;
        }
        return CyberPlayerCoreInvoker.createRTCRoom();
    }
}

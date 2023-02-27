package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public abstract class CyberMediaExtProvider {
    public abstract CaptureManagerProvider createCaptureManagerProvider(Context context, int i, int i2, int i3, int i4, int i5);

    public abstract RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet);

    public abstract RTCRoomProvider createRtcRoom();

    public abstract void enableRTCCaptureDebug(boolean z);

    public abstract void setRTCVerbose(boolean z);
}

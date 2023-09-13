package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class CyberRTCVideoView {
    public RTCVideoViewProvider mProvider;

    public CyberRTCVideoView(Context context) {
        this(context, null);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet, boolean z) {
        this.mProvider = RTCProviderFactory.getInstance().createRTCVideoView(context, attributeSet, z);
    }

    public SurfaceView getRTCVideoView() {
        RTCVideoViewProvider rTCVideoViewProvider = this.mProvider;
        if (rTCVideoViewProvider != null) {
            return rTCVideoViewProvider.getRTCVideoView();
        }
        return null;
    }
}

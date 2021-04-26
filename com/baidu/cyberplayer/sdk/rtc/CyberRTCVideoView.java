package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class CyberRTCVideoView {

    /* renamed from: a  reason: collision with root package name */
    public RTCVideoViewProvider f5214a;

    public CyberRTCVideoView(Context context) {
        this(context, null);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet, boolean z) {
        this.f5214a = a.a().a(context, attributeSet, z);
    }

    public SurfaceView getRTCVideoView() {
        RTCVideoViewProvider rTCVideoViewProvider = this.f5214a;
        if (rTCVideoViewProvider != null) {
            return rTCVideoViewProvider.getRTCVideoView();
        }
        return null;
    }
}

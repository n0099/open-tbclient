package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes17.dex */
public class CyberRTCVideoView {

    /* renamed from: a  reason: collision with root package name */
    private RTCVideoViewProvider f1424a;

    public CyberRTCVideoView(Context context) {
        this(context, null);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet, boolean z) {
        this.f1424a = a.a().a(context, attributeSet, z);
    }

    public SurfaceView getRTCVideoView() {
        if (this.f1424a != null) {
            return this.f1424a.getRTCVideoView();
        }
        return null;
    }
}

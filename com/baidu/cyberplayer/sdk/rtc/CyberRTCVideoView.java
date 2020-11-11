package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes12.dex */
public class CyberRTCVideoView {

    /* renamed from: a  reason: collision with root package name */
    private RTCVideoViewProvider f1422a;

    public CyberRTCVideoView(Context context) {
        this(context, null);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    public CyberRTCVideoView(Context context, AttributeSet attributeSet, boolean z) {
        this.f1422a = a.a().a(context, attributeSet, z);
    }

    public SurfaceView getRTCVideoView() {
        if (this.f1422a != null) {
            return this.f1422a.getRTCVideoView();
        }
        return null;
    }
}

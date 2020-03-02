package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String cGd;
    private com.baidu.m.b cGn;

    private b() {
        this.cGn = null;
        this.cGd = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b cGo = new b();
    }

    public static b awT() {
        return a.cGo;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cGn != null) {
            this.cGn.stop();
            this.cGn = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cGd = str;
            this.cGn = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void rr(String str) {
        if (this.cGd.equals(str) && this.cGn != null) {
            this.cGn.stop();
            this.cGn = null;
        }
    }

    public boolean rs(String str) {
        return (this.cGd == null || str == null || !this.cGd.equals(str)) ? false : true;
    }

    public void V(String str) {
        if (this.cGn != null) {
            this.cGn.V(str);
        }
    }

    public void stop() {
        if (this.cGn.getPlayerView() != null && this.cGn.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cGn.getPlayerView().getParent()).removeView(this.cGn.getPlayerView());
        }
        if (this.cGn != null) {
            this.cGn.stop();
        }
    }

    public void mute() {
        if (this.cGn != null) {
            this.cGn.mute();
        }
    }

    public void unMute() {
        if (this.cGn != null) {
            this.cGn.unMute();
        }
    }

    public void switchCamera() {
        if (this.cGn != null) {
            this.cGn.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cGn != null) {
            return this.cGn.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cGn != null) {
            this.cGn.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cGn != null) {
            return this.cGn.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cGn != null) {
            return this.cGn.getPlayerView();
        }
        return null;
    }

    public static boolean bI(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bH(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String cGp;
    private com.baidu.m.b cGz;

    private b() {
        this.cGz = null;
        this.cGp = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b cGA = new b();
    }

    public static b awW() {
        return a.cGA;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cGz != null) {
            this.cGz.stop();
            this.cGz = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cGp = str;
            this.cGz = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void rq(String str) {
        if (this.cGp.equals(str) && this.cGz != null) {
            this.cGz.stop();
            this.cGz = null;
        }
    }

    public boolean rr(String str) {
        return (this.cGp == null || str == null || !this.cGp.equals(str)) ? false : true;
    }

    public void V(String str) {
        if (this.cGz != null) {
            this.cGz.V(str);
        }
    }

    public void stop() {
        if (this.cGz.getPlayerView() != null && this.cGz.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cGz.getPlayerView().getParent()).removeView(this.cGz.getPlayerView());
        }
        if (this.cGz != null) {
            this.cGz.stop();
        }
    }

    public void mute() {
        if (this.cGz != null) {
            this.cGz.mute();
        }
    }

    public void unMute() {
        if (this.cGz != null) {
            this.cGz.unMute();
        }
    }

    public void switchCamera() {
        if (this.cGz != null) {
            this.cGz.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cGz != null) {
            return this.cGz.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cGz != null) {
            this.cGz.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cGz != null) {
            return this.cGz.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cGz != null) {
            return this.cGz.getPlayerView();
        }
        return null;
    }

    public static boolean bH(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bG(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

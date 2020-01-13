package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes5.dex */
public class b {
    private String cCe;
    private com.baidu.m.b cCo;

    private b() {
        this.cCo = null;
        this.cCe = "";
    }

    /* loaded from: classes5.dex */
    private static class a {
        private static final b cCp = new b();
    }

    public static b auD() {
        return a.cCp;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cCo != null) {
            this.cCo.stop();
            this.cCo = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cCe = str;
            this.cCo = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void rc(String str) {
        if (this.cCe.equals(str) && this.cCo != null) {
            this.cCo.stop();
            this.cCo = null;
        }
    }

    public boolean rd(String str) {
        return (this.cCe == null || str == null || !this.cCe.equals(str)) ? false : true;
    }

    public void U(String str) {
        if (this.cCo != null) {
            this.cCo.U(str);
        }
    }

    public void stop() {
        if (this.cCo.getPlayerView() != null && this.cCo.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cCo.getPlayerView().getParent()).removeView(this.cCo.getPlayerView());
        }
        if (this.cCo != null) {
            this.cCo.stop();
        }
    }

    public void mute() {
        if (this.cCo != null) {
            this.cCo.mute();
        }
    }

    public void unMute() {
        if (this.cCo != null) {
            this.cCo.unMute();
        }
    }

    public void switchCamera() {
        if (this.cCo != null) {
            this.cCo.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cCo != null) {
            return this.cCo.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cCo != null) {
            this.cCo.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cCo != null) {
            return this.cCo.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cCo != null) {
            return this.cCo.getPlayerView();
        }
        return null;
    }

    public static boolean bE(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bD(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

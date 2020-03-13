package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String cGe;
    private com.baidu.m.b cGo;

    private b() {
        this.cGo = null;
        this.cGe = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b cGp = new b();
    }

    public static b awT() {
        return a.cGp;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cGo != null) {
            this.cGo.stop();
            this.cGo = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cGe = str;
            this.cGo = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void rr(String str) {
        if (this.cGe.equals(str) && this.cGo != null) {
            this.cGo.stop();
            this.cGo = null;
        }
    }

    public boolean rs(String str) {
        return (this.cGe == null || str == null || !this.cGe.equals(str)) ? false : true;
    }

    public void V(String str) {
        if (this.cGo != null) {
            this.cGo.V(str);
        }
    }

    public void stop() {
        if (this.cGo.getPlayerView() != null && this.cGo.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cGo.getPlayerView().getParent()).removeView(this.cGo.getPlayerView());
        }
        if (this.cGo != null) {
            this.cGo.stop();
        }
    }

    public void mute() {
        if (this.cGo != null) {
            this.cGo.mute();
        }
    }

    public void unMute() {
        if (this.cGo != null) {
            this.cGo.unMute();
        }
    }

    public void switchCamera() {
        if (this.cGo != null) {
            this.cGo.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cGo != null) {
            return this.cGo.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cGo != null) {
            this.cGo.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cGo != null) {
            return this.cGo.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cGo != null) {
            return this.cGo.getPlayerView();
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

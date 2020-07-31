package com.baidu.k.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.aq.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String dDP;
    private com.baidu.k.b dDZ;

    private b() {
        this.dDZ = null;
        this.dDP = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dEa = new b();
    }

    public static b aPw() {
        return a.dEa;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dDZ != null) {
            this.dDZ.stop();
            this.dDZ = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dDP = str;
            this.dDZ = new com.baidu.k.b(context, rtcConfig, str, str2);
        }
    }

    public void vt(String str) {
        if (this.dDP.equals(str) && this.dDZ != null) {
            this.dDZ.stop();
            this.dDZ = null;
        }
    }

    public boolean vu(String str) {
        return (this.dDP == null || str == null || !this.dDP.equals(str)) ? false : true;
    }

    public void bl(String str) {
        if (this.dDZ != null) {
            this.dDZ.bl(str);
        }
    }

    public void stop() {
        if (this.dDZ.getPlayerView() != null && this.dDZ.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dDZ.getPlayerView().getParent()).removeView(this.dDZ.getPlayerView());
        }
        if (this.dDZ != null) {
            this.dDZ.stop();
        }
    }

    public void mute() {
        if (this.dDZ != null) {
            this.dDZ.mute();
        }
    }

    public void unMute() {
        if (this.dDZ != null) {
            this.dDZ.unMute();
        }
    }

    public void switchCamera() {
        if (this.dDZ != null) {
            this.dDZ.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dDZ != null) {
            return this.dDZ.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dDZ != null) {
            this.dDZ.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dDZ != null) {
            return this.dDZ.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dDZ != null) {
            return this.dDZ.getPlayerView();
        }
        return null;
    }

    public static boolean bx(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bw(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

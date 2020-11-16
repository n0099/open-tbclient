package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes5.dex */
public class b {
    private String enN;
    private com.baidu.o.b enX;

    private b() {
        this.enX = null;
        this.enN = "";
    }

    /* loaded from: classes5.dex */
    private static class a {
        private static final b enY = new b();
    }

    public static b beS() {
        return a.enY;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.enX != null) {
            this.enX.stop();
            this.enX = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.enN = str;
            this.enX = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void zm(String str) {
        if (this.enN.equals(str) && this.enX != null) {
            this.enX.stop();
            this.enX = null;
        }
    }

    public boolean zn(String str) {
        return (this.enN == null || str == null || !this.enN.equals(str)) ? false : true;
    }

    public void bs(String str) {
        if (this.enX != null) {
            this.enX.bs(str);
        }
    }

    public void stop() {
        if (this.enX.getPlayerView() != null && this.enX.getPlayerView().getParent() != null) {
            ((ViewGroup) this.enX.getPlayerView().getParent()).removeView(this.enX.getPlayerView());
        }
        if (this.enX != null) {
            this.enX.stop();
        }
    }

    public void mute() {
        if (this.enX != null) {
            this.enX.mute();
        }
    }

    public void unMute() {
        if (this.enX != null) {
            this.enX.unMute();
        }
    }

    public void switchCamera() {
        if (this.enX != null) {
            this.enX.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.enX != null) {
            return this.enX.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.enX != null) {
            this.enX.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.enX != null) {
            return this.enX.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.enX != null) {
            return this.enX.getPlayerView();
        }
        return null;
    }

    public static boolean bJ(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bI(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

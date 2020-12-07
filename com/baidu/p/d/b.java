package com.baidu.p.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes15.dex */
public class b {
    private String euN;
    private com.baidu.p.b euX;

    private b() {
        this.euX = null;
        this.euN = "";
    }

    /* loaded from: classes15.dex */
    private static class a {
        private static final b euY = new b();
    }

    public static b bhX() {
        return a.euY;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.euX != null) {
            this.euX.stop();
            this.euX = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.euN = str;
            this.euX = new com.baidu.p.b(context, rtcConfig, str, str2);
        }
    }

    public void zT(String str) {
        if (this.euN.equals(str) && this.euX != null) {
            this.euX.stop();
            this.euX = null;
        }
    }

    public boolean zU(String str) {
        return (this.euN == null || str == null || !this.euN.equals(str)) ? false : true;
    }

    public void bv(String str) {
        if (this.euX != null) {
            this.euX.bv(str);
        }
    }

    public void stop() {
        if (this.euX.getPlayerView() != null && this.euX.getPlayerView().getParent() != null) {
            ((ViewGroup) this.euX.getPlayerView().getParent()).removeView(this.euX.getPlayerView());
        }
        if (this.euX != null) {
            this.euX.stop();
        }
    }

    public void mute() {
        if (this.euX != null) {
            this.euX.mute();
        }
    }

    public void unMute() {
        if (this.euX != null) {
            this.euX.unMute();
        }
    }

    public void switchCamera() {
        if (this.euX != null) {
            this.euX.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.euX != null) {
            return this.euX.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.euX != null) {
            this.euX.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.euX != null) {
            return this.euX.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.euX != null) {
            return this.euX.getPlayerView();
        }
        return null;
    }

    public static boolean cp(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean co(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

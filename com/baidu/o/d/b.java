package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes7.dex */
public class b {
    private String dMX;
    private com.baidu.o.b dNh;

    private b() {
        this.dNh = null;
        this.dMX = "";
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final b dNi = new b();
    }

    public static b aXM() {
        return a.dNi;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dNh != null) {
            this.dNh.stop();
            this.dNh = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dMX = str;
            this.dNh = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void xE(String str) {
        if (this.dMX.equals(str) && this.dNh != null) {
            this.dNh.stop();
            this.dNh = null;
        }
    }

    public boolean xF(String str) {
        return (this.dMX == null || str == null || !this.dMX.equals(str)) ? false : true;
    }

    public void bq(String str) {
        if (this.dNh != null) {
            this.dNh.bq(str);
        }
    }

    public void stop() {
        if (this.dNh.getPlayerView() != null && this.dNh.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dNh.getPlayerView().getParent()).removeView(this.dNh.getPlayerView());
        }
        if (this.dNh != null) {
            this.dNh.stop();
        }
    }

    public void mute() {
        if (this.dNh != null) {
            this.dNh.mute();
        }
    }

    public void unMute() {
        if (this.dNh != null) {
            this.dNh.unMute();
        }
    }

    public void switchCamera() {
        if (this.dNh != null) {
            this.dNh.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dNh != null) {
            return this.dNh.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dNh != null) {
            this.dNh.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dNh != null) {
            return this.dNh.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dNh != null) {
            return this.dNh.getPlayerView();
        }
        return null;
    }

    public static boolean bE(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bD(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

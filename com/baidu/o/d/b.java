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
    private String dNb;
    private com.baidu.o.b dNl;

    private b() {
        this.dNl = null;
        this.dNb = "";
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final b dNm = new b();
    }

    public static b aXM() {
        return a.dNm;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dNl != null) {
            this.dNl.stop();
            this.dNl = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dNb = str;
            this.dNl = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void xF(String str) {
        if (this.dNb.equals(str) && this.dNl != null) {
            this.dNl.stop();
            this.dNl = null;
        }
    }

    public boolean xG(String str) {
        return (this.dNb == null || str == null || !this.dNb.equals(str)) ? false : true;
    }

    public void bq(String str) {
        if (this.dNl != null) {
            this.dNl.bq(str);
        }
    }

    public void stop() {
        if (this.dNl.getPlayerView() != null && this.dNl.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dNl.getPlayerView().getParent()).removeView(this.dNl.getPlayerView());
        }
        if (this.dNl != null) {
            this.dNl.stop();
        }
    }

    public void mute() {
        if (this.dNl != null) {
            this.dNl.mute();
        }
    }

    public void unMute() {
        if (this.dNl != null) {
            this.dNl.unMute();
        }
    }

    public void switchCamera() {
        if (this.dNl != null) {
            this.dNl.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dNl != null) {
            return this.dNl.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dNl != null) {
            this.dNl.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dNl != null) {
            return this.dNl.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dNl != null) {
            return this.dNl.getPlayerView();
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

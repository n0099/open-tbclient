package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes19.dex */
public class b {
    private com.baidu.o.b epF;
    private String epv;

    private b() {
        this.epF = null;
        this.epv = "";
    }

    /* loaded from: classes19.dex */
    private static class a {
        private static final b epG = new b();
    }

    public static b bfz() {
        return a.epG;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.epF != null) {
            this.epF.stop();
            this.epF = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.epv = str;
            this.epF = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void zr(String str) {
        if (this.epv.equals(str) && this.epF != null) {
            this.epF.stop();
            this.epF = null;
        }
    }

    public boolean zs(String str) {
        return (this.epv == null || str == null || !this.epv.equals(str)) ? false : true;
    }

    public void bs(String str) {
        if (this.epF != null) {
            this.epF.bs(str);
        }
    }

    public void stop() {
        if (this.epF.getPlayerView() != null && this.epF.getPlayerView().getParent() != null) {
            ((ViewGroup) this.epF.getPlayerView().getParent()).removeView(this.epF.getPlayerView());
        }
        if (this.epF != null) {
            this.epF.stop();
        }
    }

    public void mute() {
        if (this.epF != null) {
            this.epF.mute();
        }
    }

    public void unMute() {
        if (this.epF != null) {
            this.epF.unMute();
        }
    }

    public void switchCamera() {
        if (this.epF != null) {
            this.epF.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.epF != null) {
            return this.epF.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.epF != null) {
            this.epF.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.epF != null) {
            return this.epF.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.epF != null) {
            return this.epF.getPlayerView();
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

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
    private String ebf;
    private com.baidu.o.b ebp;

    private b() {
        this.ebp = null;
        this.ebf = "";
    }

    /* loaded from: classes19.dex */
    private static class a {
        private static final b ebq = new b();
    }

    public static b bbg() {
        return a.ebq;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.ebp != null) {
            this.ebp.stop();
            this.ebp = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.ebf = str;
            this.ebp = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void yK(String str) {
        if (this.ebf.equals(str) && this.ebp != null) {
            this.ebp.stop();
            this.ebp = null;
        }
    }

    public boolean yL(String str) {
        return (this.ebf == null || str == null || !this.ebf.equals(str)) ? false : true;
    }

    public void bs(String str) {
        if (this.ebp != null) {
            this.ebp.bs(str);
        }
    }

    public void stop() {
        if (this.ebp.getPlayerView() != null && this.ebp.getPlayerView().getParent() != null) {
            ((ViewGroup) this.ebp.getPlayerView().getParent()).removeView(this.ebp.getPlayerView());
        }
        if (this.ebp != null) {
            this.ebp.stop();
        }
    }

    public void mute() {
        if (this.ebp != null) {
            this.ebp.mute();
        }
    }

    public void unMute() {
        if (this.ebp != null) {
            this.ebp.unMute();
        }
    }

    public void switchCamera() {
        if (this.ebp != null) {
            this.ebp.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.ebp != null) {
            return this.ebp.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.ebp != null) {
            this.ebp.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.ebp != null) {
            return this.ebp.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.ebp != null) {
            return this.ebp.getPlayerView();
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

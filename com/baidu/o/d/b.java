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
    private String ejB;
    private com.baidu.o.b ejL;

    private b() {
        this.ejL = null;
        this.ejB = "";
    }

    /* loaded from: classes19.dex */
    private static class a {
        private static final b ejM = new b();
    }

    public static b bcZ() {
        return a.ejM;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.ejL != null) {
            this.ejL.stop();
            this.ejL = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.ejB = str;
            this.ejL = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void zd(String str) {
        if (this.ejB.equals(str) && this.ejL != null) {
            this.ejL.stop();
            this.ejL = null;
        }
    }

    public boolean ze(String str) {
        return (this.ejB == null || str == null || !this.ejB.equals(str)) ? false : true;
    }

    public void bs(String str) {
        if (this.ejL != null) {
            this.ejL.bs(str);
        }
    }

    public void stop() {
        if (this.ejL.getPlayerView() != null && this.ejL.getPlayerView().getParent() != null) {
            ((ViewGroup) this.ejL.getPlayerView().getParent()).removeView(this.ejL.getPlayerView());
        }
        if (this.ejL != null) {
            this.ejL.stop();
        }
    }

    public void mute() {
        if (this.ejL != null) {
            this.ejL.mute();
        }
    }

    public void unMute() {
        if (this.ejL != null) {
            this.ejL.unMute();
        }
    }

    public void switchCamera() {
        if (this.ejL != null) {
            this.ejL.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.ejL != null) {
            return this.ejL.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.ejL != null) {
            this.ejL.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.ejL != null) {
            return this.ejL.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.ejL != null) {
            return this.ejL.getPlayerView();
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

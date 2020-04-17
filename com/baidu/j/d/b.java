package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private com.baidu.j.b dfA;
    private String dfq;

    private b() {
        this.dfA = null;
        this.dfq = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dfB = new b();
    }

    public static b aFh() {
        return a.dfB;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dfA != null) {
            this.dfA.stop();
            this.dfA = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dfq = str;
            this.dfA = new com.baidu.j.b(context, rtcConfig, str, str2);
        }
    }

    public void sE(String str) {
        if (this.dfq.equals(str) && this.dfA != null) {
            this.dfA.stop();
            this.dfA = null;
        }
    }

    public boolean sF(String str) {
        return (this.dfq == null || str == null || !this.dfq.equals(str)) ? false : true;
    }

    public void bk(String str) {
        if (this.dfA != null) {
            this.dfA.bk(str);
        }
    }

    public void stop() {
        if (this.dfA.getPlayerView() != null && this.dfA.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dfA.getPlayerView().getParent()).removeView(this.dfA.getPlayerView());
        }
        if (this.dfA != null) {
            this.dfA.stop();
        }
    }

    public void mute() {
        if (this.dfA != null) {
            this.dfA.mute();
        }
    }

    public void unMute() {
        if (this.dfA != null) {
            this.dfA.unMute();
        }
    }

    public void switchCamera() {
        if (this.dfA != null) {
            this.dfA.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dfA != null) {
            return this.dfA.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dfA != null) {
            this.dfA.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dfA != null) {
            return this.dfA.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dfA != null) {
            return this.dfA.getPlayerView();
        }
        return null;
    }

    public static boolean bv(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bu(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

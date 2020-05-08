package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private com.baidu.j.b dfF;
    private String dfv;

    private b() {
        this.dfF = null;
        this.dfv = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dfG = new b();
    }

    public static b aFh() {
        return a.dfG;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dfF != null) {
            this.dfF.stop();
            this.dfF = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dfv = str;
            this.dfF = new com.baidu.j.b(context, rtcConfig, str, str2);
        }
    }

    public void sE(String str) {
        if (this.dfv.equals(str) && this.dfF != null) {
            this.dfF.stop();
            this.dfF = null;
        }
    }

    public boolean sF(String str) {
        return (this.dfv == null || str == null || !this.dfv.equals(str)) ? false : true;
    }

    public void bk(String str) {
        if (this.dfF != null) {
            this.dfF.bk(str);
        }
    }

    public void stop() {
        if (this.dfF.getPlayerView() != null && this.dfF.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dfF.getPlayerView().getParent()).removeView(this.dfF.getPlayerView());
        }
        if (this.dfF != null) {
            this.dfF.stop();
        }
    }

    public void mute() {
        if (this.dfF != null) {
            this.dfF.mute();
        }
    }

    public void unMute() {
        if (this.dfF != null) {
            this.dfF.unMute();
        }
    }

    public void switchCamera() {
        if (this.dfF != null) {
            this.dfF.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dfF != null) {
            return this.dfF.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dfF != null) {
            this.dfF.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dfF != null) {
            return this.dfF.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dfF != null) {
            return this.dfF.getPlayerView();
        }
        return null;
    }

    public static boolean bj(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bi(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

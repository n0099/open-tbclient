package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class b {
    private String cBT;
    private com.baidu.m.b cCd;

    private b() {
        this.cCd = null;
        this.cBT = "";
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final b cCe = new b();
    }

    public static b auk() {
        return a.cCe;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cCd != null) {
            this.cCd.stop();
            this.cCd = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cBT = str;
            this.cCd = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void qZ(String str) {
        if (this.cBT.equals(str) && this.cCd != null) {
            this.cCd.stop();
            this.cCd = null;
        }
    }

    public boolean ra(String str) {
        return (this.cBT == null || str == null || !this.cBT.equals(str)) ? false : true;
    }

    public void U(String str) {
        if (this.cCd != null) {
            this.cCd.U(str);
        }
    }

    public void stop() {
        if (this.cCd.getPlayerView() != null && this.cCd.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cCd.getPlayerView().getParent()).removeView(this.cCd.getPlayerView());
        }
        if (this.cCd != null) {
            this.cCd.stop();
        }
    }

    public void mute() {
        if (this.cCd != null) {
            this.cCd.mute();
        }
    }

    public void unMute() {
        if (this.cCd != null) {
            this.cCd.unMute();
        }
    }

    public void switchCamera() {
        if (this.cCd != null) {
            this.cCd.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cCd != null) {
            return this.cCd.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cCd != null) {
            this.cCd.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cCd != null) {
            return this.cCd.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cCd != null) {
            return this.cCd.getPlayerView();
        }
        return null;
    }

    public static boolean bE(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bD(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

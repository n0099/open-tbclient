package com.baidu.m.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String cGc;
    private com.baidu.m.b cGm;

    private b() {
        this.cGm = null;
        this.cGc = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b cGn = new b();
    }

    public static b awR() {
        return a.cGn;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.cGm != null) {
            this.cGm.stop();
            this.cGm = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.cGc = str;
            this.cGm = new com.baidu.m.b(context, rtcConfig, str, str2);
        }
    }

    public void rr(String str) {
        if (this.cGc.equals(str) && this.cGm != null) {
            this.cGm.stop();
            this.cGm = null;
        }
    }

    public boolean rs(String str) {
        return (this.cGc == null || str == null || !this.cGc.equals(str)) ? false : true;
    }

    public void V(String str) {
        if (this.cGm != null) {
            this.cGm.V(str);
        }
    }

    public void stop() {
        if (this.cGm.getPlayerView() != null && this.cGm.getPlayerView().getParent() != null) {
            ((ViewGroup) this.cGm.getPlayerView().getParent()).removeView(this.cGm.getPlayerView());
        }
        if (this.cGm != null) {
            this.cGm.stop();
        }
    }

    public void mute() {
        if (this.cGm != null) {
            this.cGm.mute();
        }
    }

    public void unMute() {
        if (this.cGm != null) {
            this.cGm.unMute();
        }
    }

    public void switchCamera() {
        if (this.cGm != null) {
            this.cGm.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.cGm != null) {
            return this.cGm.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.cGm != null) {
            this.cGm.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.cGm != null) {
            return this.cGm.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.cGm != null) {
            return this.cGm.getPlayerView();
        }
        return null;
    }

    public static boolean bI(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bH(Context context) {
        return !com.baidu.swan.apps.as.a.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

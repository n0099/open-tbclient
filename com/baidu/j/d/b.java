package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String dxT;
    private com.baidu.j.b dyd;

    private b() {
        this.dyd = null;
        this.dxT = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dye = new b();
    }

    public static b aLI() {
        return a.dye;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dyd != null) {
            this.dyd.stop();
            this.dyd = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dxT = str;
            this.dyd = new com.baidu.j.b(context, rtcConfig, str, str2);
        }
    }

    public void uq(String str) {
        if (this.dxT.equals(str) && this.dyd != null) {
            this.dyd.stop();
            this.dyd = null;
        }
    }

    public boolean ur(String str) {
        return (this.dxT == null || str == null || !this.dxT.equals(str)) ? false : true;
    }

    public void bl(String str) {
        if (this.dyd != null) {
            this.dyd.bl(str);
        }
    }

    public void stop() {
        if (this.dyd.getPlayerView() != null && this.dyd.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dyd.getPlayerView().getParent()).removeView(this.dyd.getPlayerView());
        }
        if (this.dyd != null) {
            this.dyd.stop();
        }
    }

    public void mute() {
        if (this.dyd != null) {
            this.dyd.mute();
        }
    }

    public void unMute() {
        if (this.dyd != null) {
            this.dyd.unMute();
        }
    }

    public void switchCamera() {
        if (this.dyd != null) {
            this.dyd.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dyd != null) {
            return this.dyd.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dyd != null) {
            this.dyd.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dyd != null) {
            return this.dyd.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dyd != null) {
            return this.dyd.getPlayerView();
        }
        return null;
    }

    public static boolean bu(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bt(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

package com.baidu.o.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.swan.apps.ap.c;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String dPe;
    private com.baidu.o.b dPo;

    private b() {
        this.dPo = null;
        this.dPe = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dPp = new b();
    }

    public static b aYy() {
        return a.dPp;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dPo != null) {
            this.dPo.stop();
            this.dPo = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dPe = str;
            this.dPo = new com.baidu.o.b(context, rtcConfig, str, str2);
        }
    }

    public void xY(String str) {
        if (this.dPe.equals(str) && this.dPo != null) {
            this.dPo.stop();
            this.dPo = null;
        }
    }

    public boolean xZ(String str) {
        return (this.dPe == null || str == null || !this.dPe.equals(str)) ? false : true;
    }

    public void bs(String str) {
        if (this.dPo != null) {
            this.dPo.bs(str);
        }
    }

    public void stop() {
        if (this.dPo.getPlayerView() != null && this.dPo.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dPo.getPlayerView().getParent()).removeView(this.dPo.getPlayerView());
        }
        if (this.dPo != null) {
            this.dPo.stop();
        }
    }

    public void mute() {
        if (this.dPo != null) {
            this.dPo.mute();
        }
    }

    public void unMute() {
        if (this.dPo != null) {
            this.dPo.unMute();
        }
    }

    public void switchCamera() {
        if (this.dPo != null) {
            this.dPo.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dPo != null) {
            return this.dPo.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dPo != null) {
            this.dPo.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dPo != null) {
            return this.dPo.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dPo != null) {
            return this.dPo.getPlayerView();
        }
        return null;
    }

    public static boolean bD(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bC(Context context) {
        return !c.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

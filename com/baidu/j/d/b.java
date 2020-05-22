package com.baidu.j.d;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.rtc.RtcConfig;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class b {
    private String dtj;
    private com.baidu.j.b dtu;

    private b() {
        this.dtu = null;
        this.dtj = "";
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final b dtv = new b();
    }

    public static b aKC() {
        return a.dtv;
    }

    public void a(Context context, RtcConfig rtcConfig, String str, String str2) {
        if (this.dtu != null) {
            this.dtu.stop();
            this.dtu = null;
        }
        if (context != null && rtcConfig != null && str != null && str2 != null) {
            this.dtj = str;
            this.dtu = new com.baidu.j.b(context, rtcConfig, str, str2);
        }
    }

    public void ui(String str) {
        if (this.dtj.equals(str) && this.dtu != null) {
            this.dtu.stop();
            this.dtu = null;
        }
    }

    public boolean uj(String str) {
        return (this.dtj == null || str == null || !this.dtj.equals(str)) ? false : true;
    }

    public void bk(String str) {
        if (this.dtu != null) {
            this.dtu.bk(str);
        }
    }

    public void stop() {
        if (this.dtu.getPlayerView() != null && this.dtu.getPlayerView().getParent() != null) {
            ((ViewGroup) this.dtu.getPlayerView().getParent()).removeView(this.dtu.getPlayerView());
        }
        if (this.dtu != null) {
            this.dtu.stop();
        }
    }

    public void mute() {
        if (this.dtu != null) {
            this.dtu.mute();
        }
    }

    public void unMute() {
        if (this.dtu != null) {
            this.dtu.unMute();
        }
    }

    public void switchCamera() {
        if (this.dtu != null) {
            this.dtu.switchCamera();
        }
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.dtu != null) {
            return this.dtu.updateRTCConfig(rtcConfig);
        }
        return false;
    }

    public void resetPreview() {
        if (this.dtu != null) {
            this.dtu.resetPreview();
        }
    }

    public View getRecorderView() {
        if (this.dtu != null) {
            return this.dtu.getRecorderView();
        }
        return null;
    }

    public View getPlayerView() {
        if (this.dtu != null) {
            return this.dtu.getPlayerView();
        }
        return null;
    }

    public static boolean bt(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public static boolean bs(Context context) {
        return !com.baidu.swan.apps.aq.b.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }
}

package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes12.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1379a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1379a = null;
        if (dlnaProvider != null) {
            this.f1379a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        if (this.f1379a != null) {
            return this.f1379a.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f1379a != null) {
            return this.f1379a.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        if (this.f1379a != null) {
            return this.f1379a.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        if (this.f1379a != null) {
            this.f1379a.pause();
        }
    }

    public void play() {
        if (this.f1379a != null) {
            this.f1379a.play();
        }
    }

    public void seek(long j) {
        if (this.f1379a != null) {
            this.f1379a.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        if (this.f1379a != null) {
            this.f1379a.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.f1379a != null) {
            this.f1379a.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        if (this.f1379a != null) {
            this.f1379a.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i) {
        if (this.f1379a != null) {
            this.f1379a.setPlaybackVolume(i);
        }
    }

    public void shutdown() {
        if (this.f1379a != null) {
            this.f1379a.shutdown();
        }
    }

    public void stop() {
        if (this.f1379a != null) {
            this.f1379a.stop();
        }
    }
}

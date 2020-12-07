package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes17.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1381a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1381a = null;
        if (dlnaProvider != null) {
            this.f1381a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        if (this.f1381a != null) {
            return this.f1381a.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f1381a != null) {
            return this.f1381a.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        if (this.f1381a != null) {
            return this.f1381a.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        if (this.f1381a != null) {
            this.f1381a.pause();
        }
    }

    public void play() {
        if (this.f1381a != null) {
            this.f1381a.play();
        }
    }

    public void seek(long j) {
        if (this.f1381a != null) {
            this.f1381a.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        if (this.f1381a != null) {
            this.f1381a.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.f1381a != null) {
            this.f1381a.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        if (this.f1381a != null) {
            this.f1381a.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i) {
        if (this.f1381a != null) {
            this.f1381a.setPlaybackVolume(i);
        }
    }

    public void shutdown() {
        if (this.f1381a != null) {
            this.f1381a.shutdown();
        }
    }

    public void stop() {
        if (this.f1381a != null) {
            this.f1381a.stop();
        }
    }
}

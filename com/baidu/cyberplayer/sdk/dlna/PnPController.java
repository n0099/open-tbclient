package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes4.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1757a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1757a = null;
        if (dlnaProvider != null) {
            this.f1757a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        if (this.f1757a != null) {
            return this.f1757a.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f1757a != null) {
            return this.f1757a.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        if (this.f1757a != null) {
            return this.f1757a.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        if (this.f1757a != null) {
            this.f1757a.pause();
        }
    }

    public void play() {
        if (this.f1757a != null) {
            this.f1757a.play();
        }
    }

    public void seek(long j) {
        if (this.f1757a != null) {
            this.f1757a.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        if (this.f1757a != null) {
            this.f1757a.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.f1757a != null) {
            this.f1757a.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        if (this.f1757a != null) {
            this.f1757a.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i) {
        if (this.f1757a != null) {
            this.f1757a.setPlaybackVolume(i);
        }
    }

    public void shutdown() {
        if (this.f1757a != null) {
            this.f1757a.shutdown();
        }
    }

    public void stop() {
        if (this.f1757a != null) {
            this.f1757a.stop();
        }
    }
}

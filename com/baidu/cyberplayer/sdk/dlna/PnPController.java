package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes6.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1808a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1808a = null;
        if (dlnaProvider != null) {
            this.f1808a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        if (this.f1808a != null) {
            return this.f1808a.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f1808a != null) {
            return this.f1808a.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        if (this.f1808a != null) {
            return this.f1808a.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        if (this.f1808a != null) {
            this.f1808a.pause();
        }
    }

    public void play() {
        if (this.f1808a != null) {
            this.f1808a.play();
        }
    }

    public void seek(long j) {
        if (this.f1808a != null) {
            this.f1808a.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        if (this.f1808a != null) {
            this.f1808a.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.f1808a != null) {
            this.f1808a.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        if (this.f1808a != null) {
            this.f1808a.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i) {
        if (this.f1808a != null) {
            this.f1808a.setPlaybackVolume(i);
        }
    }

    public void shutdown() {
        if (this.f1808a != null) {
            this.f1808a.shutdown();
        }
    }

    public void stop() {
        if (this.f1808a != null) {
            this.f1808a.stop();
        }
    }
}

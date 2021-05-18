package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes2.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    public CtrlPointProvider f4931a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f4931a = null;
        if (dlnaProvider != null) {
            this.f4931a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.pause();
        }
    }

    public void play() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.play();
        }
    }

    public void seek(long j) {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i2) {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setPlaybackVolume(i2);
        }
    }

    public void shutdown() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.shutdown();
        }
    }

    public void stop() {
        CtrlPointProvider ctrlPointProvider = this.f4931a;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.stop();
        }
    }
}

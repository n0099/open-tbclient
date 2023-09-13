package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes3.dex */
public class PnPController {
    public CtrlPointProvider provider;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.provider = null;
        if (dlnaProvider != null) {
            this.provider = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getCurrentTime();
        }
        return 0L;
    }

    public long getDuration() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getDuration();
        }
        return 0L;
    }

    public int getPlaybackVolume() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            return ctrlPointProvider.getPlaybackVolume();
        }
        return 0;
    }

    public void pause() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.pause();
        }
    }

    public void play() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.play();
        }
    }

    @Deprecated
    public void shutdown() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.shutdown();
        }
    }

    public void stop() {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.stop();
        }
    }

    public int getUrlPlayStatus(String str) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null && str != null) {
            return ctrlPointProvider.getUrlPlayStatus(str);
        }
        return -1;
    }

    public void seek(long j) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.seek(j);
        }
    }

    public void setAVTransportUrl(String str) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setAVTransportUrl(str);
        }
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setListener(ctrlPointListener);
        }
    }

    public void setMute(boolean z) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setMute(z ? 1 : 0);
        }
    }

    public void setPlaybackVolume(int i) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.setPlaybackVolume(i);
        }
    }

    public void shutdown(boolean z) {
        CtrlPointProvider ctrlPointProvider = this.provider;
        if (ctrlPointProvider != null) {
            ctrlPointProvider.shutdown(z);
        }
    }
}

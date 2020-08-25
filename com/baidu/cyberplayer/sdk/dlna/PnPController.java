package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes7.dex */
public class PnPController {
    private CtrlPointProvider a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.a = null;
        this.a = dlnaProvider.ctrlPoint(str);
    }

    public long getCurrentTime() {
        return this.a.getCurrentTime();
    }

    public long getDuration() {
        return this.a.getDuration();
    }

    public int getPlaybackVolume() {
        return this.a.getPlaybackVolume();
    }

    public void pause() {
        this.a.pause();
    }

    public void play() {
        this.a.play();
    }

    public void seek(long j) {
        this.a.seek(j);
    }

    public void setAVTransportUrl(String str) {
        this.a.setAVTransportUrl(str);
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        this.a.setListener(ctrlPointListener);
    }

    public void setPlaybackVolume(int i) {
        this.a.setPlaybackVolume(i);
    }

    public void shutdown() {
        this.a.shutdown();
    }

    public void stop() {
        this.a.stop();
    }
}

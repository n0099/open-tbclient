package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes17.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1382a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1382a = null;
        this.f1382a = dlnaProvider.ctrlPoint(str);
    }

    public long getCurrentTime() {
        return this.f1382a.getCurrentTime();
    }

    public long getDuration() {
        return this.f1382a.getDuration();
    }

    public int getPlaybackVolume() {
        return this.f1382a.getPlaybackVolume();
    }

    public void pause() {
        this.f1382a.pause();
    }

    public void play() {
        this.f1382a.play();
    }

    public void seek(long j) {
        this.f1382a.seek(j);
    }

    public void setAVTransportUrl(String str) {
        this.f1382a.setAVTransportUrl(str);
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        this.f1382a.setListener(ctrlPointListener);
    }

    public void setPlaybackVolume(int i) {
        this.f1382a.setPlaybackVolume(i);
    }

    public void shutdown() {
        this.f1382a.shutdown();
    }

    public void stop() {
        this.f1382a.stop();
    }
}

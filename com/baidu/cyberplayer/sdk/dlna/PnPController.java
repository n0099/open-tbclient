package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
@Keep
/* loaded from: classes12.dex */
public class PnPController {

    /* renamed from: a  reason: collision with root package name */
    private CtrlPointProvider f1380a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        this.f1380a = null;
        this.f1380a = dlnaProvider.ctrlPoint(str);
    }

    public long getCurrentTime() {
        return this.f1380a.getCurrentTime();
    }

    public long getDuration() {
        return this.f1380a.getDuration();
    }

    public int getPlaybackVolume() {
        return this.f1380a.getPlaybackVolume();
    }

    public void pause() {
        this.f1380a.pause();
    }

    public void play() {
        this.f1380a.play();
    }

    public void seek(long j) {
        this.f1380a.seek(j);
    }

    public void setAVTransportUrl(String str) {
        this.f1380a.setAVTransportUrl(str);
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        this.f1380a.setListener(ctrlPointListener);
    }

    public void setPlaybackVolume(int i) {
        this.f1380a.setPlaybackVolume(i);
    }

    public void shutdown() {
        this.f1380a.shutdown();
    }

    public void stop() {
        this.f1380a.stop();
    }
}

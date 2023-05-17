package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public abstract class CtrlPointProvider {

    @Keep
    /* loaded from: classes3.dex */
    public interface CtrlPointListener {
        void onComplete();

        void onError(int i, int i2);

        void onInfo(int i, int i2, Object obj);

        void onPrepared();

        void onSeekCompleted(int i, int i2);
    }

    public abstract long getCurrentTime();

    public abstract long getDuration();

    public abstract int getPlaybackVolume();

    public abstract int getUrlPlayStatus(String str);

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void setAVTransportUrl(String str);

    public abstract void setListener(CtrlPointListener ctrlPointListener);

    public abstract void setMute(int i);

    public abstract void setPlaybackVolume(int i);

    @Deprecated
    public abstract void shutdown();

    public abstract void shutdown(boolean z);

    public abstract void stop();
}

package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public abstract class CtrlPointProvider {

    @Keep
    /* loaded from: classes2.dex */
    public interface CtrlPointListener {
        void onComplete();

        void onError(int i2, int i3);

        void onInfo(int i2, int i3, Object obj);

        void onPrepared();

        void onSeekCompleted(int i2, int i3);
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

    public abstract void setMute(int i2);

    public abstract void setPlaybackVolume(int i2);

    @Deprecated
    public abstract void shutdown();

    public abstract void shutdown(boolean z);

    public abstract void stop();
}

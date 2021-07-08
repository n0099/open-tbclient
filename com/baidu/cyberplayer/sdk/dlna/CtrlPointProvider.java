package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes2.dex */
public abstract class CtrlPointProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes2.dex */
    public interface CtrlPointListener {
        void onComplete();

        void onError(int i2, int i3);

        void onInfo(int i2, int i3, Object obj);

        void onPrepared();

        void onSeekCompleted(int i2, int i3);
    }

    public CtrlPointProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

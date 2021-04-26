package com.baidu.searchbox.player.message;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
/* loaded from: classes2.dex */
public interface IMessenger {
    String getType();

    void notifyEvent(@NonNull VideoEvent videoEvent);

    void register(int i2, @NonNull INeuron iNeuron);

    void release();

    void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor);

    void unregister(INeuron iNeuron);
}

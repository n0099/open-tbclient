package com.baidu.searchbox.player.message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
/* loaded from: classes4.dex */
public interface IMessenger {
    void addInterceptor(int i2, @NonNull IVideoEventInterceptor iVideoEventInterceptor);

    void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor);

    void addInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher);

    String getType();

    void notifyEvent(@NonNull VideoEvent videoEvent);

    void register(int i2, @NonNull INeuron iNeuron);

    void release();

    void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor);

    void removeInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher);

    void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor);

    void unregister(INeuron iNeuron);
}

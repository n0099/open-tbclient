package com.baidu.searchbox.player.interfaces;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoEvent;
/* loaded from: classes11.dex */
public interface IVideoEventInterceptor {
    INeuron getInterceptorLayer();

    boolean onInterceptorEvent(@NonNull VideoEvent videoEvent);
}

package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.event.VideoEvent;
/* loaded from: classes2.dex */
public interface IVideoEventInterceptor {
    INeuron getInterceptorLayer();

    boolean onInterceptorEvent(VideoEvent videoEvent);
}

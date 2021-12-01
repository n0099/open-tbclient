package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.layer.ILayer;
/* loaded from: classes9.dex */
public interface IVideoEventInterceptor {
    ILayer getInterceptorLayer();

    boolean onInterceptorEvent(String str);
}

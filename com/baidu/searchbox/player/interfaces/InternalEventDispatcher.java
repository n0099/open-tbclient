package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.event.VideoEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public interface InternalEventDispatcher {
    public static final int ORDER_FIRST = 1;
    public static final int ORDER_LAST = 2;
    public static final int ORDER_UNSPECIFIED = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Order {
    }

    int getExpectOrder();

    void onVideoEventNotify(VideoEvent videoEvent);
}

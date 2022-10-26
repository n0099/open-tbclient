package com.baidu.searchbox.player.interfaces;

import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public interface INeuron {
    public static final int ORDER_FIRST = 1;
    public static final int ORDER_LAST = 2;
    public static final int ORDER_UNSPECIFIED = 0;
    public static final int TYPE_LAYER = 2;
    public static final int TYPE_PLUGIN = 1;
    public static final int TYPE_SPECIFIED = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Order {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Type {
    }

    int getExpectOrder();

    int[] getSubscribeEvent();

    int getType();

    void onControlEventNotify(VideoEvent videoEvent);

    void onInteractiveEventNotify(VideoEvent videoEvent);

    void onLayerEventNotify(VideoEvent videoEvent);

    void onPlayerEventNotify(VideoEvent videoEvent);

    void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void onSystemEventNotify(VideoEvent videoEvent);

    void onVideoEventNotify(VideoEvent videoEvent);

    void sendEvent(VideoEvent videoEvent);
}

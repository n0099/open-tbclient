package com.baidu.searchbox.player.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public interface INeuron {
    public static final int TYPE_LAYER = 2;
    public static final int TYPE_PLUGIN = 1;
    public static final int TYPE_SPECIFIED = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void onControlEventNotify(@NonNull VideoEvent videoEvent);

    void onLayerEventNotify(@NonNull VideoEvent videoEvent);

    void onPlayerEventNotify(@NonNull VideoEvent videoEvent);

    void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void onSystemEventNotify(@NonNull VideoEvent videoEvent);

    void onVideoEventNotify(@NonNull VideoEvent videoEvent);

    void sendEvent(VideoEvent videoEvent);
}

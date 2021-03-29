package com.baidu.searchbox.player.component;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ComponentLayer;
/* loaded from: classes2.dex */
public interface IComponent {
    View getContentView();

    Context getContext();

    BDVideoPlayer getVideoPlayer();

    void onContainerDetach();

    void onEventNotify(@NonNull VideoEvent videoEvent);

    void onLayerDetach();

    void onLayerRelease();

    void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void sendEvent(VideoEvent videoEvent);

    void setParent(ComponentLayer componentLayer);
}

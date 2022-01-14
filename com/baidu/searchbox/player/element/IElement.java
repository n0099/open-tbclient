package com.baidu.searchbox.player.element;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
/* loaded from: classes11.dex */
public interface IElement {
    @NonNull
    View getContentView();

    Context getContext();

    BDVideoPlayer getVideoPlayer();

    void onContainerDetach();

    void onEventNotify(@NonNull VideoEvent videoEvent);

    void onLayerDetach();

    void onLayerRelease();

    void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void sendEvent(VideoEvent videoEvent);
}

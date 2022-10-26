package com.baidu.searchbox.player.element;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
/* loaded from: classes2.dex */
public interface IElement {
    View getContentView();

    Context getContext();

    BDVideoPlayer getVideoPlayer();

    void onContainerDetach();

    void onEventNotify(VideoEvent videoEvent);

    void onLayerDetach();

    void onLayerRelease();

    void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void sendEvent(VideoEvent videoEvent);
}

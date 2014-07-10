package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
/* loaded from: classes.dex */
public interface LivePlayerControllerListener {
    void onCacheStatusChanged(LivePlayerControl.CACHE_STATUS cache_status);

    void onCachingUpdate(int i);

    void onDebugInfoUpdate(String str);

    void onDurationUpdate(int i);

    void onError(int i);

    void onPlayStatusChanged(LivePlayerControl.PLAYER_STATUS player_status, int i, int i2);

    void onPositionUpdate(int i);

    void onWarning(int i);
}

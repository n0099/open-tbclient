package com.baidu.searchbox.ng.ai.apps.media;
/* loaded from: classes2.dex */
public interface AiAppsPlayerContext {
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_LIVE = 2;
    public static final int TYPE_VIDEO = 1;

    String getPlayerId();

    Object getPlayerObject();

    int getPlayerType();

    String getSlaveId();

    void onAppForegroundChanged(boolean z);

    boolean onBackPressed();

    void onDestroy();

    void onForegroundChanged(boolean z);

    void resetPlayer();
}

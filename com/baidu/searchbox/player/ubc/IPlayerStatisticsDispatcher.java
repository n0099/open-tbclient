package com.baidu.searchbox.player.ubc;
/* loaded from: classes5.dex */
public interface IPlayerStatisticsDispatcher {
    void end(int i2);

    void endInitPlayer();

    void endInitPlayerKernel();

    void goBackOrForeground(boolean z, int i2);

    void onError(int i2, int i3, Object obj);

    void onInfo(int i2, int i3, Object obj);

    void pause();

    void release();

    void resume();

    void start();

    void startInitPlayer();

    void startInitPlayerKernel();

    void stop(int i2);
}

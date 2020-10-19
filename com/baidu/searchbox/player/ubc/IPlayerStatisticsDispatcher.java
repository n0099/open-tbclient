package com.baidu.searchbox.player.ubc;
/* loaded from: classes15.dex */
public interface IPlayerStatisticsDispatcher {
    void end(int i);

    void endInitPlayer();

    void endInitPlayerKernel();

    void goBackOrForeground(boolean z, int i);

    void onError(int i, int i2, Object obj);

    void onInfo(int i, int i2, Object obj);

    void pause();

    void release();

    void resume();

    void start();

    void startInitPlayer();

    void startInitPlayerKernel();

    void stop(int i);
}

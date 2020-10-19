package com.baidu.searchbox.player.helper;
/* loaded from: classes7.dex */
public interface ITimerTask {
    void cancel();

    void doTask();

    void setInterval(int i);

    void start();
}

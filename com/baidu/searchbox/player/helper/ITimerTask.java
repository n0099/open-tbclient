package com.baidu.searchbox.player.helper;
/* loaded from: classes3.dex */
public interface ITimerTask {
    void cancel();

    void doTask();

    void setInterval(int i2);

    void start();
}

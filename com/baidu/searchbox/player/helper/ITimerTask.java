package com.baidu.searchbox.player.helper;
/* loaded from: classes6.dex */
public interface ITimerTask {
    void cancel();

    void doTask();

    void setInterval(int i);

    void start();
}

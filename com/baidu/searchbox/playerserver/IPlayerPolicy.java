package com.baidu.searchbox.playerserver;
/* loaded from: classes4.dex */
public interface IPlayerPolicy {
    void notify(String str);

    void register(IPlayerConfig iPlayerConfig);

    void sendRequestManually(int i);

    void start();

    void stop();

    void unregister(IPlayerConfig iPlayerConfig);
}

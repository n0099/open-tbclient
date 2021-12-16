package com.baidu.searchbox.playerserver;
/* loaded from: classes10.dex */
public interface IPlayerPolicy {
    void notify(String str);

    void register(IPlayerConfig iPlayerConfig);

    void start();

    void stop();

    void unregister(IPlayerConfig iPlayerConfig);
}

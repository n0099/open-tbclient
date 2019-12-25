package com.baidu.live.adp.framework.client.socket;
/* loaded from: classes2.dex */
public interface IPingManager {
    void Ping(String str);

    int getCmd();

    void resetPing();

    boolean sendPing(boolean z, String str);

    void stopPing();
}

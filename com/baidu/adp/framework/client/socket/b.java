package com.baidu.adp.framework.client.socket;
/* loaded from: classes.dex */
public interface b {
    void Ping(String str);

    int getCmd();

    void resetPing();

    boolean sendPing(boolean z, String str);

    void stopPing();
}

package com.baidu.android.imsdk.request;
/* loaded from: classes.dex */
public class HeartbeatMessage extends Message {
    public HeartbeatMessage() {
        setHeartbeat(true);
        setNeedReplay(true);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
    }
}

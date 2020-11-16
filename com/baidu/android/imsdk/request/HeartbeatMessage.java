package com.baidu.android.imsdk.request;
/* loaded from: classes5.dex */
public class HeartbeatMessage extends Message {
    public HeartbeatMessage() {
        setHeartbeat(true);
        setNeedReplay(true);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
    }
}

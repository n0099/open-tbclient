package com.baidu.live.adp.lib.websocket;
/* loaded from: classes6.dex */
public abstract class IWebSocketDataGenerator implements WebSocketSendListener {
    private volatile byte[] mData = null;
    private volatile boolean mHaveGenData = false;

    protected abstract byte[] genBinaryData();

    public byte[] getBinaryData() {
        synchronized (this) {
            if (!this.mHaveGenData) {
                this.mHaveGenData = true;
                this.mData = genBinaryData();
            }
        }
        return this.mData;
    }
}

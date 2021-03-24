package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes3.dex */
public abstract class InspectorNativeChannel {
    public abstract String awaitMessage();

    public String nativeAwaitMessage() {
        return awaitMessage();
    }

    public void nativeSendMessage(String str) {
        sendMessage(str);
    }

    public abstract void sendMessage(String str);
}

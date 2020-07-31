package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes10.dex */
public abstract class InspectorNativeChannel {
    public abstract String awaitMessage();

    public abstract void sendMessage(String str);

    public void nativeSendMessage(String str) {
        sendMessage(str);
    }

    public String nativeAwaitMessage() {
        return awaitMessage();
    }
}

package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes4.dex */
public abstract class InspectorNativeChannel {
    public abstract String awaitMessage();

    public abstract void sendMessage(String str);

    public String nativeAwaitMessage() {
        return awaitMessage();
    }

    public void nativeSendMessage(String str) {
        sendMessage(str);
    }
}

package com.baidu.livesdk.api.im;
/* loaded from: classes7.dex */
public interface IMConversation {
    void beginWithCompletion(IMCastSetListener iMCastSetListener);

    void endWithCompletion(IMCastSetListener iMCastSetListener);

    @Deprecated
    void quitLiveShow();

    void registerMsgReceiveListener(String str, MsgReceiveListener msgReceiveListener);

    void sendMessage(Object obj, SendMessageStatusListener sendMessageStatusListener, SendMessageListener sendMessageListener);

    void setPullInterval(int i2);

    void unregisterMsgReceiveListener(String str);
}

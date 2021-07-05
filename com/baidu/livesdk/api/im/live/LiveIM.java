package com.baidu.livesdk.api.im.live;

import com.baidu.livesdk.api.im.IMCastSetListener;
/* loaded from: classes3.dex */
public interface LiveIM {
    void enterRoom(String str, String str2, int i2, IMCastSetListener iMCastSetListener, boolean z);

    void exitRoom();

    void exitRoom(String str);

    void registerMsgReceiveListener(String str, LiveMsgReceiverListener liveMsgReceiverListener);

    void sendMessage(String str, LiveSendMessage liveSendMessage, LiveSendMessageListener liveSendMessageListener);
}

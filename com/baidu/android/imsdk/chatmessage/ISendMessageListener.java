package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes4.dex */
public interface ISendMessageListener extends IMListener {
    void onSendMessageResult(int i2, ChatMsg chatMsg);
}

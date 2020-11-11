package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes18.dex */
public interface ISendMessageStatusListener extends IMListener {
    void onSendProgress(int i, ChatMsg chatMsg);

    void onSendStatus(int i, ChatMsg chatMsg);
}

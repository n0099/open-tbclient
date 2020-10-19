package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes5.dex */
public interface IMediaSendChatMsgListener extends IMListener {
    void onMediaSendChatMsgResult(int i, ChatMsg chatMsg);
}

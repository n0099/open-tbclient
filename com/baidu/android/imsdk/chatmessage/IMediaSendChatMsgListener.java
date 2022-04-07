package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes.dex */
public interface IMediaSendChatMsgListener extends IMListener {
    void onMediaSendChatMsgResult(int i, ChatMsg chatMsg);
}

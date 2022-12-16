package com.baidu.android.imsdk.media.message;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.params.DelMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
/* loaded from: classes.dex */
public interface IChatMessageManager {
    int deleteMsg(Context context, DelMsgParam delMsgParam);

    void fetchMsg(FetchMsgParam fetchMsgParam);

    int saveChatMsg(ChatMsg chatMsg);

    void sendChatMsg(Context context, SendMsgParam sendMsgParam);
}

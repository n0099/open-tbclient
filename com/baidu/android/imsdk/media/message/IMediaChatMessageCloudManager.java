package com.baidu.android.imsdk.media.message;

import com.baidu.android.imsdk.chatmessage.request.params.DelMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
/* loaded from: classes.dex */
public interface IMediaChatMessageCloudManager {
    int deleteMsg(DelMsgParam delMsgParam);

    void fetchMsgs(FetchMsgParam fetchMsgParam);

    void sendChatMsg(SendMsgParam sendMsgParam);
}

package com.baidu.android.imsdk.mcast;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
/* loaded from: classes.dex */
public interface IChatRoomMsgReceiveListener extends IMListener {
    void onReceiveMessage(int i, long j, List<ChatMsg> list);
}

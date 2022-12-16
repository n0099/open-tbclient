package com.baidu.android.imsdk.media.listener;

import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.List;
/* loaded from: classes.dex */
public interface IChatSessionUpdateListener extends IBaseSessionUpdateListener {
    void onChatSessionUpdate(int i, List<ChatSession> list);
}

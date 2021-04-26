package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
/* loaded from: classes.dex */
public interface IMediaFetchChatMsgsListener extends IMListener {
    void onMediaFetchChatMsgsResult(int i2, String str, boolean z, List<ChatMsg> list);
}

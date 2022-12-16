package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.media.listener.IBaseSessionUpdateListener;
/* loaded from: classes.dex */
public interface IChatSessionChangeListener extends IBaseSessionUpdateListener {
    void onChatRecordDelete(int i, long j);

    void onChatSessionUpdate(ChatSession chatSession, boolean z);
}

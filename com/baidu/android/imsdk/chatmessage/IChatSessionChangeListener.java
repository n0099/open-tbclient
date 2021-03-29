package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes.dex */
public interface IChatSessionChangeListener extends IMListener {
    void onChatRecordDelete(int i, long j);

    void onChatSessionUpdate(ChatSession chatSession, boolean z);
}

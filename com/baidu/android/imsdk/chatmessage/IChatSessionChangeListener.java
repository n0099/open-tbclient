package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes4.dex */
public interface IChatSessionChangeListener extends IMListener {
    void onChatRecordDelete(int i, long j);

    void onChatSessionUpdate(ChatSession chatSession, boolean z);
}

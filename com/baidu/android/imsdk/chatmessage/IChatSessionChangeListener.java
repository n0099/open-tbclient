package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes6.dex */
public interface IChatSessionChangeListener extends IMListener {
    void onChatRecordDelete(int i2, long j);

    void onChatSessionUpdate(ChatSession chatSession, boolean z);
}

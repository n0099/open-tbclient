package com.baidu.android.imsdk.conversation;

import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.IMListener;
/* loaded from: classes3.dex */
public interface IFetchConversationListener extends IMListener {
    void onFetchConversation(int i2, String str, BIMConversation bIMConversation);
}

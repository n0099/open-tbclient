package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
/* loaded from: classes.dex */
public interface IFetchHistoryMsgListener extends IMListener {
    void onFetchMsgResult(int i, String str, boolean z, List<ChatMsg> list);
}

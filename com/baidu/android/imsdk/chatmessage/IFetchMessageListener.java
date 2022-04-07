package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IFetchMessageListener extends IMListener {
    void onFetchMessageResult(int i, ArrayList<ChatMsg> arrayList);
}

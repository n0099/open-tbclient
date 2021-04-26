package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IFetchMsgByIdListener extends IMListener {
    void onFetchMsgByIdResult(int i2, String str, String str2, int i3, long j, long j2, long j3, int i4, int i5, long j4, ArrayList<ChatMsg> arrayList);
}

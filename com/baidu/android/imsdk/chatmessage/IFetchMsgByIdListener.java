package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public interface IFetchMsgByIdListener extends IMListener {
    void onFetchMsgByIdResult(int i2, String str, String str2, int i3, long j2, long j3, long j4, int i4, int i5, long j5, ArrayList<ChatMsg> arrayList);
}

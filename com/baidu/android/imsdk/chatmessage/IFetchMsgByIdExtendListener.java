package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class IFetchMsgByIdExtendListener implements IFetchMsgByIdListener {
    @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
    public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
    }

    public abstract void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList, boolean z);
}

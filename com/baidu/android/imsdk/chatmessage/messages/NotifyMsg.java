package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
/* loaded from: classes5.dex */
public abstract class NotifyMsg extends ChatMsg {
    public NotifyMsg() {
        setCategory(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NotifyMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }
}

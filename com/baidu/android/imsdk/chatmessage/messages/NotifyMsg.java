package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class NotifyMsg extends ChatMsg {
    public NotifyMsg() {
        setCategory(2);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public NotifyMsg(Parcel parcel) {
        super(parcel);
    }
}

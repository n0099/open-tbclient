package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class PassMsg extends NormalMsg {
    public static final Parcelable.Creator<PassMsg> CREATOR = new Parcelable.Creator<PassMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.PassMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassMsg createFromParcel(Parcel parcel) {
            return new PassMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassMsg[] newArray(int i) {
            return new PassMsg[i];
        }
    };

    public PassMsg() {
        setMsgType(27);
    }

    public PassMsg(String str) {
        this();
        setMsgContent(str);
    }

    private PassMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseExt() {
        return true;
    }
}

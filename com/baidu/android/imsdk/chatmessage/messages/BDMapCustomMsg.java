package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class BDMapCustomMsg extends NormalMsg {
    public static final Parcelable.Creator<BDMapCustomMsg> CREATOR = new Parcelable.Creator<BDMapCustomMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.BDMapCustomMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDMapCustomMsg createFromParcel(Parcel parcel) {
            return new BDMapCustomMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDMapCustomMsg[] newArray(int i2) {
            return new BDMapCustomMsg[i2];
        }
    };

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[自定义消息]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public BDMapCustomMsg() {
        setMsgType(101);
    }

    public BDMapCustomMsg(Parcel parcel) {
        super(parcel);
    }
}

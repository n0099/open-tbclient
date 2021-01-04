package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
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
        public BDMapCustomMsg[] newArray(int i) {
            return new BDMapCustomMsg[i];
        }
    };

    public BDMapCustomMsg() {
        setMsgType(101);
    }

    private BDMapCustomMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[自定义消息]";
    }
}

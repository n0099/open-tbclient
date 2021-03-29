package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class UnSupportedMsg extends NormalMsg {
    public static final Parcelable.Creator<UnSupportedMsg> CREATOR = new Parcelable.Creator<UnSupportedMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnSupportedMsg createFromParcel(Parcel parcel) {
            return new UnSupportedMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnSupportedMsg[] newArray(int i) {
            return new UnSupportedMsg[i];
        }
    };
    public static String unSupportedMsgDesc = "[不支持的消息类型，请升级应用后查看]";

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public int getMsgType() {
        return 10000;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return unSupportedMsgDesc;
    }

    public String getText() {
        return unSupportedMsgDesc;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        return true;
    }

    public UnSupportedMsg() {
        setMsgType(10000);
    }

    public UnSupportedMsg(Parcel parcel) {
        super(parcel);
    }
}

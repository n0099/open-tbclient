package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupBroadcastMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupBroadcastMsg> CREATOR = new Parcelable.Creator<GroupBroadcastMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupBroadcastMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupBroadcastMsg createFromParcel(Parcel parcel) {
            return new GroupBroadcastMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupBroadcastMsg[] newArray(int i) {
            return new GroupBroadcastMsg[i];
        }
    };
    public String content;

    public GroupBroadcastMsg() {
        setMsgType(1006);
    }

    public String getBroadcastText() {
        return this.content;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            this.content = new JSONObject(getMsgContent()).optString("text");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.content);
    }

    public GroupBroadcastMsg(Parcel parcel) {
        super(parcel);
        this.content = parcel.readString();
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GroupMemberNameChangeMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberNameChangeMsg> CREATOR = new Parcelable.Creator<GroupMemberNameChangeMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberNameChangeMsg createFromParcel(Parcel parcel) {
            return new GroupMemberNameChangeMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberNameChangeMsg[] newArray(int i) {
            return new GroupMemberNameChangeMsg[i];
        }
    };
    private String nickname;
    private long wasmodifed;
    private long whodo;

    public GroupMemberNameChangeMsg() {
        setMsgType(1012);
    }

    public GroupMemberNameChangeMsg(Parcel parcel) {
        super(parcel);
        this.whodo = parcel.readLong();
        this.wasmodifed = parcel.readLong();
        this.nickname = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.whodo);
        parcel.writeLong(this.wasmodifed);
        parcel.writeString(this.nickname);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.whodo = jSONObject.optLong("operator");
            this.wasmodifed = jSONObject.optLong("member");
            this.nickname = jSONObject.optString("name");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public String getNickname() {
        return this.nickname;
    }

    public String memberChangedid() {
        return String.valueOf(this.wasmodifed);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }
}

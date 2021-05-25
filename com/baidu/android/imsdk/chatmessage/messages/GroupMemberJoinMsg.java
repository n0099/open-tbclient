package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupMemberJoinMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberJoinMsg> CREATOR = new Parcelable.Creator<GroupMemberJoinMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberJoinMsg createFromParcel(Parcel parcel) {
            return new GroupMemberJoinMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberJoinMsg[] newArray(int i2) {
            return new GroupMemberJoinMsg[i2];
        }
    };
    public int groupnum;
    public long mMemberVersion;
    public String memberbuid;

    public GroupMemberJoinMsg() {
        this.mMemberVersion = 0L;
        setMsgType(1002);
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public String getMemberBuid() {
        return this.memberbuid;
    }

    public long getMemberVersion() {
        return this.mMemberVersion;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.groupnum = jSONObject.optInt("group_num");
            this.memberbuid = String.valueOf(jSONObject.optLong("member"));
            this.mMemberVersion = jSONObject.optLong("member_version");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.memberbuid);
        parcel.writeInt(this.groupnum);
        parcel.writeLong(this.mMemberVersion);
    }

    public GroupMemberJoinMsg(Parcel parcel) {
        super(parcel);
        this.mMemberVersion = 0L;
        this.memberbuid = parcel.readString();
        this.groupnum = parcel.readInt();
        this.mMemberVersion = parcel.readLong();
    }
}

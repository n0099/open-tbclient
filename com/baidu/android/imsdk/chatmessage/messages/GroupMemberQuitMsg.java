package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupMemberQuitMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberQuitMsg> CREATOR = new Parcelable.Creator<GroupMemberQuitMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberQuitMsg createFromParcel(Parcel parcel) {
            return new GroupMemberQuitMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberQuitMsg[] newArray(int i2) {
            return new GroupMemberQuitMsg[i2];
        }
    };
    public int groupnum;
    public long mMemberVersion;
    public String mNewMaster;
    public String mQuitMember;

    public GroupMemberQuitMsg() {
        setMsgType(1003);
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public long getMemberVersion() {
        return this.mMemberVersion;
    }

    public String getNewMaster() {
        return this.mNewMaster;
    }

    public String getQuitBuid() {
        return this.mQuitMember;
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
            long optLong = jSONObject.optLong("new_owner");
            this.mQuitMember = String.valueOf(jSONObject.optLong("operator"));
            this.mNewMaster = String.valueOf(optLong);
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
        parcel.writeString(this.mQuitMember);
        parcel.writeString(this.mNewMaster);
        parcel.writeLong(this.groupnum);
        parcel.writeLong(this.mMemberVersion);
    }

    public GroupMemberQuitMsg(Parcel parcel) {
        super(parcel);
        this.mQuitMember = parcel.readString();
        this.mNewMaster = parcel.readString();
        this.groupnum = parcel.readInt();
        this.mMemberVersion = parcel.readLong();
    }
}

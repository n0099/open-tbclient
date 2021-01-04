package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        public GroupMemberJoinMsg[] newArray(int i) {
            return new GroupMemberJoinMsg[i];
        }
    };
    private int groupnum;
    private String memberbuid;

    public GroupMemberJoinMsg() {
        setMsgType(1002);
    }

    public GroupMemberJoinMsg(Parcel parcel) {
        super(parcel);
        this.memberbuid = parcel.readString();
        this.groupnum = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.memberbuid);
        parcel.writeInt(this.groupnum);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.groupnum = jSONObject.optInt("group_num");
            this.memberbuid = String.valueOf(jSONObject.optLong("member"));
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public String getMemberBuid() {
        return this.memberbuid;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }
}

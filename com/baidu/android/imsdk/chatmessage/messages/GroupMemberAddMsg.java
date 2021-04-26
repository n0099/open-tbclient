package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupMemberAddMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberAddMsg> CREATOR = new Parcelable.Creator<GroupMemberAddMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupMemberAddMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberAddMsg createFromParcel(Parcel parcel) {
            return new GroupMemberAddMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberAddMsg[] newArray(int i2) {
            return new GroupMemberAddMsg[i2];
        }
    };
    public int groupnum;
    public ArrayList<String> members;
    public String operator;

    public GroupMemberAddMsg() {
        this.members = new ArrayList<>();
        setMsgType(1001);
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public ArrayList<String> getMemberBuids() {
        return this.members;
    }

    public String getOperator() {
        return this.operator;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.operator = String.valueOf(jSONObject.optLong("operator"));
            this.groupnum = jSONObject.optInt("group_num");
            JSONArray jSONArray = jSONObject.getJSONArray("member");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.members.add(String.valueOf(jSONArray.optLong(i2)));
            }
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.operator);
        parcel.writeInt(this.groupnum);
        parcel.writeList(this.members);
    }

    public GroupMemberAddMsg(Parcel parcel) {
        super(parcel);
        this.members = new ArrayList<>();
        this.operator = parcel.readString();
        this.groupnum = parcel.readInt();
        parcel.readList(this.members, String.class.getClassLoader());
    }
}

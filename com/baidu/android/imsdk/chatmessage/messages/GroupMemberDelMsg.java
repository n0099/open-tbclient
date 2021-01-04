package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GroupMemberDelMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupMemberDelMsg> CREATOR = new Parcelable.Creator<GroupMemberDelMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberDelMsg createFromParcel(Parcel parcel) {
            return new GroupMemberDelMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMemberDelMsg[] newArray(int i) {
            return new GroupMemberDelMsg[i];
        }
    };
    private int groupnum;
    private ArrayList<String> members;
    private String operator;

    public GroupMemberDelMsg() {
        this.members = new ArrayList<>();
        setMsgType(1004);
    }

    public GroupMemberDelMsg(Parcel parcel) {
        super(parcel);
        this.members = new ArrayList<>();
        this.operator = parcel.readString();
        this.groupnum = parcel.readInt();
        parcel.readList(this.members, String.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.operator);
        parcel.writeInt(this.groupnum);
        parcel.writeList(this.members);
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.operator = String.valueOf(jSONObject.optLong("operator"));
            this.groupnum = jSONObject.optInt("group_num");
            JSONArray jSONArray = jSONObject.getJSONArray("member");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.members.add(String.valueOf(jSONArray.optLong(i)));
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public ArrayList<String> getMemberBuids() {
        return this.members;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }
}

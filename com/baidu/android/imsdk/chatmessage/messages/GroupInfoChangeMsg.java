package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoChangeMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupInfoChangeMsg> CREATOR = new Parcelable.Creator<GroupInfoChangeMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfoChangeMsg createFromParcel(Parcel parcel) {
            return new GroupInfoChangeMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfoChangeMsg[] newArray(int i2) {
            return new GroupInfoChangeMsg[i2];
        }
    };
    public String groupname;
    public String member;
    public String noticeDetail;

    public GroupInfoChangeMsg() {
        setMsgType(1005);
    }

    public String getChangeBuid() {
        return this.member;
    }

    public String getGroupname() {
        return this.groupname;
    }

    public String getNoticeDetail() {
        return this.noticeDetail;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.member = String.valueOf(jSONObject.optLong("operator"));
            this.groupname = jSONObject.optString("group_name");
            this.noticeDetail = jSONObject.optString("notice_detail");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.member);
        parcel.writeString(this.groupname);
        parcel.writeString(this.noticeDetail);
    }

    public GroupInfoChangeMsg(Parcel parcel) {
        super(parcel);
        this.member = parcel.readString();
        this.groupname = parcel.readString();
        this.noticeDetail = parcel.readString();
    }
}

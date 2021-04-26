package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupStarAlertMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupStarAlertMsg> CREATOR = new Parcelable.Creator<GroupStarAlertMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupStarAlertMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarAlertMsg createFromParcel(Parcel parcel) {
            return new GroupStarAlertMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarAlertMsg[] newArray(int i2) {
            return new GroupStarAlertMsg[i2];
        }
    };
    public long groupid;

    public GroupStarAlertMsg() {
        setMsgType(2001);
    }

    public long getGroupid() {
        return this.groupid;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            this.groupid = new JSONObject(getMsgContent()).optLong("group_id");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.groupid);
    }

    public GroupStarAlertMsg(Parcel parcel) {
        super(parcel);
        this.groupid = parcel.readLong();
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AddFriendMsg extends NotifyMsg {
    public static final Parcelable.Creator<AddFriendMsg> CREATOR = new Parcelable.Creator<AddFriendMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AddFriendMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddFriendMsg createFromParcel(Parcel parcel) {
            return new AddFriendMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddFriendMsg[] newArray(int i) {
            return new AddFriendMsg[i];
        }
    };
    public static final String TAG = "AddFriendMsg";
    public String description;
    public long from;

    public AddFriendMsg() {
        setNotifyCmd(0);
    }

    public String getDescription() {
        return this.description;
    }

    public long getFrom() {
        return this.from;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.from = jSONObject.getLong("from");
            this.description = jSONObject.getString("description");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parseJsonString", e2);
            return false;
        } catch (Exception e3) {
            LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e3);
            return false;
        }
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFrom(long j) {
        this.from = j;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.from);
        parcel.writeString(this.description);
    }

    public AddFriendMsg(Parcel parcel) {
        super(parcel);
        this.from = parcel.readLong();
        this.description = parcel.readString();
    }
}

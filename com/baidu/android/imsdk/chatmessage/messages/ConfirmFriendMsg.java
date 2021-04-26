package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ConfirmFriendMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<ConfirmFriendMsg> CREATOR = new Parcelable.Creator<ConfirmFriendMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ConfirmFriendMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfirmFriendMsg createFromParcel(Parcel parcel) {
            return new ConfirmFriendMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfirmFriendMsg[] newArray(int i2) {
            return new ConfirmFriendMsg[i2];
        }
    };
    public static final String TAG = "ConfirmFriendMsg";
    public long fromUser;

    public ConfirmFriendMsg() {
        setNotifyCmd(1);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getFromUser() {
        return this.fromUser;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            setFromUser(new JSONObject(getJsonContent()).getLong("fromUser"));
            return true;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public void setFromUser(long j) {
        this.fromUser = j;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.fromUser);
    }

    public ConfirmFriendMsg(Parcel parcel) {
        super(parcel);
        this.fromUser = parcel.readLong();
    }
}

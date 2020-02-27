package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        public ConfirmFriendMsg[] newArray(int i) {
            return new ConfirmFriendMsg[i];
        }
    };
    private static final String TAG = "ConfirmFriendMsg";
    private long fromUser;

    public ConfirmFriendMsg() {
        setNotifyCmd(1);
    }

    public ConfirmFriendMsg(Parcel parcel) {
        super(parcel);
        this.fromUser = parcel.readLong();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getFromUser() {
        return this.fromUser;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public void setFromUser(long j) {
        this.fromUser = j;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.fromUser);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            setFromUser(new JSONObject(getJsonContent()).getLong("fromUser"));
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parseJsonString", e);
            return false;
        }
    }
}

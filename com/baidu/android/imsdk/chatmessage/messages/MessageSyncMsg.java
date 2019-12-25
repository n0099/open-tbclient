package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MessageSyncMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<MessageSyncMsg> CREATOR = new Parcelable.Creator<MessageSyncMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.MessageSyncMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSyncMsg createFromParcel(Parcel parcel) {
            return new MessageSyncMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSyncMsg[] newArray(int i) {
            return new MessageSyncMsg[i];
        }
    };
    private long msgid;
    private int status;
    private int updateTime;

    public MessageSyncMsg() {
        this.status = -1;
        this.updateTime = -1;
        this.msgid = -1L;
        setNotifyCmd(21);
    }

    public MessageSyncMsg(Parcel parcel) {
        super(parcel);
        this.status = -1;
        this.updateTime = -1;
        this.msgid = -1L;
        this.status = parcel.readInt();
        this.updateTime = parcel.readInt();
        this.msgid = parcel.readLong();
    }

    public long getChangedMsgid() {
        return this.msgid;
    }

    public int getChangedStatus() {
        return this.status;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.status);
        parcel.writeInt(this.updateTime);
        parcel.writeLong(this.msgid);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.status = jSONObject.getInt("status");
            this.updateTime = jSONObject.getInt("update_time");
            this.msgid = jSONObject.getLong("msgid");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "JSONException", e);
            return false;
        }
    }
}

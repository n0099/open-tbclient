package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class DialogSyncMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<DialogSyncMsg> CREATOR = new Parcelable.Creator<DialogSyncMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialogSyncMsg createFromParcel(Parcel parcel) {
            return new DialogSyncMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialogSyncMsg[] newArray(int i) {
            return new DialogSyncMsg[i];
        }
    };
    private int category;
    private long fromUid;
    private long operatedMaxMsgid;
    private long paid;
    private int status;
    private int updateTime;

    public DialogSyncMsg() {
        this.status = -1;
        this.updateTime = -1;
        this.category = -1;
        this.fromUid = -1L;
        this.operatedMaxMsgid = -1L;
        this.paid = -1L;
        setNotifyCmd(22);
    }

    public DialogSyncMsg(Parcel parcel) {
        super(parcel);
        this.status = -1;
        this.updateTime = -1;
        this.category = -1;
        this.fromUid = -1L;
        this.operatedMaxMsgid = -1L;
        this.paid = -1L;
        this.status = parcel.readInt();
        this.updateTime = parcel.readInt();
        this.category = parcel.readInt();
        this.fromUid = parcel.readLong();
        this.operatedMaxMsgid = parcel.readLong();
        this.paid = parcel.readLong();
    }

    public long getOperatedMaxMsgid() {
        return this.operatedMaxMsgid;
    }

    public int getSyncStatus() {
        return this.status;
    }

    public int getSyncCategory() {
        return this.category;
    }

    public long getSyncFromUid() {
        return this.fromUid;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public long getPaid() {
        return this.paid;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.status);
        parcel.writeInt(this.updateTime);
        parcel.writeInt(this.category);
        parcel.writeLong(this.fromUid);
        parcel.writeLong(this.operatedMaxMsgid);
        parcel.writeLong(this.paid);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.status = jSONObject.getInt("status");
            this.updateTime = jSONObject.getInt("update_time");
            this.category = jSONObject.getInt("category");
            this.fromUid = jSONObject.getLong("from_uid");
            this.operatedMaxMsgid = jSONObject.optLong("msgid", -1L);
            this.paid = jSONObject.optLong("pa_uid", -1L);
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }
}

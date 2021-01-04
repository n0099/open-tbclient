package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserSettingPaCmdMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<UserSettingPaCmdMsg> CREATOR = new Parcelable.Creator<UserSettingPaCmdMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.UserSettingPaCmdMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSettingPaCmdMsg createFromParcel(Parcel parcel) {
            return new UserSettingPaCmdMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSettingPaCmdMsg[] newArray(int i) {
            return new UserSettingPaCmdMsg[i];
        }
    };
    private long mPaId;
    private int status;
    private long updateTime;

    public UserSettingPaCmdMsg() {
        this.mPaId = -1L;
        this.status = -1;
        this.updateTime = -1L;
        setNotifyCmd(23);
    }

    private UserSettingPaCmdMsg(Parcel parcel) {
        super(parcel);
        this.mPaId = -1L;
        this.status = -1;
        this.updateTime = -1L;
        this.mPaId = parcel.readLong();
        this.status = parcel.readInt();
        this.updateTime = parcel.readInt();
    }

    public long getPaId() {
        return this.mPaId;
    }

    public int getSyncStatus() {
        return this.status;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.mPaId);
        parcel.writeInt(this.status);
        parcel.writeLong(this.updateTime);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.mPaId = jSONObject.getLong("pa_uid");
            this.status = jSONObject.getInt("status");
            this.updateTime = jSONObject.getInt("update_time");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }
}

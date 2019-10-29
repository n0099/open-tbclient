package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DeviceLoginMsg extends FlashMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<DeviceLoginMsg> CREATOR = new Parcelable.Creator<DeviceLoginMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DeviceLoginMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceLoginMsg createFromParcel(Parcel parcel) {
            return new DeviceLoginMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceLoginMsg[] newArray(int i) {
            return new DeviceLoginMsg[i];
        }
    };
    private String deviceType;
    private long time;

    public DeviceLoginMsg() {
        setNotifyCmd(50);
    }

    public DeviceLoginMsg(Parcel parcel) {
        super(parcel);
        this.time = parcel.readLong();
        this.deviceType = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.time);
        parcel.writeString(this.deviceType);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.time = jSONObject.optLong("time");
            this.deviceType = jSONObject.optString("device_type");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public long getTime() {
        return this.time;
    }

    public String getDeviceType() {
        return this.deviceType;
    }
}

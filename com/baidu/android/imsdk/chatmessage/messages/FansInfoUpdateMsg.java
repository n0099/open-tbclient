package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FansInfoUpdateMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<FansInfoUpdateMsg> CREATOR = new Parcelable.Creator<FansInfoUpdateMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansInfoUpdateMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansInfoUpdateMsg createFromParcel(Parcel parcel) {
            return new FansInfoUpdateMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansInfoUpdateMsg[] newArray(int i2) {
            return new FansInfoUpdateMsg[i2];
        }
    };
    public long mInfoVersion;
    public long mOperator;

    public FansInfoUpdateMsg() {
        setMsgType(1014);
    }

    public long getInfoVersion() {
        return this.mInfoVersion;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mOperator = jSONObject.optLong("operator");
            this.mInfoVersion = jSONObject.optLong("group_version");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.mOperator);
        parcel.writeLong(this.mInfoVersion);
    }

    public FansInfoUpdateMsg(Parcel parcel) {
        super(parcel);
        this.mOperator = parcel.readLong();
        this.mInfoVersion = parcel.readLong();
    }
}

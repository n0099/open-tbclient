package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupDisbandMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupDisbandMsg> CREATOR = new Parcelable.Creator<GroupDisbandMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupDisbandMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupDisbandMsg createFromParcel(Parcel parcel) {
            return new GroupDisbandMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupDisbandMsg[] newArray(int i2) {
            return new GroupDisbandMsg[i2];
        }
    };
    public String mDesc;
    public String mOperator;
    public int mReason;

    public GroupDisbandMsg() {
        setMsgType(1013);
    }

    public String getOperator() {
        return this.mOperator;
    }

    public int getReason() {
        return this.mReason;
    }

    public String getReasonDesc() {
        return this.mDesc;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mOperator = String.valueOf(jSONObject.optLong("operator"));
            this.mReason = jSONObject.optInt("reason");
            this.mDesc = jSONObject.optString("reason_desc");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mOperator);
        parcel.writeInt(this.mReason);
        parcel.writeString(this.mDesc);
    }

    public GroupDisbandMsg(Parcel parcel) {
        super(parcel);
        this.mOperator = parcel.readString();
        this.mReason = parcel.readInt();
        this.mDesc = parcel.readString();
    }
}

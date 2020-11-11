package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class RedNotifyMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<RedNotifyMsg> CREATOR = new Parcelable.Creator<RedNotifyMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.RedNotifyMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedNotifyMsg createFromParcel(Parcel parcel) {
            return new RedNotifyMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedNotifyMsg[] newArray(int i) {
            return new RedNotifyMsg[i];
        }
    };
    private long mGrabTime;
    private int mIsLast;
    private String mLogoUrl;
    private String mOrderId;
    private String mReceiveName;
    private String mReceveId;
    private String mSendId;
    private String mSendName;

    public RedNotifyMsg() {
        setMsgType(2010);
    }

    public RedNotifyMsg(Parcel parcel) {
        super(parcel);
        this.mOrderId = parcel.readString();
        this.mSendId = parcel.readString();
        this.mSendName = parcel.readString();
        this.mReceveId = parcel.readString();
        this.mReceiveName = parcel.readString();
        this.mIsLast = parcel.readInt();
        this.mGrabTime = parcel.readLong();
        this.mLogoUrl = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mOrderId);
        parcel.writeString(this.mSendId);
        parcel.writeString(this.mSendName);
        parcel.writeString(this.mReceveId);
        parcel.writeString(this.mReceiveName);
        parcel.writeInt(this.mIsLast);
        parcel.writeLong(this.mGrabTime);
        parcel.writeString(this.mLogoUrl);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        LogUtils.d("", "FDEBUG parseJsonString");
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mOrderId = jSONObject.optString("redpack_id");
            this.mSendId = jSONObject.optString("redpack_send_uid");
            this.mSendName = jSONObject.optString("redpack_send_name");
            this.mReceveId = jSONObject.optString("redpack_recv_uid");
            this.mReceiveName = jSONObject.optString("redpack_recv_name");
            this.mIsLast = jSONObject.optInt("last");
            this.mGrabTime = jSONObject.optLong("redpack_get_ts");
            this.mLogoUrl = jSONObject.optString("logo");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getSendId() {
        return this.mSendId;
    }

    public String getSendName() {
        return this.mSendName;
    }

    public String getReceveId() {
        return this.mReceveId;
    }

    public String getRecvName() {
        return this.mReceiveName;
    }

    public int isLast() {
        return this.mIsLast;
    }

    public long getGrabTime() {
        return this.mGrabTime;
    }

    public String getLogo() {
        return this.mLogoUrl;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        String uid = AccountManager.getUid(IMSettings.getsContext());
        LogUtils.d("", "FDEBUG" + uid + " " + this.mReceveId + " " + this.mSendId);
        if (this.mReceveId.equals(uid)) {
            if (this.mSendId.equals(uid)) {
                return "你领取了自己的红包";
            }
            return "你领取了" + this.mSendName + "的红包";
        } else if (this.mSendId.equals(uid)) {
            if (this.mIsLast == 1 && getCategory() == 1) {
                return this.mReceiveName + "领取了你的红包，你的红包已被领完";
            }
            return this.mReceiveName + "领取了你的红包";
        } else if (this.mSendId.equals(this.mReceveId)) {
            return this.mReceiveName + "领取了自己的红包";
        } else {
            return this.mReceiveName + "领取了" + this.mSendName + "的红包";
        }
    }
}

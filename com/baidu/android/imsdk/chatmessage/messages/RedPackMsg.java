package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RedPackMsg extends NormalMsg {
    public static final Parcelable.Creator<RedPackMsg> CREATOR = new Parcelable.Creator<RedPackMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.RedPackMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPackMsg createFromParcel(Parcel parcel) {
            return new RedPackMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPackMsg[] newArray(int i) {
            return new RedPackMsg[i];
        }
    };
    public String mBusiLogo;
    public String mBusiName;
    public long mCreateTs;
    public String mRedPacket;
    public String mRedPacketId;
    public String mSendName;
    public String mSendUid;
    public int mType;
    public String mWishText;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBusiLogo() {
        return this.mBusiLogo;
    }

    public String getBusiName() {
        return this.mBusiName;
    }

    public long getCreateTs() {
        return this.mCreateTs;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        LogUtils.d("", "FDEBUG RedPackMsg getRecommendDescription" + this.mWishText);
        if (TextUtils.isEmpty(this.mWishText)) {
            return "[百度红包]恭喜发财,大吉大利！";
        }
        return "[百度红包]" + this.mWishText;
    }

    public String getRedPacketId() {
        return this.mRedPacketId;
    }

    public String getSendName() {
        return this.mSendName;
    }

    public String getSendUid() {
        return this.mSendUid;
    }

    public int getType() {
        return this.mType;
    }

    public String getWish() {
        return this.mWishText;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            LogUtils.d("", "FDEBUG RedPackMsg" + getJsonContent());
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.mRedPacketId = jSONObject.getString("redpack_id");
            this.mType = jSONObject.optInt("redpack_type");
            this.mWishText = jSONObject.optString("wish");
            LogUtils.d("", "FDEBUG RedPackMsg" + this.mWishText);
            this.mCreateTs = jSONObject.optLong("redpack_ts");
            this.mSendName = jSONObject.optString("redpack_send_name");
            this.mSendUid = jSONObject.optString("redpack_send_uid");
            this.mBusiName = jSONObject.optString("busi_name");
            this.mBusiLogo = jSONObject.optString("busi_logo");
            return true;
        } catch (JSONException e2) {
            LogUtils.e("CouponMsg", "parseJsonString JSONException", e2);
            return false;
        }
    }

    public boolean setJsonContent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            jSONObject.put("redpack_type", 0);
            jSONObject.put("redpack_id", 0);
            jSONObject.put("redpack_send_uid", str);
            jSONObject.put("redpack_send_name", str2);
            jSONObject.put("wish", "good luck'");
            jSONObject.put("redpack_ts", currentTimeMillis);
            return setMsgContent(jSONObject.toString());
        } catch (Exception unused) {
            LogUtils.e("TempletMsg", "content error!");
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mRedPacketId);
        parcel.writeString(this.mSendUid);
        parcel.writeString(this.mSendName);
        parcel.writeString(this.mBusiLogo);
        parcel.writeString(this.mBusiName);
        parcel.writeString(this.mWishText);
        parcel.writeLong(this.mCreateTs);
    }

    public RedPackMsg() {
        setMsgType(16);
    }

    public RedPackMsg(Parcel parcel) {
        super(parcel);
        this.mType = parcel.readInt();
        this.mRedPacketId = parcel.readString();
        this.mSendUid = parcel.readString();
        this.mSendName = parcel.readString();
        this.mBusiLogo = parcel.readString();
        this.mBusiName = parcel.readString();
        this.mWishText = parcel.readString();
        this.mCreateTs = parcel.readLong();
    }
}

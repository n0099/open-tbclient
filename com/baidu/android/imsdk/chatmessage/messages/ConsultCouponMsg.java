package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ConsultCouponMsg extends NormalMsg {
    public static final Parcelable.Creator<ConsultCouponMsg> CREATOR = new Parcelable.Creator<ConsultCouponMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ConsultCouponMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConsultCouponMsg createFromParcel(Parcel parcel) {
            return new ConsultCouponMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConsultCouponMsg[] newArray(int i2) {
            return new ConsultCouponMsg[i2];
        }
    };
    public int mCouponStatus;
    public String mDesc;
    public String mImg;
    public String mTitle;
    public String mUrl;

    public ConsultCouponMsg() {
        setMsgType(26);
    }

    public int getCouponStatus() {
        return this.mCouponStatus;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getImg() {
        return this.mImg;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mDesc;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mImg = jSONObject.optString("img");
            this.mTitle = jSONObject.optString("title");
            this.mDesc = jSONObject.optString("description");
            this.mUrl = jSONObject.optString("url");
            this.mCouponStatus = jSONObject.optInt("status");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public void setCouponStatus(int i2) {
        this.mCouponStatus = i2;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setImg(String str) {
        this.mImg = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public boolean updateStatus(Context context, int i2) {
        this.mCouponStatus = i2;
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            if (jSONObject.has("status")) {
                jSONObject.put("status", i2);
            }
            setMsgContentFromServer(jSONObject.toString());
            return ChatMsgManager.updateChatMsg(context, this);
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "updateStatus", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mImg);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeString(this.mUrl);
        parcel.writeInt(this.mCouponStatus);
    }

    public ConsultCouponMsg(Parcel parcel) {
        super(parcel);
        this.mImg = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mUrl = parcel.readString();
        this.mCouponStatus = parcel.readInt();
    }
}

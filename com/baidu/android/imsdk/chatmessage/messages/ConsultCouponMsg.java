package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        public ConsultCouponMsg[] newArray(int i) {
            return new ConsultCouponMsg[i];
        }
    };
    private int mCouponStatus;
    private String mDesc;
    private String mImg;
    private String mTitle;
    private String mUrl;

    public ConsultCouponMsg() {
        setMsgType(26);
    }

    public ConsultCouponMsg(Parcel parcel) {
        super(parcel);
        this.mImg = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mUrl = parcel.readString();
        this.mCouponStatus = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mImg);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeString(this.mUrl);
        parcel.writeInt(this.mCouponStatus);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mImg = jSONObject.optString("img");
            this.mTitle = jSONObject.optString("title");
            this.mDesc = jSONObject.optString("description");
            this.mUrl = jSONObject.optString("url");
            this.mCouponStatus = jSONObject.optInt("status");
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mDesc;
    }

    public boolean updateStatus(Context context, int i) {
        this.mCouponStatus = i;
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            if (jSONObject.has("status")) {
                jSONObject.put("status", i);
            }
            setMsgContentFromServer(jSONObject.toString());
            return ChatMsgManager.updateChatMsg(context, this);
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "updateStatus", e);
            return false;
        }
    }

    public String getImg() {
        return this.mImg;
    }

    public void setImg(String str) {
        this.mImg = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public int getCouponStatus() {
        return this.mCouponStatus;
    }

    public void setCouponStatus(int i) {
        this.mCouponStatus = i;
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CouponMsg extends NormalMsg {
    public static final Parcelable.Creator<CouponMsg> CREATOR = new Parcelable.Creator<CouponMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.CouponMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponMsg createFromParcel(Parcel parcel) {
            return new CouponMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponMsg[] newArray(int i) {
            return new CouponMsg[i];
        }
    };
    private long mAppid;
    private String mBgcolor;
    private String mDesc;
    private String mDiscount;
    private int mDiscountType;
    private String mLogo;
    private String mName;
    private String mStatus;
    private String mType;
    private String mUrl;

    public String getType() {
        return this.mType;
    }

    public void setTye(String str) {
        this.mType = str;
    }

    public long getAppid() {
        return this.mAppid;
    }

    public void setAppid(long j) {
        this.mAppid = j;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public void setLogo(String str) {
        this.mLogo = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getDiscountType() {
        return this.mDiscountType;
    }

    public void setDiscountType(int i) {
        this.mDiscountType = i;
    }

    public String getDesciption() {
        return this.mDesc;
    }

    public void setDescripton(String str) {
        this.mDesc = str;
    }

    public String getDiscount() {
        return this.mDiscount;
    }

    public void setDiscount(String str) {
        this.mDiscount = str;
    }

    public String getBgcolor() {
        return this.mBgcolor;
    }

    public void setBgcolor(String str) {
        this.mBgcolor = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getUseStatus() {
        return this.mStatus;
    }

    public void setUseStatus(String str) {
        this.mStatus = str;
    }

    public CouponMsg() {
        setMsgType(13);
    }

    private CouponMsg(Parcel parcel) {
        super(parcel);
        this.mType = parcel.readString();
        this.mAppid = parcel.readLong();
        this.mLogo = parcel.readString();
        this.mName = parcel.readString();
        this.mDesc = parcel.readString();
        this.mDiscountType = parcel.readInt();
        this.mDiscount = parcel.readString();
        this.mBgcolor = parcel.readString();
        this.mUrl = parcel.readString();
        this.mStatus = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mType);
        parcel.writeLong(this.mAppid);
        parcel.writeString(this.mLogo);
        parcel.writeString(this.mName);
        parcel.writeString(this.mDesc);
        parcel.writeInt(this.mDiscountType);
        parcel.writeString(this.mDiscount);
        parcel.writeString(this.mBgcolor);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mStatus);
    }

    public boolean setJsonContent(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "zhida");
            jSONObject.put("logo", str);
            jSONObject.put("name", str2);
            jSONObject.put("desc", str3);
            jSONObject.put("discount_type", i);
            jSONObject.put("discount", str4);
            jSONObject.put("bgcolor", str5);
            jSONObject.put("url", str6);
            jSONObject.put("status", str7);
            return setMsgContent(jSONObject.toString());
        } catch (Exception e) {
            LogUtils.e("TempletMsg", "content error!");
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.mType = jSONObject.getString("type");
            this.mAppid = jSONObject.optLong("appid", 0L);
            this.mLogo = jSONObject.optString("logo", "");
            this.mName = jSONObject.optString("name", "");
            this.mDesc = jSONObject.optString("desc", "");
            this.mDiscountType = jSONObject.optInt("discount_type");
            this.mDiscount = jSONObject.optString("discount", "");
            this.mBgcolor = jSONObject.optString("bgcolor", BaseBrowseView.ROOT_VIEW_COLOR);
            this.mUrl = jSONObject.optString("url", "");
            this.mStatus = jSONObject.optString("status");
            return true;
        } catch (JSONException e) {
            LogUtils.e("CouponMsg", "parseJsonString JSONException", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[优惠券]";
    }
}

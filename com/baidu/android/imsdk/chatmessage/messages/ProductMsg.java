package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ProductMsg extends NormalMsg {
    public static final Parcelable.Creator<ProductMsg> CREATOR = new Parcelable.Creator<ProductMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ProductMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductMsg createFromParcel(Parcel parcel) {
            return new ProductMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductMsg[] newArray(int i2) {
            return new ProductMsg[i2];
        }
    };
    public String mDesc;
    public String[] mDiscountInfo;
    public String mImg;
    public String mPrice;
    public String mProductId;
    public String mProductUrl;
    public String mTitle;

    public ProductMsg() {
        setMsgType(25);
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String[] getDiscountInfo() {
        return this.mDiscountInfo;
    }

    public String getImg() {
        return this.mImg;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getProductUrl() {
        return this.mProductUrl;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mDesc;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mImg = jSONObject.optString("img");
            this.mTitle = jSONObject.optString("title");
            this.mDesc = jSONObject.optString("description");
            JSONArray optJSONArray = jSONObject.optJSONArray("discount_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.mDiscountInfo = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.mDiscountInfo[i2] = (String) optJSONArray.get(i2);
                }
            }
            this.mPrice = jSONObject.optString("price");
            this.mProductUrl = jSONObject.optString("product_url");
            this.mProductId = jSONObject.optString("product_id");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setDiscountInfo(String[] strArr) {
        this.mDiscountInfo = strArr;
    }

    public void setImg(String str) {
        this.mImg = str;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setProductUrl(String str) {
        this.mProductUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mImg);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeStringArray(this.mDiscountInfo);
        parcel.writeString(this.mPrice);
        parcel.writeString(this.mProductUrl);
        parcel.writeString(this.mProductId);
    }

    public ProductMsg(Parcel parcel) {
        super(parcel);
        this.mImg = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mDiscountInfo = parcel.createStringArray();
        this.mPrice = parcel.readString();
        this.mProductUrl = parcel.readString();
        this.mProductId = parcel.readString();
    }
}

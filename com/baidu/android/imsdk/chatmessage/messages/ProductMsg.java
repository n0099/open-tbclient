package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        public ProductMsg[] newArray(int i) {
            return new ProductMsg[i];
        }
    };
    private String mDesc;
    private String[] mDiscountInfo;
    private String mImg;
    private String mPrice;
    private String mProductId;
    private String mProductUrl;
    private String mTitle;

    public ProductMsg() {
        setMsgType(25);
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mImg);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeStringArray(this.mDiscountInfo);
        parcel.writeString(this.mPrice);
        parcel.writeString(this.mProductUrl);
        parcel.writeString(this.mProductId);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.mImg = jSONObject.optString("img");
            this.mTitle = jSONObject.optString("title");
            this.mDesc = jSONObject.optString("description");
            JSONArray optJSONArray = jSONObject.optJSONArray("discount_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.mDiscountInfo = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.mDiscountInfo[i] = (String) optJSONArray.get(i);
                }
            }
            this.mPrice = jSONObject.optString("price");
            this.mProductUrl = jSONObject.optString("product_url");
            this.mProductId = jSONObject.optString("product_id");
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

    public String[] getDiscountInfo() {
        return this.mDiscountInfo;
    }

    public void setDiscountInfo(String[] strArr) {
        this.mDiscountInfo = strArr;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getProductUrl() {
        return this.mProductUrl;
    }

    public void setProductUrl(String str) {
        this.mProductUrl = str;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoodsMsg extends NormalMsg {
    public static final Parcelable.Creator<GoodsMsg> CREATOR = new Parcelable.Creator<GoodsMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GoodsMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsMsg createFromParcel(Parcel parcel) {
            return new GoodsMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsMsg[] newArray(int i2) {
            return new GoodsMsg[i2];
        }
    };
    public static final String TAG = "GoodsMsg";
    public double mCoupon;
    public int mId;
    public String mImage;
    public String mJumpName;
    public double mPrice;
    public int mSales;
    public String mSchema;
    public String mShopName;
    public String mTitle;

    public GoodsMsg() {
        this.mSales = -1;
        this.mCoupon = -1.0d;
        setMsgType(29);
    }

    private double getCouponFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1.0d;
        }
        try {
            return new JSONObject(jSONObject.optString("coupons")).optDouble("salePrice", -1.0d);
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public double getCoupon() {
        return this.mCoupon;
    }

    public int getId() {
        return this.mId;
    }

    public String getImage() {
        return this.mImage;
    }

    public String getJumpName() {
        return this.mJumpName;
    }

    public double getPrice() {
        return this.mPrice;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "好货来袭，快来看看吧！";
    }

    public int getSales() {
        return this.mSales;
    }

    public String getSchema() {
        return this.mSchema;
    }

    public String getShopName() {
        return this.mShopName;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            LogUtils.d(TAG, "parse goods msg " + getJsonContent());
            this.mTitle = jSONObject.getString("title");
            this.mImage = jSONObject.getString("image");
            this.mPrice = jSONObject.getDouble("price");
            this.mSales = jSONObject.optInt("sales", -1);
            this.mCoupon = getCouponFromJson(jSONObject);
            this.mSchema = jSONObject.optString("slink", "");
            this.mShopName = jSONObject.optString("tp_name", "");
            this.mId = jSONObject.optInt("num_id");
            this.mJumpName = jSONObject.optString("des_source");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parseJsonString JSONException", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mImage);
        parcel.writeDouble(this.mPrice);
        parcel.writeInt(this.mSales);
        parcel.writeDouble(this.mCoupon);
        parcel.writeString(this.mSchema);
        parcel.writeString(this.mShopName);
        parcel.writeInt(this.mId);
        parcel.writeString(this.mJumpName);
    }

    public GoodsMsg(Parcel parcel) {
        super(parcel);
        this.mSales = -1;
        this.mCoupon = -1.0d;
        this.mTitle = parcel.readString();
        this.mImage = parcel.readString();
        this.mPrice = parcel.readDouble();
        this.mSales = parcel.readInt();
        this.mCoupon = parcel.readDouble();
        this.mSchema = parcel.readString();
        this.mShopName = parcel.readString();
        this.mId = parcel.readInt();
        this.mJumpName = parcel.readString();
    }
}

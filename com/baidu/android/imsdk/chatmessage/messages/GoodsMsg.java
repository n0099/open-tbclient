package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
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
        public GoodsMsg[] newArray(int i) {
            return new GoodsMsg[i];
        }
    };
    private static final String TAG = "GoodsMsg";
    private double mCoupon;
    private int mId;
    private String mImage;
    private String mJumpName;
    private double mPrice;
    private int mSales;
    private String mSchema;
    private String mShopName;
    private String mTitle;

    public GoodsMsg() {
        this.mSales = -1;
        this.mCoupon = -1.0d;
        setMsgType(29);
    }

    public GoodsMsg(Parcel parcel) {
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
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
        } catch (JSONException e) {
            LogUtils.e("SignleGraphicTextMsg", "parseJsonString JSONException", e);
            return false;
        }
    }

    private double getCouponFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1.0d;
        }
        try {
            return new JSONObject(jSONObject.optString("coupons")).optDouble("salePrice", -1.0d);
        } catch (Exception e) {
            return -1.0d;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[收到一个商品]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
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

    public String getTitle() {
        return this.mTitle;
    }

    public String getImage() {
        return this.mImage;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public int getSales() {
        return this.mSales;
    }

    public double getCoupon() {
        return this.mCoupon;
    }

    public String getSchema() {
        return this.mSchema;
    }

    public String getShopName() {
        return this.mShopName;
    }

    public int getId() {
        return this.mId;
    }

    public String getJumpName() {
        return this.mJumpName;
    }
}

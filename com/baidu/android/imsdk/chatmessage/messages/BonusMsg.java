package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class BonusMsg extends NormalMsg {
    public static final Parcelable.Creator<BonusMsg> CREATOR = new Parcelable.Creator<BonusMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.BonusMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BonusMsg createFromParcel(Parcel parcel) {
            return new BonusMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BonusMsg[] newArray(int i) {
            return new BonusMsg[i];
        }
    };
    private static final String TAG = "BonusMsg";
    private String mDescription;
    private String mDiscountCondition;
    private int mDiscountType;
    private String mDiscountValue;
    private String mIcon;
    private String mIdentity;
    private String mOperationText;
    private String mSkipAddr;
    private int mSkipType;
    private String mSource;
    private String mText;

    public BonusMsg() {
        this.mText = "";
        this.mSource = "";
        this.mIdentity = "";
        this.mDescription = "";
        this.mDiscountType = 0;
        this.mDiscountValue = "";
        this.mDiscountCondition = "";
        this.mIcon = "";
        this.mOperationText = "";
        this.mSkipType = 0;
        this.mSkipAddr = "";
        setMsgType(30);
    }

    public BonusMsg(Parcel parcel) {
        super(parcel);
        this.mText = "";
        this.mSource = "";
        this.mIdentity = "";
        this.mDescription = "";
        this.mDiscountType = 0;
        this.mDiscountValue = "";
        this.mDiscountCondition = "";
        this.mIcon = "";
        this.mOperationText = "";
        this.mSkipType = 0;
        this.mSkipAddr = "";
        this.mText = parcel.readString();
        this.mSource = parcel.readString();
        this.mIdentity = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDiscountType = parcel.readInt();
        this.mDiscountValue = parcel.readString();
        this.mDiscountCondition = parcel.readString();
        this.mIcon = parcel.readString();
        this.mOperationText = parcel.readString();
        this.mSkipType = parcel.readInt();
        this.mSkipAddr = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            LogUtils.d(TAG, "parse Coupon msg " + getJsonContent());
            this.mText = jSONObject.optString("text");
            JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
            this.mSource = jSONObject2.getString("source");
            this.mIdentity = jSONObject2.getString("identity");
            this.mDescription = jSONObject2.getString("description");
            this.mDiscountType = jSONObject2.getInt("discount_type");
            this.mDiscountCondition = jSONObject2.getString("discount_condition");
            this.mDiscountValue = jSONObject2.getString("discount_value");
            this.mIcon = jSONObject2.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.mOperationText = jSONObject2.getString("operation_text");
            this.mSkipType = jSONObject2.getInt("skip_type");
            this.mSkipAddr = jSONObject2.getString("skip_addr");
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parseJsonString JSONException", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mText);
        parcel.writeString(this.mSource);
        parcel.writeString(this.mIdentity);
        parcel.writeString(this.mDescription);
        parcel.writeInt(this.mDiscountType);
        parcel.writeString(this.mDiscountValue);
        parcel.writeString(this.mDiscountCondition);
        parcel.writeString(this.mIcon);
        parcel.writeString(this.mOperationText);
        parcel.writeInt(this.mSkipType);
        parcel.writeString(this.mSkipAddr);
    }

    public String getText() {
        return this.mText;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDiscountType() {
        return this.mDiscountType;
    }

    public String getDiscountValue() {
        return this.mDiscountValue;
    }

    public String getDiscountCondition() {
        return this.mDiscountCondition;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getOperationText() {
        return this.mOperationText;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public String getSkipAddr() {
        return this.mSkipAddr;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setDiscountType(int i) {
        this.mDiscountType = i;
    }

    public void setDiscountValue(String str) {
        this.mDiscountValue = str;
    }

    public void setDiscountCondition(String str) {
        this.mDiscountCondition = str;
    }

    public void setIcon(String str) {
        this.mIcon = str;
    }

    public void setOperationText(String str) {
        this.mOperationText = str;
    }

    public void setSkipType(int i) {
        this.mSkipType = i;
    }

    public void setSkipAddr(String str) {
        this.mSkipAddr = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "有一个优惠送给你！";
    }
}

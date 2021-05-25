package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BrandMsg extends NormalMsg {
    public static final Parcelable.Creator<BrandMsg> CREATOR = new Parcelable.Creator<BrandMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.BrandMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrandMsg createFromParcel(Parcel parcel) {
            return new BrandMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrandMsg[] newArray(int i2) {
            return new BrandMsg[i2];
        }
    };
    public static final String DEFAULT_DESC = "有事搜一搜，没事看一看";
    public static final String TAG = "BrandMsg";
    public String mButtonText;
    public String mDescreiption;
    public String mImgUrl;
    public String mSkipAddr;
    public int mSkipType;
    public String mTitle;

    public BrandMsg() {
        this.mSkipAddr = "";
        setMsgType(38);
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public String getDescreiption() {
        return this.mDescreiption;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mTitle;
    }

    public String getSkipAddr() {
        return this.mSkipAddr;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            String jsonContent = getJsonContent();
            JSONObject jSONObject = new JSONObject(jsonContent);
            LogUtils.d(TAG, "parse brands content:" + jsonContent);
            if (TextUtils.isEmpty(jSONObject.optString("title"))) {
                return false;
            }
            this.mTitle = jSONObject.optString("title");
            if (!TextUtils.isEmpty(jSONObject.optString("description"))) {
                this.mDescreiption = jSONObject.optString("description");
            } else {
                this.mDescreiption = DEFAULT_DESC;
            }
            this.mImgUrl = jSONObject.optString("image_url");
            if (jSONObject.has(GameGuideConfigInfo.KEY_BUTTON_TEXT)) {
                this.mButtonText = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            }
            this.mSkipType = jSONObject.optInt("skip_type");
            this.mSkipAddr = jSONObject.optString("skip_addr");
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setButtonText(String str) {
        this.mButtonText = str;
    }

    public void setDescreiption(String str) {
        this.mDescreiption = str;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setSkipAddr(String str) {
        this.mSkipAddr = str;
    }

    public void setSkipType(int i2) {
        this.mSkipType = i2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescreiption);
        parcel.writeString(this.mImgUrl);
        parcel.writeString(this.mButtonText);
        parcel.writeInt(this.mSkipType);
        parcel.writeString(this.mSkipAddr);
    }

    public BrandMsg(Parcel parcel) {
        super(parcel);
        this.mSkipAddr = "";
        this.mTitle = parcel.readString();
        this.mDescreiption = parcel.readString();
        this.mImgUrl = parcel.readString();
        this.mButtonText = parcel.readString();
        this.mSkipType = parcel.readInt();
        this.mSkipAddr = parcel.readString();
    }
}

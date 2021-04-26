package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignleGraphicTextMsg extends NormalMsg {
    public static final Parcelable.Creator<SignleGraphicTextMsg> CREATOR = new Parcelable.Creator<SignleGraphicTextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignleGraphicTextMsg createFromParcel(Parcel parcel) {
            return new SignleGraphicTextMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignleGraphicTextMsg[] newArray(int i2) {
            return new SignleGraphicTextMsg[i2];
        }
    };
    public static final int GRAPH = 0;
    public static final int VIDEO_1SHARE = 1;
    public static final int VIDEO_2SHARE = 2;
    public String mArticleUrl;
    public String mCommandUrl;
    public String mCover;
    public String mCovers;
    public String mDigest;
    public boolean mShare;
    public int mSubType;
    public String mTitle;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArticleUrl() {
        return this.mArticleUrl;
    }

    public String getCommandUrl() {
        return this.mCommandUrl;
    }

    public String getCover() {
        return this.mCover;
    }

    public String getCovers() {
        return this.mCovers;
    }

    public String getDigest() {
        return this.mDigest;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getTitle();
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isShare() {
        return this.mShare;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            LogUtils.d("", "parse signleGraph msg " + getJsonContent());
            this.mTitle = jSONObject.getString("title");
            this.mDigest = jSONObject.optString(LightappBusinessClient.MTD_DIGEST, "");
            this.mCover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "");
            this.mArticleUrl = jSONObject.getString("article_url");
            if (jSONObject.has("sti_type")) {
                this.mShare = true;
                this.mCovers = jSONObject.optString("sti_cover1");
                this.mSubType = jSONObject.optInt("sti_type");
            }
            String optString = jSONObject.optString("sti_cmd_ard");
            this.mCommandUrl = optString;
            if (TextUtils.isEmpty(optString)) {
                this.mCommandUrl = jSONObject.optString("sti_command");
                return true;
            }
            return true;
        } catch (JSONException e2) {
            LogUtils.e("SignleGraphicTextMsg", "parseJsonString JSONException", e2);
            return false;
        }
    }

    public void setArticleUrl(String str) {
        this.mArticleUrl = str;
    }

    public void setCover(String str) {
        this.mCover = str;
    }

    public void setDigest(String str) {
        this.mDigest = str;
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(LightappBusinessClient.MTD_DIGEST) || TextUtils.isEmpty(str4)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", str);
            jSONObject.put(LightappBusinessClient.MTD_DIGEST, str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("article_url", str4);
            }
            jSONObject.put("sti_cover1", str5);
            jSONObject.put("sti_type", i2);
            return setMsgContent(jSONObject.toString());
        } catch (Exception unused) {
            LogUtils.e("SignleGraphicTextMsg", "content error!");
            return false;
        }
    }

    public void setSubType(int i2) {
        this.mSubType = i2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDigest);
        parcel.writeString(this.mCover);
        parcel.writeString(this.mArticleUrl);
        parcel.writeString(this.mCovers);
        parcel.writeInt(this.mSubType);
        parcel.writeString(this.mCommandUrl);
    }

    public SignleGraphicTextMsg() {
        this.mShare = false;
        setMsgType(8);
    }

    public SignleGraphicTextMsg(Parcel parcel) {
        super(parcel);
        this.mShare = false;
        this.mTitle = parcel.readString();
        this.mDigest = parcel.readString();
        this.mCover = parcel.readString();
        this.mArticleUrl = parcel.readString();
        this.mCovers = parcel.readString();
        this.mSubType = parcel.readInt();
        this.mCommandUrl = parcel.readString();
    }
}

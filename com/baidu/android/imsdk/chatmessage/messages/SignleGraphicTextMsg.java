package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
        public SignleGraphicTextMsg[] newArray(int i) {
            return new SignleGraphicTextMsg[i];
        }
    };
    public static final int GRAPH = 0;
    public static final int VIDEO_1SHARE = 1;
    public static final int VIDEO_2SHARE = 2;
    private String mArticleUrl;
    private String mCommandUrl;
    private String mCover;
    private String mCovers;
    private String mDigest;
    private boolean mShare;
    private int mSubType;
    private String mTitle;

    public int getSubType() {
        return this.mSubType;
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }

    public String getCovers() {
        return this.mCovers;
    }

    public String getCommandUrl() {
        return this.mCommandUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getDigest() {
        return this.mDigest;
    }

    public void setDigest(String str) {
        this.mDigest = str;
    }

    public String getCover() {
        return this.mCover;
    }

    public void setCover(String str) {
        this.mCover = str;
    }

    public String getArticleUrl() {
        return this.mArticleUrl;
    }

    public void setArticleUrl(String str) {
        this.mArticleUrl = str;
    }

    public SignleGraphicTextMsg() {
        this.mShare = false;
        setMsgType(8);
    }

    private SignleGraphicTextMsg(Parcel parcel) {
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDigest);
        parcel.writeString(this.mCover);
        parcel.writeString(this.mArticleUrl);
        parcel.writeString(this.mCovers);
        parcel.writeInt(this.mSubType);
        parcel.writeString(this.mCommandUrl);
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty("digest") || TextUtils.isEmpty(str4)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", str);
            jSONObject.put("digest", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("cover", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("article_url", str4);
            }
            jSONObject.put("sti_cover1", str5);
            jSONObject.put("sti_type", i);
            return setMsgContent(jSONObject.toString());
        } catch (Exception e) {
            LogUtils.e("SignleGraphicTextMsg", "content error!");
            return false;
        }
    }

    public boolean isShare() {
        return this.mShare;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            LogUtils.d("", "parse signleGraph msg " + getJsonContent());
            this.mTitle = jSONObject.getString("title");
            this.mDigest = jSONObject.optString("digest", "");
            this.mCover = jSONObject.optString("cover", "");
            this.mArticleUrl = jSONObject.getString("article_url");
            if (jSONObject.has("sti_type")) {
                this.mShare = true;
                this.mCovers = jSONObject.optString("sti_cover1");
                this.mSubType = jSONObject.optInt("sti_type");
            }
            this.mCommandUrl = jSONObject.optString("sti_cmd_ard");
            if (TextUtils.isEmpty(this.mCommandUrl)) {
                this.mCommandUrl = jSONObject.optString("sti_command");
                return true;
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e("SignleGraphicTextMsg", "parseJsonString JSONException", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getTitle();
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageMsg extends RichMediaMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<ImageMsg> CREATOR = new Parcelable.Creator<ImageMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ImageMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageMsg createFromParcel(Parcel parcel) {
            return new ImageMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageMsg[] newArray(int i) {
            return new ImageMsg[i];
        }
    };
    public int mHeight;
    public String mThumbUrl;
    public int mWidth;

    public ImageMsg() {
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
    }

    private String getImgContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("thumbnail", this.mThumbUrl);
            if (this.mWidth > 0 && this.mHeight > 0) {
                jSONObject.put("w", this.mWidth);
                jSONObject.put("h", this.mHeight);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getImgContent JSONObject", e2);
            return "";
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[图片]";
    }

    public String getThumbUrl() {
        return this.mThumbUrl;
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            this.mRemoteUrl = jSONObject.optString("url");
            this.mThumbUrl = jSONObject.optString("thumbnail");
            this.mWidth = jSONObject.optInt("w", 0);
            this.mHeight = jSONObject.optInt("h", 0);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setContent(String str, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        setMsgContent(getImgContent(str));
    }

    public void setImgWH(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void setThumbUrl(String str) {
        this.mThumbUrl = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeString(this.mThumbUrl);
    }

    public void setContent(String str) {
        setMsgContent(getImgContent(str));
    }

    public ImageMsg(String str) {
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
        setLocalUrl(str);
    }

    public ImageMsg(String str, int i, int i2) {
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        setMsgType(1);
        setLocalUrl(str);
        this.mWidth = i;
        this.mHeight = i2;
    }

    public ImageMsg(Parcel parcel) {
        super(parcel);
        this.mThumbUrl = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mThumbUrl = parcel.readString();
    }
}

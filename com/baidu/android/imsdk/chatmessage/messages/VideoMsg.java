package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoMsg extends RichMediaMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<VideoMsg> CREATOR = new Parcelable.Creator<VideoMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.VideoMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoMsg createFromParcel(Parcel parcel) {
            return new VideoMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoMsg[] newArray(int i2) {
            return new VideoMsg[i2];
        }
    };
    public final String TAG;
    public int mDuration;
    public int mFormat;

    private String getVideoContent(String str, int i2, int i3, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("format", i2);
            jSONObject.put("duration", i3);
            jSONObject.put("thumbnail", Base64.encode(bArr));
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getVideoContent", e2);
            return "";
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getFormat() {
        return this.mFormat;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg
    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[短视频]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        if (!TextUtils.isEmpty(getJsonContent())) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                this.mRemoteUrl = jSONObject.optString("url");
                this.mFormat = jSONObject.optInt("format");
                this.mDuration = jSONObject.optInt("duration");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            }
        }
        return false;
    }

    public void setContent(String str, int i2, int i3, byte[] bArr) {
        setMsgContent(getVideoContent(str, i2, i3, bArr));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg
    public void setProgress(int i2) {
        this.mProgress = i2;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.mFormat);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mProgress);
    }

    public VideoMsg() {
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(3);
    }

    public VideoMsg(Parcel parcel) {
        super(parcel);
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        this.mFormat = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mProgress = parcel.readInt();
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.kwai.video.player.KsMediaMeta;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AudioMsg extends RichMediaMsg {
    public static final Parcelable.Creator<AudioMsg> CREATOR = new Parcelable.Creator<AudioMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AudioMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioMsg createFromParcel(Parcel parcel) {
            return new AudioMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioMsg[] newArray(int i2) {
            return new AudioMsg[i2];
        }
    };
    public final String TAG;
    public int mDuration;
    public int mFormat;

    private String getAudioContent(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put(KsMediaMeta.KSM_KEY_FORMAT, i2);
            jSONObject.put("duration", i3);
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(this.TAG, "getAudioContent Json", e2);
            return "";
        }
    }

    private void transCodeUrl(JSONObject jSONObject) {
        try {
            String decode = URLDecoder.decode(this.mRemoteUrl, "UTF-8");
            LogUtils.d(ChatMsg.TAG, decode);
            this.mRemoteUrl = decode;
            jSONObject.put("url", decode);
            this.mjsonContent = jSONObject.toString();
        } catch (UnsupportedEncodingException e2) {
            LogUtils.e(this.TAG, "transCodeUrl:", e2);
        } catch (JSONException e3) {
            LogUtils.e(this.TAG, "transCodeUrl:", e3);
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getFormat() {
        return this.mFormat;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[语音]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            this.mRemoteUrl = jSONObject.optString("url");
            this.mFormat = jSONObject.optInt(KsMediaMeta.KSM_KEY_FORMAT);
            this.mDuration = jSONObject.optInt("duration");
            if (this.mRemoteUrl.regionMatches(0, "http%3A", 0, 7)) {
                transCodeUrl(jSONObject);
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setContent(String str, int i2, int i3) {
        setMsgContent(getAudioContent(str, i2, i3));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.mFormat);
        parcel.writeInt(this.mDuration);
    }

    public AudioMsg() {
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
    }

    public AudioMsg(String str, int i2, int i3) {
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
        setLocalUrl(str);
        this.mDuration = i2;
        this.mFormat = i3;
    }

    public AudioMsg(Parcel parcel) {
        super(parcel);
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        this.mFormat = parcel.readInt();
        this.mDuration = parcel.readInt();
    }
}

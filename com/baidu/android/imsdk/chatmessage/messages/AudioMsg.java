package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
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
        public AudioMsg[] newArray(int i) {
            return new AudioMsg[i];
        }
    };
    private final String TAG;
    private int mDuration;
    private int mFormat;

    public AudioMsg() {
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
    }

    public AudioMsg(String str, int i, int i2) {
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
        setLocalUrl(str);
        this.mDuration = i;
        this.mFormat = i2;
    }

    private AudioMsg(Parcel parcel) {
        super(parcel);
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        this.mFormat = parcel.readInt();
        this.mDuration = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mFormat);
        parcel.writeInt(this.mDuration);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        if (TextUtils.isEmpty(this.mjsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mjsonContent);
            this.mRemoteUrl = jSONObject.optString("url");
            this.mFormat = jSONObject.optInt(IjkMediaMeta.IJKM_KEY_FORMAT);
            this.mDuration = jSONObject.optInt("duration");
            if (this.mRemoteUrl.regionMatches(0, "http%3A", 0, 7)) {
                transCodeUrl(jSONObject);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void transCodeUrl(JSONObject jSONObject) {
        try {
            String decode = URLDecoder.decode(this.mRemoteUrl, HTTP.UTF_8);
            LogUtils.d("ChatMsg", decode);
            this.mRemoteUrl = decode;
            jSONObject.put("url", decode);
            this.mjsonContent = jSONObject.toString();
        } catch (UnsupportedEncodingException e) {
            LogUtils.e(this.TAG, "transCodeUrl:", e);
        } catch (JSONException e2) {
            LogUtils.e(this.TAG, "transCodeUrl:", e2);
        }
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setContent(String str, int i, int i2) {
        setMsgContent(getAudioContent(str, i, i2));
    }

    private String getAudioContent(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put(IjkMediaMeta.IJKM_KEY_FORMAT, i);
                jSONObject.put("duration", i2);
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(this.TAG, "getAudioContent Json", e);
            }
        }
        return "";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[语音]";
    }
}

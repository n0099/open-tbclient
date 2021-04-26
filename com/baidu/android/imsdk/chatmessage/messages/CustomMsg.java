package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CustomMsg extends NormalMsg {
    public static final Parcelable.Creator<CustomMsg> CREATOR = new Parcelable.Creator<CustomMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.CustomMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomMsg createFromParcel(Parcel parcel) {
            return new CustomMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomMsg[] newArray(int i2) {
            return new CustomMsg[i2];
        }
    };
    public String data;
    public String encode;

    private String getTextJson(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            jSONObject.put("encode", str2);
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getTextJson", e2);
        }
        return jSONObject.toString();
    }

    public String getData() {
        return this.data;
    }

    public String getEncode() {
        return this.encode;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[自定义消息]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.data = jSONObject.optString("data");
                this.encode = jSONObject.optString("encode");
                return true;
            } catch (JSONException e2) {
                LogUtils.e("CustomMsg", "parse json err!", e2);
            }
        }
        return false;
    }

    public void setContent(String str, String str2) {
        setMsgContent(getTextJson(str, str2));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.data);
        parcel.writeString(this.encode);
    }

    public CustomMsg() {
        setMsgType(100);
    }

    public CustomMsg(String str, String str2) {
        setMsgType(100);
        this.data = str;
        this.encode = str2;
        setContent(str, str2);
    }

    public CustomMsg(Parcel parcel) {
        super(parcel);
        this.data = parcel.readString();
        this.encode = parcel.readString();
    }
}

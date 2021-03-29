package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class InterActiveMsg extends NormalMsg {
    public static final Parcelable.Creator<InterActiveMsg> CREATOR = new Parcelable.Creator<InterActiveMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InterActiveMsg createFromParcel(Parcel parcel) {
            return new InterActiveMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InterActiveMsg[] newArray(int i) {
            return new InterActiveMsg[i];
        }
    };
    public static final String TAG = "InterActiveMsg";
    public int mTemplate;

    public InterActiveMsg(Parcel parcel) {
        super(parcel);
        this.mTemplate = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        try {
            JSONObject optJSONObject = new JSONObject(getJsonContent()).optJSONObject("text");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("level2");
                return TextUtils.isEmpty(optString) ? optJSONObject.optString("level1") : optString;
            }
            return "";
        } catch (Exception e2) {
            LogUtils.e(TAG, "getRecommendDescription JSONException", e2);
            return "";
        }
    }

    public int getTemplate() {
        return this.mTemplate;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseCommon() {
        LogUtils.d(TAG, "parseCommon");
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseExt() {
        LogUtils.d(TAG, "parseExt");
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            this.mTemplate = new JSONObject(getJsonContent()).optInt("template");
            return true;
        } catch (Exception e2) {
            LogUtils.e(TAG, "parseJsonString JSONException", e2);
            return false;
        }
    }

    public void setTemplate(int i) {
        this.mTemplate = i;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mTemplate);
    }

    public InterActiveMsg() {
        setMsgType(24);
    }
}

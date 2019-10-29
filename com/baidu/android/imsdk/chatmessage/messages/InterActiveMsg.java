package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    private int mTemplate;

    public InterActiveMsg(Parcel parcel) {
        super(parcel);
        this.mTemplate = parcel.readInt();
    }

    public InterActiveMsg() {
        setMsgType(24);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            this.mTemplate = new JSONObject(getJsonContent()).optInt("template");
            return true;
        } catch (Exception e) {
            LogUtils.e(TAG, "parseJsonString JSONException", e);
            return false;
        }
    }

    public int getTemplate() {
        return this.mTemplate;
    }

    public void setTemplate(int i) {
        this.mTemplate = i;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        Exception e;
        JSONObject optJSONObject;
        String optString;
        try {
            optJSONObject = new JSONObject(getJsonContent()).optJSONObject("text");
            optString = optJSONObject.optString("level2");
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (TextUtils.isEmpty(optString)) {
                return optJSONObject.optString("level1");
            }
            return optString;
        } catch (Exception e3) {
            e = e3;
            LogUtils.e(TAG, "getRecommendDescription JSONException", e);
            return "";
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mTemplate);
    }
}

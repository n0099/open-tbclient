package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class DuPaBManualMsg extends ChatMsg {
    private static final String B_CALLBACK_KEY = "callback_key";
    private static final String B_EVALUATIONS = "evaluations";
    private static final String B_TEXT = "text";
    private static final String B_TITLE = "title";
    public static final Parcelable.Creator<DuPaBManualMsg> CREATOR = new Parcelable.Creator<DuPaBManualMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DuPaBManualMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaBManualMsg createFromParcel(Parcel parcel) {
            return new DuPaBManualMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaBManualMsg[] newArray(int i) {
            return new DuPaBManualMsg[i];
        }
    };
    private static final String TAG = "DuPaBManualMsg";
    public String callbackKey;
    public String text;
    public String title;

    public DuPaBManualMsg(String str) {
        this();
        this.callbackKey = str;
        setMsgContent(getManualContentJson());
    }

    public DuPaBManualMsg() {
        setMsgType(32);
        setCategory(7);
        setChatType(7);
    }

    private DuPaBManualMsg(Parcel parcel) {
        super(parcel);
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.callbackKey = parcel.readString();
    }

    private String getManualContentJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(B_CALLBACK_KEY, this.callbackKey);
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "getManualContentJson :", e);
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonContent);
            this.text = jSONObject.optString("text");
            this.title = jSONObject.optString("title");
            this.callbackKey = jSONObject.optString(B_CALLBACK_KEY);
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parse json err!", e);
            return false;
        }
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCallbackKey(String str) {
        this.callbackKey = str;
    }

    public String getCallbackKey() {
        return this.callbackKey;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getText();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeString(this.callbackKey);
    }
}

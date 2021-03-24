package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HtmlMsg extends NormalMsg {
    public static final Parcelable.Creator<HtmlMsg> CREATOR = new Parcelable.Creator<HtmlMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.HtmlMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HtmlMsg createFromParcel(Parcel parcel) {
            return new HtmlMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HtmlMsg[] newArray(int i) {
            return new HtmlMsg[i];
        }
    };
    public static final String TAG = "HtmlMsg";
    public String mDesc;
    public String mHtml;

    private String getTextJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("html", str);
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getTextJson", e2);
        }
        return jSONObject.toString();
    }

    public String getDesc() {
        return this.mDesc;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mDesc;
    }

    public String getText() {
        return this.mHtml;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                this.mHtml = new JSONObject(jsonContent).optString("html");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parse json err!", e2);
            }
        }
        return false;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setText(String str) {
        setMsgContent(getTextJson(str));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mHtml);
        parcel.writeString(this.mDesc);
    }

    public HtmlMsg(String str) {
        this.mDesc = "[新消息]";
        setMsgType(18);
        this.mHtml = str;
        setText(str);
    }

    public HtmlMsg() {
        this.mDesc = "[新消息]";
        setMsgType(18);
    }

    public HtmlMsg(Parcel parcel) {
        super(parcel);
        this.mDesc = "[新消息]";
        this.mHtml = parcel.readString();
        this.mDesc = parcel.readString();
    }
}

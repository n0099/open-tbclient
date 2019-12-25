package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.ugc.model.QuestionResponseModel;
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
    private static final String TAG = "HtmlMsg";
    public String mDesc;
    private String mHtml;

    public String getDesc() {
        return this.mDesc;
    }

    public void setDesc(String str) {
        this.mDesc = str;
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

    private HtmlMsg(Parcel parcel) {
        super(parcel);
        this.mDesc = "[新消息]";
        this.mHtml = parcel.readString();
        this.mDesc = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            this.mHtml = new JSONObject(jsonContent).optString(QuestionResponseModel.TEXT);
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parse json err!", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mHtml);
        parcel.writeString(this.mDesc);
    }

    public void setText(String str) {
        setMsgContent(getTextJson(str));
    }

    private String getTextJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QuestionResponseModel.TEXT, str);
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "getTextJson", e);
        }
        return jSONObject.toString();
    }

    public String getText() {
        return this.mHtml;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mDesc;
    }
}

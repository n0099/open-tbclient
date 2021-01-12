package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShieldMsg extends NormalMsg {
    public static final Parcelable.Creator<ShieldMsg> CREATOR = new Parcelable.Creator<ShieldMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ShieldMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShieldMsg createFromParcel(Parcel parcel) {
            return new ShieldMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShieldMsg[] newArray(int i) {
            return new ShieldMsg[i];
        }
    };
    public String text;

    public ShieldMsg(String str) {
        setMsgType(IMConstants.IM_MSG_TYPE_SHIELD);
        this.text = str;
        setText(this.text);
    }

    public ShieldMsg(String str, boolean z) {
        setMsgType(z ? IMConstants.IM_MSG_TYPE_SHIELD_ME : IMConstants.IM_MSG_TYPE_SHIELD);
        this.text = str;
        setText(this.text);
    }

    public ShieldMsg() {
        setMsgType(IMConstants.IM_MSG_TYPE_SHIELD_ME);
        this.text = "";
        setText(this.text);
    }

    private ShieldMsg(Parcel parcel) {
        super(parcel);
        this.text = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            this.text = new JSONObject(jsonContent).optString("text");
            return true;
        } catch (JSONException e) {
            LogUtils.e("TextMsg", "parse json err!", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
    }

    public void setText(String str) {
        setMsgContent(getTextJson(str));
    }

    private String getTextJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str);
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "getTextJson", e);
        }
        return jSONObject.toString();
    }

    public String getText() {
        return this.text;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getText();
    }
}

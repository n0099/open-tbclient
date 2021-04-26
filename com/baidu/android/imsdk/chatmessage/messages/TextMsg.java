package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TextMsg extends NormalMsg {
    public static final Parcelable.Creator<TextMsg> CREATOR = new Parcelable.Creator<TextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TextMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextMsg createFromParcel(Parcel parcel) {
            return new TextMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextMsg[] newArray(int i2) {
            return new TextMsg[i2];
        }
    };
    public long castId;
    public long priority;
    public String text;

    private String getTextJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str);
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "getTextJson", e2);
        }
        return jSONObject.toString();
    }

    public long getCastId() {
        return this.castId;
    }

    public long getPriority() {
        return this.priority;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getText();
    }

    public String getText() {
        return this.text;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                this.text = new JSONObject(jsonContent).optString("text");
                return true;
            } catch (JSONException e2) {
                LogUtils.e("TextMsg", "parse json err!", e2);
            }
        }
        return false;
    }

    public void setCastId(long j) {
        this.castId = j;
    }

    public void setPriority(long j) {
        this.priority = j;
    }

    public void setText(String str) {
        setMsgContent(getTextJson(str));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.text);
        parcel.writeLong(this.castId);
        parcel.writeLong(this.priority);
    }

    public TextMsg(String str) {
        setMsgType(0);
        this.text = str;
        setText(str);
    }

    public TextMsg() {
        setMsgType(0);
    }

    public TextMsg(Parcel parcel) {
        super(parcel);
        this.text = parcel.readString();
        this.castId = parcel.readLong();
        this.priority = parcel.readLong();
    }
}

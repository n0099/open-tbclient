package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        public TextMsg[] newArray(int i) {
            return new TextMsg[i];
        }
    };
    private long castId;
    private long priority;
    public String text;

    public TextMsg(String str) {
        setMsgType(0);
        this.text = str;
        setText(this.text);
    }

    public TextMsg() {
        setMsgType(0);
    }

    private TextMsg(Parcel parcel) {
        super(parcel);
        this.text = parcel.readString();
        this.castId = parcel.readLong();
        this.priority = parcel.readLong();
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
        parcel.writeLong(this.castId);
        parcel.writeLong(this.priority);
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

    public void setCastId(long j) {
        this.castId = j;
    }

    public long getCastId() {
        return this.castId;
    }

    public void setPriority(long j) {
        this.priority = j;
    }

    public long getPriority() {
        return this.priority;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return getText();
    }
}

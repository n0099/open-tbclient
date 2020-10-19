package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GalleryMsg extends NormalMsg {
    public static final Parcelable.Creator<GalleryMsg> CREATOR = new Parcelable.Creator<GalleryMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GalleryMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GalleryMsg createFromParcel(Parcel parcel) {
            return new GalleryMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GalleryMsg[] newArray(int i) {
            return new GalleryMsg[i];
        }
    };
    public String text;

    public GalleryMsg(String str) {
        setMsgType(80);
        this.text = str;
        setText(this.text);
    }

    public GalleryMsg() {
        setMsgType(80);
    }

    private GalleryMsg(Parcel parcel) {
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

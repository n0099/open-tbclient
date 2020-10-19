package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SchemaMsg extends NormalMsg {
    public static final Parcelable.Creator<SchemaMsg> CREATOR = new Parcelable.Creator<SchemaMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SchemaMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchemaMsg createFromParcel(Parcel parcel) {
            return new SchemaMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchemaMsg[] newArray(int i) {
            return new SchemaMsg[i];
        }
    };
    private String mContent;

    private SchemaMsg(Parcel parcel) {
        super(parcel);
        this.mContent = parcel.readString();
    }

    public SchemaMsg() {
        setMsgType(22);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mContent);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            this.mContent = new JSONObject(jsonContent).optString("src");
            return true;
        } catch (JSONException e) {
            LogUtils.e("TextMsg", "parse json err!", e);
            return false;
        }
    }

    public String getText() {
        return this.mContent;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        Spanned spanned;
        try {
            spanned = Html.fromHtml(URLDecoder.decode(getText()));
        } catch (Exception e) {
            e.printStackTrace();
            spanned = null;
        }
        if (spanned == null || TextUtils.isEmpty(spanned.toString())) {
            return "";
        }
        return spanned.toString();
    }
}

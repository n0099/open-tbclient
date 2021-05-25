package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SettingRemindMsg extends NormalMsg {
    public static final Parcelable.Creator<SettingRemindMsg> CREATOR = new Parcelable.Creator<SettingRemindMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SettingRemindMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingRemindMsg createFromParcel(Parcel parcel) {
            return new SettingRemindMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingRemindMsg[] newArray(int i2) {
            return new SettingRemindMsg[i2];
        }
    };
    public static final String PAGE_SYMBOL = "msg_setting_page";
    public static final char SEARCH_SYMBOL = '#';
    public String mContent;
    public String mPage;

    public SettingRemindMsg(Parcel parcel) {
        super(parcel);
        this.mContent = parcel.readString();
        this.mPage = parcel.readString();
    }

    public String getPage() {
        return this.mPage;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }

    public String getText() {
        return this.mContent;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mContent = jSONObject.optString("text");
                this.mPage = jSONObject.optString("page");
                return true;
            } catch (JSONException e2) {
                LogUtils.e("TextMsg", "parse json err!", e2);
            }
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mContent);
        parcel.writeString(this.mPage);
    }

    public SettingRemindMsg() {
        setMsgType(36);
    }
}

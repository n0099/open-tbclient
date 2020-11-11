package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class ConfigMsg extends NormalMsg {
    public static final Parcelable.Creator<ConfigMsg> CREATOR = new Parcelable.Creator<ConfigMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ConfigMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigMsg createFromParcel(Parcel parcel) {
            return new ConfigMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigMsg[] newArray(int i) {
            return new ConfigMsg[i];
        }
    };
    private String dataList;

    public String getDataList() {
        return this.dataList;
    }

    public void setDataList(String str) {
        this.dataList = str;
    }

    public ConfigMsg() {
        setMsgType(20);
    }

    private ConfigMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            this.dataList = new JSONObject(jsonContent).optString("data_list");
            return true;
        } catch (JSONException e) {
            LogUtils.e("TextMsg", "parse json err!", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }
}

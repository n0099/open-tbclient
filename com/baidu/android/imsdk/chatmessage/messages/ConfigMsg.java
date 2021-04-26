package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
        public ConfigMsg[] newArray(int i2) {
            return new ConfigMsg[i2];
        }
    };
    public String dataList;

    public String getDataList() {
        return this.dataList;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                this.dataList = new JSONObject(jsonContent).optString("data_list");
                return true;
            } catch (JSONException e2) {
                LogUtils.e("TextMsg", "parse json err!", e2);
            }
        }
        return false;
    }

    public void setDataList(String str) {
        this.dataList = str;
    }

    public ConfigMsg() {
        setMsgType(20);
    }

    public ConfigMsg(Parcel parcel) {
        super(parcel);
    }
}

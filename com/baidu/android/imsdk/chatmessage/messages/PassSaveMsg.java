package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PassSaveMsg extends NormalMsg {
    public static final Parcelable.Creator<PassSaveMsg> CREATOR = new Parcelable.Creator<PassSaveMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.PassSaveMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassSaveMsg createFromParcel(Parcel parcel) {
            return new PassSaveMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassSaveMsg[] newArray(int i) {
            return new PassSaveMsg[i];
        }
    };
    public static final String TAG = "PassSaveMsg";

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        try {
            return new JSONObject(getJsonContent()).optString("text");
        } catch (JSONException e2) {
            LogUtils.e(TAG, "getRecommendDescription exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseExt() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        return true;
    }

    public PassSaveMsg() {
        setMsgType(28);
    }

    public PassSaveMsg(String str) {
        this();
        setMsgContent(str);
    }

    public PassSaveMsg(Parcel parcel) {
        super(parcel);
    }
}

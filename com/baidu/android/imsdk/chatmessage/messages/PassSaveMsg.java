package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
    private static final String TAG = "PassSaveMsg";

    public PassSaveMsg() {
        setMsgType(28);
    }

    public PassSaveMsg(String str) {
        this();
        setMsgContent(str);
    }

    private PassSaveMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        try {
            return new JSONObject(getJsonContent()).optString("text");
        } catch (JSONException e) {
            LogUtils.e(TAG, "getRecommendDescription exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseExt() {
        return true;
    }
}

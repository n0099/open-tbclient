package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class RealTimeMsg extends NormalMsg implements Parcelable, NoProGuard {
    public int mDuration;
    public boolean mSucess;

    public RealTimeMsg() {
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getRealTimeMsgJsonString(boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucess", z);
            jSONObject.put("duration", i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isSucess() {
        return this.mSucess;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonContent);
            this.mSucess = jSONObject.optBoolean("sucess");
            this.mDuration = jSONObject.optInt("duration");
            return false;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public void setContent(boolean z, int i) {
        setMsgContent(getRealTimeMsgJsonString(z, i));
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSucess ? 1 : 0);
        parcel.writeInt(this.mDuration);
    }

    public RealTimeMsg(Parcel parcel) {
        super(parcel);
        this.mSucess = parcel.readInt() != 0;
        this.mDuration = parcel.readInt();
    }
}

package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class RealTimeMsg extends NormalMsg implements Parcelable, NoProGuard {
    protected int mDuration;
    protected boolean mSucess;

    public boolean isSucess() {
        return this.mSucess;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public RealTimeMsg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RealTimeMsg(Parcel parcel) {
        super(parcel);
        this.mSucess = parcel.readInt() != 0;
        this.mDuration = parcel.readInt();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mSucess = jSONObject.optBoolean("sucess");
                this.mDuration = jSONObject.optInt("duration");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            }
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSucess ? 1 : 0);
        parcel.writeInt(this.mDuration);
    }

    public void setContent(boolean z, int i) {
        setMsgContent(getRealTimeMsgJsonString(z, i));
    }

    protected String getRealTimeMsgJsonString(boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucess", z);
            jSONObject.put("duration", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}

package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMSyncRtcInfo extends BIMRtcInfo {
    public static final String TAG = "IMSyncRtcInfo";
    public long mInitiatorUk;
    public int mAnswerType = -1;
    public int mInviteId = -1;

    public int getAnswerType() {
        return this.mAnswerType;
    }

    public long getInitiatorUk() {
        return this.mInitiatorUk;
    }

    public int getInviteId() {
        return this.mInviteId;
    }

    public void setAnswerType(int i) {
        this.mAnswerType = i;
    }

    public void setInitiatorUk(long j) {
        this.mInitiatorUk = j;
    }

    public void setInviteId(int i) {
        this.mInviteId = i;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uk", this.mInitiatorUk);
            if (this.mAnswerType > 0) {
                jSONObject.put("answer_type", this.mAnswerType);
            }
            if (this.mInviteId > 0) {
                jSONObject.put("invite_id", this.mInviteId);
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "IMSyncRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMSyncRtcInfo{" + super.toString() + ", mInitiatorUk=" + this.mInitiatorUk + ", mAnswerType=" + this.mAnswerType + ", mInviteId=" + this.mInviteId + '}';
    }
}

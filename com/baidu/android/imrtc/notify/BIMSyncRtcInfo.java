package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BIMSyncRtcInfo extends BIMRtcInfo {
    private static final String TAG = "IMSyncRtcInfo";
    protected long mInitiatorUk;
    private int mAnswerType = -1;
    protected int mInviteId = -1;

    public long getInitiatorUk() {
        return this.mInitiatorUk;
    }

    public void setInitiatorUk(long j) {
        this.mInitiatorUk = j;
    }

    public int getAnswerType() {
        return this.mAnswerType;
    }

    public void setAnswerType(int i) {
        this.mAnswerType = i;
    }

    public int getInviteId() {
        return this.mInviteId;
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
        } catch (Exception e) {
            LogUtils.e(TAG, "IMSyncRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMSyncRtcInfo{" + super.toString() + ", mInitiatorUk=" + this.mInitiatorUk + ", mAnswerType=" + this.mAnswerType + ", mInviteId=" + this.mInviteId + '}';
    }
}

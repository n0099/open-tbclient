package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMKickResSyncRtcInfo extends BIMKickReqSyncRtcInfo {
    private static final String TAG = "BIMKickResSyncRtcInfo";
    private int mKickedStatus = 0;

    public int getBIMKickedStatus() {
        return this.mKickedStatus;
    }

    public void setBIMKickedStatus(int i) {
        this.mKickedStatus = i;
    }

    @Override // com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo, com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("status", this.mKickedStatus);
            LogUtils.d(TAG, "BIMKickResSyncRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMKickResSyncRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo, com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMKickResSyncRtcInfo{" + super.toString() + ", status" + this.mKickedStatus + '}';
    }
}

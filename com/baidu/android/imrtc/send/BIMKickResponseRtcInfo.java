package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMKickResponseRtcInfo extends BIMKickRequestRtcInfo {
    public static final String TAG = "BIMKickResponseRtcInfo";
    public int mKickedStatus = 0;

    public BIMKickResponseRtcInfo() {
    }

    public int getBIMKickedStatus() {
        return this.mKickedStatus;
    }

    public void setBIMKickedStatus(int i) {
        this.mKickedStatus = i;
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMKickResponseRtcInfo bIMKickResponseRtcInfo = new BIMKickResponseRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            bIMKickResponseRtcInfo.setBIMKickedStatus(new JSONObject(str2).optInt("status"));
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMKickResponseRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMKickResponseRtcInfo;
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("status", this.mKickedStatus);
            LogUtils.d(TAG, "BIMKickResponseRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMKickResponseRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.send.BIMKickRequestRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMKickResponseRtcInfo{" + super.toString() + ", status" + this.mKickedStatus + '}';
    }

    public BIMKickResponseRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}

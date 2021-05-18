package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMAckRtcInfo extends BIMRtcInfo {
    public static final String TAG = "BIMAckRtcInfo";
    public long mAckSeqId;
    public int mAppState;
    public long mImUK;
    public int mSyncAction;

    public BIMAckRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public long getAckSeqId() {
        return this.mAckSeqId;
    }

    public long getImUK() {
        return this.mImUK;
    }

    public int getSyncAction() {
        return this.mSyncAction;
    }

    public int getmAppState() {
        return this.mAppState;
    }

    public void setAckSeqId(long j) {
        this.mAckSeqId = j;
    }

    public void setImUK(long j) {
        this.mImUK = j;
    }

    public void setSyncAction(int i2) {
        this.mSyncAction = i2;
    }

    public void setmAppState(int i2) {
        this.mAppState = i2;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo(super.toRtcInfo(i2, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMAckRtcInfo.setAckSeqId(jSONObject.optLong("ack_seqid"));
            bIMAckRtcInfo.setSyncAction(jSONObject.optInt("ack_action"));
            bIMAckRtcInfo.setImUK(jSONObject.optLong("uk"));
            bIMAckRtcInfo.setmAppState(jSONObject.optInt("app_stats"));
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMAckRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMAckRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("ack_seqid", this.mAckSeqId);
            jSONObject.put("ack_action", this.mSyncAction);
            jSONObject.put("uk", this.mImUK);
            jSONObject.put("app_stats", this.mAppState);
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMAckRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMAckRtcInfo{" + super.toString() + ", mAckSeqId='" + this.mAckSeqId + "', mSyncAction=" + this.mSyncAction + ", mImUK=" + this.mImUK + '}';
    }

    public BIMAckRtcInfo() {
    }
}

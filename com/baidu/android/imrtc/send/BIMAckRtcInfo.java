package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMAckRtcInfo extends BIMRtcInfo {
    private static final String TAG = "BIMAckRtcInfo";
    private long mAckSeqId;
    private long mImUK;
    private int mSyncAction;

    public long getAckSeqId() {
        return this.mAckSeqId;
    }

    public void setAckSeqId(long j) {
        this.mAckSeqId = j;
    }

    public int getSyncAction() {
        return this.mSyncAction;
    }

    public void setSyncAction(int i) {
        this.mSyncAction = i;
    }

    public long getImUK() {
        return this.mImUK;
    }

    public void setImUK(long j) {
        this.mImUK = j;
    }

    private BIMAckRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public BIMAckRtcInfo() {
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMAckRtcInfo{" + super.toString() + ", mAckSeqId='" + this.mAckSeqId + "', mSyncAction=" + this.mSyncAction + ", mImUK=" + this.mImUK + '}';
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("ack_seqid", this.mAckSeqId);
            jSONObject.put("ack_action", this.mSyncAction);
            jSONObject.put("uk", this.mImUK);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMAckRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMAckRtcInfo.setAckSeqId(jSONObject.optLong("ack_seqid"));
            bIMAckRtcInfo.setSyncAction(jSONObject.optInt("ack_action"));
            bIMAckRtcInfo.setImUK(jSONObject.optLong("uk"));
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMAckRtcInfo toRtcInfo Exception ", e);
        }
        return bIMAckRtcInfo;
    }
}

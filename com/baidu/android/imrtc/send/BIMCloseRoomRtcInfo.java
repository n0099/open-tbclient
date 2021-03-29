package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMCloseRoomRtcInfo extends BIMRtcInfo {
    public static final String TAG = "IMCloseRoomRtcInfo";
    public long mRoomDuration;

    public BIMCloseRoomRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public long getRoomDuration() {
        return this.mRoomDuration;
    }

    public void setRoomDuration(long j) {
        this.mRoomDuration = j;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo = new BIMCloseRoomRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            bIMCloseRoomRtcInfo.setRoomDuration(new JSONObject(str2).optLong("room_duration"));
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMAnswerRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMCloseRoomRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("room_duration", this.mRoomDuration);
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "IMCloseRoomRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMCloseRoomRtcInfo{" + super.toString() + "mRoomDuration=" + this.mRoomDuration + '}';
    }

    public BIMCloseRoomRtcInfo() {
    }
}

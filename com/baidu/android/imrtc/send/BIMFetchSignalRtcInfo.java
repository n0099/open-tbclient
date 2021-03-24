package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BIMFetchSignalRtcInfo extends BIMRtcInfo {
    public static final String TAG = "BIMFetchSignalRtcInfo";
    public long mFetchTime;
    public int mLimit = 100;

    public BIMFetchSignalRtcInfo() {
    }

    public long getFetchTime() {
        return this.mFetchTime;
    }

    public int getLimit() {
        return this.mLimit;
    }

    public void setFetchTime(long j) {
        this.mFetchTime = j;
    }

    public void setLimit(int i) {
        this.mLimit = i;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMFetchSignalRtcInfo bIMFetchSignalRtcInfo = new BIMFetchSignalRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMFetchSignalRtcInfo.setLimit(jSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT));
            bIMFetchSignalRtcInfo.setFetchTime(jSONObject.optLong("stime"));
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMFetchSignalRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMFetchSignalRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, this.mLimit);
            jSONObject.put("stime", this.mFetchTime);
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMFetchSignalRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMFetchSignalRtcInfo{" + super.toString() + "mLimit=" + this.mLimit + ", mFetchTime=" + this.mFetchTime + '}';
    }

    public BIMFetchSignalRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}

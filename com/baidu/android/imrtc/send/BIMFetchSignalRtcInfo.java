package com.baidu.android.imrtc.send;

import android.support.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BIMFetchSignalRtcInfo extends BIMRtcInfo {
    private static final String TAG = "BIMFetchSignalRtcInfo";
    private long mFetchTime;
    private int mLimit = 100;

    public int getLimit() {
        return this.mLimit;
    }

    public void setLimit(int i) {
        this.mLimit = i;
    }

    public long getFetchTime() {
        return this.mFetchTime;
    }

    public void setFetchTime(long j) {
        this.mFetchTime = j;
    }

    public BIMFetchSignalRtcInfo() {
    }

    private BIMFetchSignalRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, this.mLimit);
            jSONObject.put(PageStayDurationConstants.URL_KEY, this.mFetchTime);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMFetchSignalRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMFetchSignalRtcInfo bIMFetchSignalRtcInfo = new BIMFetchSignalRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMFetchSignalRtcInfo.setLimit(jSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT));
            bIMFetchSignalRtcInfo.setFetchTime(jSONObject.optLong(PageStayDurationConstants.URL_KEY));
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMFetchSignalRtcInfo toRtcInfo Exception ", e);
        }
        return bIMFetchSignalRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMFetchSignalRtcInfo{" + super.toString() + "mLimit=" + this.mLimit + ", mFetchTime=" + this.mFetchTime + '}';
    }
}

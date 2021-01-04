package com.baidu.android.imrtc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BIMRtcInfo implements Parcelable {
    public static final Parcelable.Creator<BIMRtcInfo> CREATOR = new Parcelable.Creator<BIMRtcInfo>() { // from class: com.baidu.android.imrtc.BIMRtcInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMRtcInfo createFromParcel(Parcel parcel) {
            return new BIMRtcInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMRtcInfo[] newArray(int i) {
            return new BIMRtcInfo[i];
        }
    };
    private static final String TAG = "IMRtcInfo";
    private int mAction;
    private String mCuid;
    private String mObj;
    protected String mRtcExt = "";
    private String mRtcRoomId;
    private long mSeq;

    public BIMRtcInfo() {
    }

    public BIMRtcInfo(String str) {
        this.mRtcRoomId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BIMRtcInfo(Parcel parcel) {
        this.mAction = parcel.readInt();
        this.mRtcRoomId = parcel.readString();
        this.mSeq = parcel.readLong();
        this.mObj = parcel.readString();
    }

    public int getAction() {
        return this.mAction;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public String getRtcRoomId() {
        return this.mRtcRoomId;
    }

    public void setRtcRoomId(String str) {
        this.mRtcRoomId = str;
    }

    public long getSeq() {
        return this.mSeq;
    }

    public void setSeq(long j) {
        this.mSeq = j;
    }

    public String getRtcDeviceId() {
        return this.mCuid;
    }

    public void setRtcDeviceId(String str) {
        this.mCuid = str;
    }

    public void setRtcExt(String str) {
        this.mRtcExt = str;
    }

    public String getRtcExt() {
        return this.mRtcExt;
    }

    public String toString() {
        return "BIMRtcInfo{mAction=" + this.mAction + ", mRtcRoomId='" + this.mRtcRoomId + "', mSeq=" + this.mSeq + ", mCuid='" + this.mCuid + "', mRtcExt='" + this.mRtcExt + "'}";
    }

    @NonNull
    public String toRtcInfoString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mAction != 100) {
                synchronized (RtcConstants.IM_RTC_SDK_SEQ_ID) {
                    if (RtcConstants.IM_RTC_SDK_SEQ_ID.get() == -1) {
                        RtcConstants.IM_RTC_SDK_SEQ_ID.set(System.currentTimeMillis());
                    } else {
                        RtcConstants.IM_RTC_SDK_SEQ_ID.incrementAndGet();
                    }
                    jSONObject.put(BdStatsConstant.SubType.SEQID, RtcConstants.IM_RTC_SDK_SEQ_ID.get());
                }
                jSONObject.put("ext", this.mRtcExt);
            }
            jSONObject.put("rtc_device_id", this.mCuid);
        } catch (Exception e) {
            LogUtils.e(TAG, "IMSyncRtcInfo Exception ", e);
        }
        this.mObj = jSONObject.toString();
        return this.mObj;
    }

    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMRtcInfo bIMRtcInfo = new BIMRtcInfo();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMRtcInfo.setAction(i);
            bIMRtcInfo.setRtcRoomId(str);
            bIMRtcInfo.setRtcExt(jSONObject.optString("ext"));
            bIMRtcInfo.setRtcDeviceId(jSONObject.optString("rtc_device_id"));
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMRtcInfo toRtcInfo Exception ", e);
        }
        return bIMRtcInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAction);
        parcel.writeString(this.mRtcRoomId);
        parcel.writeLong(this.mSeq);
        parcel.writeString(this.mObj);
    }
}

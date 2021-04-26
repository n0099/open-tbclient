package com.baidu.android.imrtc.send;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMAnswerRtcInfo extends BIMRtcInfo {
    public static final Parcelable.Creator<BIMAnswerRtcInfo> CREATOR = new Parcelable.Creator<BIMAnswerRtcInfo>() { // from class: com.baidu.android.imrtc.send.BIMAnswerRtcInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMAnswerRtcInfo createFromParcel(Parcel parcel) {
            return new BIMAnswerRtcInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BIMAnswerRtcInfo[] newArray(int i2) {
            return new BIMAnswerRtcInfo[i2];
        }
    };
    public static final String TAG = "IMAnswerRtcInfo";
    public String mAnswerDeviceInfo;
    public int mAnswerMediaType;
    public int mAnswerType;

    public BIMAnswerRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public String getAnswerDeviceInfo() {
        return this.mAnswerDeviceInfo;
    }

    public int getAnswerMediaType() {
        return this.mAnswerMediaType;
    }

    public int getAnswerType() {
        return this.mAnswerType;
    }

    public void setAnswerDeviceInfo(String str) {
        this.mAnswerDeviceInfo = str;
    }

    public void setAnswerMediaType(int i2) {
        this.mAnswerMediaType = i2;
    }

    public void setAnswerType(int i2) {
        this.mAnswerType = i2;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        BIMAnswerRtcInfo bIMAnswerRtcInfo = new BIMAnswerRtcInfo(super.toRtcInfo(i2, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            bIMAnswerRtcInfo.setAnswerType(jSONObject.optInt("answer_type"));
            bIMAnswerRtcInfo.setAnswerMediaType(jSONObject.optInt("answer_media_type"));
            bIMAnswerRtcInfo.setAnswerDeviceInfo(jSONObject.optString("answer_device_info"));
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMAnswerRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMAnswerRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            jSONObject.put("answer_type", this.mAnswerType);
            jSONObject.put("answer_media_type", this.mAnswerMediaType);
            jSONObject.put("answer_device_info", this.mAnswerDeviceInfo);
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "IMAnswerRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMAnswerRtcInfo{" + super.toString() + ", mAnswerDeviceInfo='" + this.mAnswerDeviceInfo + "', mAnswerType=" + this.mAnswerType + ", mAnswerMediaType=" + this.mAnswerMediaType + '}';
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mAnswerDeviceInfo);
        parcel.writeInt(this.mAnswerType);
        parcel.writeInt(this.mAnswerMediaType);
    }

    public BIMAnswerRtcInfo() {
    }

    public BIMAnswerRtcInfo(Parcel parcel) {
        super(parcel);
        this.mAnswerDeviceInfo = parcel.readString();
        this.mAnswerType = parcel.readInt();
        this.mAnswerMediaType = parcel.readInt();
    }
}

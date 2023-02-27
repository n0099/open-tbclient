package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes2.dex */
public class DeviceIdBag implements Parcelable {
    public static final int CODE_BACKGROUD = -1;
    public static final int CODE_CACHE = 1;
    public static final int CODE_CACHE_EMPTY = 2;
    public static final int CODE_NORMAL = 0;
    public static final int CODE_PRIVACY_DISAGREE = -3;
    public static final int CODE_REFUSE = -2;
    public static final int CODE_SYNC_MAPPING = 3;
    public static final Parcelable.Creator<DeviceIdBag> CREATOR = new Parcelable.Creator<DeviceIdBag>() { // from class: com.baidu.searchbox.common.security.DeviceIdBag.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBag createFromParcel(Parcel parcel) {
            return new DeviceIdBag(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBag[] newArray(int i) {
            return new DeviceIdBag[i];
        }
    };
    public String deviceId;
    public String encodedDeviceId;
    public int errorCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceIdBag() {
    }

    public String toString() {
        return "DeviceIdBag[" + this.deviceId + "--" + this.errorCode + PreferencesUtil.RIGHT_MOUNT;
    }

    public DeviceIdBag(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.errorCode = parcel.readInt();
        this.encodedDeviceId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.encodedDeviceId);
    }
}

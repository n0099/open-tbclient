package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.io.File;
/* loaded from: classes2.dex */
public class SwanCoreVersion extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR = new Parcelable.Creator<SwanCoreVersion>() { // from class: com.baidu.swan.apps.swancore.model.SwanCoreVersion.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: t */
        public SwanCoreVersion createFromParcel(Parcel parcel) {
            return new SwanCoreVersion(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: eW */
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    };
    public long bpQ;
    public int bpS;
    public String bpT;

    public SwanCoreVersion() {
    }

    private SwanCoreVersion(Parcel parcel) {
        this.bpS = parcel.readInt();
        this.bpQ = parcel.readLong();
        this.bpT = parcel.readString();
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.bpT + "', swanCoreVersion=" + this.bpQ + ", swanCoreType=" + this.bpS + ", isAvailable=" + isAvailable() + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bpS);
        parcel.writeLong(this.bpQ);
        parcel.writeString(this.bpT);
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.bpT) && new File(this.bpT).exists();
    }
}

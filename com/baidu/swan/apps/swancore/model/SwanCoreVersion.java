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
        /* renamed from: l */
        public SwanCoreVersion createFromParcel(Parcel parcel) {
            return new SwanCoreVersion(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dN */
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    };
    public long aTd;
    public int aTf;
    public String aTg;

    public SwanCoreVersion() {
    }

    private SwanCoreVersion(Parcel parcel) {
        this.aTf = parcel.readInt();
        this.aTd = parcel.readLong();
        this.aTg = parcel.readString();
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.aTg + "', swanCoreVersion=" + this.aTd + ", swanCoreType=" + this.aTf + ", isAvailable=" + isAvailable() + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aTf);
        parcel.writeLong(this.aTd);
        parcel.writeString(this.aTg);
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.aTg) && new File(this.aTg).exists();
    }
}

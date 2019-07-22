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
        /* renamed from: ea */
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    };
    public long aWG;
    public int aWI;
    public String aWJ;

    public SwanCoreVersion() {
    }

    private SwanCoreVersion(Parcel parcel) {
        this.aWI = parcel.readInt();
        this.aWG = parcel.readLong();
        this.aWJ = parcel.readString();
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.aWJ + "', swanCoreVersion=" + this.aWG + ", swanCoreType=" + this.aWI + ", isAvailable=" + isAvailable() + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aWI);
        parcel.writeLong(this.aWG);
        parcel.writeString(this.aWJ);
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.aWJ) && new File(this.aWJ).exists();
    }
}

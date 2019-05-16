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
        /* renamed from: dX */
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    };
    public long aVW;
    public int aVY;
    public String aVZ;

    public SwanCoreVersion() {
    }

    private SwanCoreVersion(Parcel parcel) {
        this.aVY = parcel.readInt();
        this.aVW = parcel.readLong();
        this.aVZ = parcel.readString();
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.aVZ + "', swanCoreVersion=" + this.aVW + ", swanCoreType=" + this.aVY + ", isAvailable=" + isAvailable() + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aVY);
        parcel.writeLong(this.aVW);
        parcel.writeString(this.aVZ);
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.aVZ) && new File(this.aVZ).exists();
    }
}

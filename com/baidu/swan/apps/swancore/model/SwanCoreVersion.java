package com.baidu.swan.apps.swancore.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.tieba.op3;
/* loaded from: classes4.dex */
public class SwanCoreVersion extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanCoreVersion> CREATOR = new a();
    public static final int TYPE_DEBUG = 2;
    public static final int TYPE_PRESET = 0;
    public static final int TYPE_REMOTE = 1;
    public String swanCorePath;
    public int swanCoreType;
    public long swanCoreVersionCode;
    public String swanCoreVersionName;

    public static String getTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : "debug" : "remote" : "preset";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SwanCoreVersion() {
    }

    public boolean isAvailable() {
        return op3.e(this.swanCorePath);
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<SwanCoreVersion> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanCoreVersion createFromParcel(Parcel parcel) {
            return new SwanCoreVersion(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanCoreVersion[] newArray(int i) {
            return new SwanCoreVersion[i];
        }
    }

    public SwanCoreVersion(Parcel parcel) {
        this.swanCoreType = parcel.readInt();
        this.swanCoreVersionCode = parcel.readLong();
        this.swanCoreVersionName = parcel.readString();
        this.swanCorePath = parcel.readString();
    }

    public /* synthetic */ SwanCoreVersion(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.swanCoreType);
        parcel.writeLong(this.swanCoreVersionCode);
        parcel.writeString(this.swanCoreVersionName);
        parcel.writeString(this.swanCorePath);
    }

    public String toString() {
        return "SwanCoreVersion{swanCorePath='" + this.swanCorePath + "', swanCoreVersionName=" + this.swanCoreVersionName + ", swanCoreVersionCode=" + this.swanCoreVersionCode + ", swanCoreType=" + this.swanCoreType + ", isAvailable=" + isAvailable() + '}';
    }
}
